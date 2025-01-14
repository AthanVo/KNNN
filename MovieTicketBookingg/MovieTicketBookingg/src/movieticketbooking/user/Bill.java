package movieticketbooking.user;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;


public class Bill extends javax.swing.JFrame {

  
    int id_user=0;
    String movieName="";
    int id_room=0;
    String showTime="";
    String day="";
    Vector<String> number_seats=new Vector<>();
    double totalBill=0;
    public void getAllData() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking", "root", "");
            PreparedStatement ps;
            ps = conn.prepareStatement("select * from bill where id_user like ?;");
            ps.setInt(1, id_user);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id_bill = rs.getInt("id");
                totalBill = rs.getDouble("total");
                int id_showcalendar = rs.getInt("id_showcalendar");

                ps = conn.prepareStatement("select * from showcalendar where id like ?;");
                ps.setInt(1, id_showcalendar);
                ResultSet r1 = ps.executeQuery();
                r1.next();

                int id_movie = r1.getInt("id_movie");
                id_room = r1.getInt("id_room");
                int id_timer = r1.getInt("id_timer");

                ps = conn.prepareStatement("select * from movie where id like ?;");
                ps.setInt(1, id_movie);
                ResultSet r2 = ps.executeQuery();
                r2.next();
                movieName = r2.getString("name");

                ps = conn.prepareStatement("select * from timer where id like ?;");
                ps.setInt(1, id_timer);
                ResultSet r3 = ps.executeQuery();
                r3.next();
                day = r3.getString("Date");
                int id_hour = r3.getInt("id_hour");

                ps = conn.prepareStatement("select * from hour where id like ?;");
                ps.setInt(1, id_hour);
                ResultSet r4 = ps.executeQuery();
                r4.next();
                showTime = r4.getString("value");

                ps = conn.prepareStatement("select * from seat where id_bill like ?;");
                ps.setInt(1, id_bill);
                ResultSet r5 = ps.executeQuery();
                
                number_seats.clear();  
                
                while (r5.next()) {
                    number_seats.add(r5.getString("number"));
                }

                
                String seatPos = String.join(",", number_seats);
                System.out.println("Vị trí ghế ngồi: " + seatPos);

                
                model.insertRow(model.getRowCount(), new Object[]{
                    id_bill, movieName, showTime, day, id_room, seatPos, totalBill
                });

                // Clear number_seats for the next bill
                number_seats.clear();
            }
        } catch (Exception ex) {
            System.out.println("Kết nối dữ liệu thất bại: " + ex.getMessage());
        }
    }

    
    DefaultTableModel model;
    public Bill(int id) {
        initComponents();
          
        id_user=id;
        this.pack();
        this.setLocationRelativeTo(null);
        this.setEnabled(true);
        this.setTitle("Đặt vé xem phim");
        
        model=(DefaultTableModel)jTable4.getModel();
        getAllData();
       
    }
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane4.setPreferredSize(new java.awt.Dimension(850, 400));

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên phim", "Thời gian", "Ngày", "Phòng", "Chỗ ngồi", "Tổng hóa đơn"
            }
        ));
        jTable4.setFillsViewportHeight(true);
        jTable4.setPreferredSize(new java.awt.Dimension(1000, 500));
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable4.getColumnModel().getColumn(1).setMinWidth(250);
            jTable4.getColumnModel().getColumn(4).setMaxWidth(70);
            jTable4.getColumnModel().getColumn(5).setMinWidth(180);
            jTable4.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Danh sách hóa đơn mua vé");

        jButton1.setText("Trở về");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        Home hm=new Home();
        hm.setVisible(true);
        
    }

    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable4;
    
}
