package movieticketbooking.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;

public class BookSeat extends javax.swing.JFrame {

    private Vector<Seat> selectedSeats = new Vector<>();
    private JPanel seatPanel = new JPanel();
    private int[][] removedSeats;
    private int maxColumn;
    private int maxRow;
    private int userId;
    private int[][] bookedSeats;
    private int showCalendarId;
    private int timerId;
    private int roomId;
    private int roomNumber;

    public BookSeat(int showCalendarId, int userId) {
        initComponents();
        this.showCalendarId = showCalendarId;
        this.userId = userId;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        loadRoomInfo();
        initSeatArrays();
        renderSeatLayout();
        bookingButton(); // Gọi phương thức thêm nút "Book"
    }

    private void loadRoomInfo() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking", "root", "")) {
            String sql = "SELECT r.*, sc.id_timer FROM room r " +
                         "JOIN showcalendar sc ON sc.id_room = r.id " +
                         "WHERE sc.id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, showCalendarId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                roomId = rs.getInt("id");
                roomNumber = rs.getInt("number");
                maxRow = rs.getInt("rowNums");
                maxColumn = rs.getInt("colNums");
                timerId = rs.getInt("id_timer"); // Lấy giá trị timerId

                jLabel1.setText("Room: " + roomNumber);

                // Thêm log để kiểm tra giá trị timerId
                System.out.println("Timer ID loaded: " + timerId);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void bookingButton() {
        JButton btnBooking = new JButton("Đặt vé");
        btnBooking.setBounds(450, 600, 100, 30); // Vị trí cố định
        btnBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadRoomInfo();

                int billId = 0;
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieTicketBooking", "root", "")) {
                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO bill (id_showcalendar, quantity, total, id_user) VALUES (?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                    );
                    ps.setInt(1, showCalendarId);
                    ps.setInt(2, selectedSeats.size());
                    ps.setDouble(3, selectedSeats.size() * 70000);
                    ps.setInt(4, userId);
                    ps.executeUpdate();
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        billId = rs.getInt(1);
                    }

                    for (Seat seat : selectedSeats) {
                    	System.out.println("Inserting seat: " + seat.getNumber() + " with Timer ID: " + timerId); // Log giá trị timerId
                        PreparedStatement seatPs = con.prepareStatement(
                            "INSERT INTO seat (number, id_room, id_timer, id_bill, rowIndex, colIndex) VALUES (?, ?, ?, ?, ?, ?)"
                        );
                        seatPs.setString(1, seat.getNumber());
                        seatPs.setInt(2, roomId);
                        seatPs.setInt(3, timerId);
                        seatPs.setInt(4, billId);
                        seatPs.setInt(5, seat.getRow());
                        seatPs.setInt(6, seat.getCol());
                        seatPs.executeUpdate();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                setVisible(false);
                new BookSuccess(billId).setVisible(true);
            }
        });

        this.add(btnBooking);
        this.revalidate(); // Cập nhật giao diện
        this.repaint();
    }

    private void initSeatArrays() {
        bookedSeats = new int[maxRow][maxColumn];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxColumn; j++) {
                bookedSeats[i][j] = 0;
            }
        }

        removedSeats = new int[maxRow][maxColumn];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxColumn; j++) {
                removedSeats[i][j] = 1;
            }
        }

        loadRemovedSeats();
    }

    private void loadRemovedSeats() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieTicketBooking", "root", "")) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM removedseats WHERE id_room = ?");
            ps.setInt(1, roomId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int rowIndex = rs.getInt("rowIndex");
                int colIndex = rs.getInt("colIndex");
                removedSeats[rowIndex][colIndex] = 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void renderSeatLayout() {
        seatPanel.setBounds(40, 160, 900, 450);
        seatPanel.setLayout(new GridLayout(maxRow, maxColumn, 4, 2));
        this.add(seatPanel);

        JButton[][] buttons = new JButton[maxRow][maxColumn];
        int asciiCode = 65;

        for (int i = 0; i < maxRow; i++) {
            char rowChar = (char) asciiCode;
            for (int j = 0; j < maxColumn; j++) {
                String seatLabel = rowChar + Integer.toString(j + 1);
                buttons[i][j] = new JButton(seatLabel);
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 10));
                buttons[i][j].setMargin(new Insets(0, 0, 0, 0));

                final JButton button = buttons[i][j];
                final Seat seat = new Seat(seatLabel, i, j);

                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!selectedSeats.contains(seat)) {
                            button.setBackground(Color.green);
                            selectedSeats.add(seat);
                        } else {
                            button.setBackground(null);
                            selectedSeats.remove(seat);
                        }
                    }
                });

                if (removedSeats[i][j] == 0) {
                    buttons[i][j].setVisible(false);
                } else if (bookedSeats[i][j] == 1) {
                    buttons[i][j].setEnabled(false);
                }

                seatPanel.add(buttons[i][j]);
            }
            asciiCode++;
        }

        seatPanel.revalidate();
        seatPanel.repaint();
    }

    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đặt vé xem phim");
        setPreferredSize(new java.awt.Dimension(1000, 700));

        jButton1.setText("Trở lại");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Phòng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(507, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new Booking().setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new BookSeat(1, 1).setVisible(true));
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
}
