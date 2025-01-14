package movieticketbooking.admin;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;

public class AddMovie extends javax.swing.JFrame {

    private String imageName = "";
    private String videoName = "";

    public AddMovie() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null); // Đặt cửa sổ hiển thị ở giữa màn hình
        this.setVisible(true); // Hiển thị giao diện
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Tạo giao diện
        jLabel1 = new JLabel("Tên phim:");
        jLabel2 = new JLabel("Đạo diễn:");
        jLabel3 = new JLabel("Giới thiệu:");
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextArea1 = new JTextArea(5, 20);
        jScrollPane1 = new JScrollPane(jTextArea1);
        UploadBtn = new JButton("Chọn ảnh cho phim");
        BackBtn = new JButton("Trở lại");
        AddBtn = new JButton("Thêm phim");
        jButton1 = new JButton("Thêm đoạn giới thiệu phim");
        jLabel4 = new JLabel("Ảnh", SwingConstants.CENTER); // Nhãn trung tâm cho ảnh
        jLabel5 = new JLabel("Thêm ảnh mới", SwingConstants.CENTER); // Nhãn trung tâm cho tiêu đề

        // Layout
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Đặt hành động đóng cửa sổ
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Đặt layout theo chiều ngang
        gbc.insets = new Insets(10, 10, 10, 10); // Khoảng cách giữa các thành phần

        // Nhãn tên phim và ô nhập
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(jLabel1, gbc);
        gbc.gridx = 1;
        add(jTextField1, gbc);

        // Nhãn đạo diễn và ô nhập
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(jLabel2, gbc);
        gbc.gridx = 1;
        add(jTextField2, gbc);

        // Nhãn giới thiệu và ô nhập
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(jLabel3, gbc);
        gbc.gridx = 1;
        add(jScrollPane1, gbc);

        // Nút chọn ảnh
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(UploadBtn, gbc);
        gbc.gridx = 1;
        add(jLabel4, gbc);

        // Nút chọn video
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(jButton1, gbc);

        // Nút thêm phim
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(AddBtn, gbc);

        // Nút trở lại
        gbc.gridx = 1;
        add(BackBtn, gbc);

        // Tiêu đề thêm phim
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2; // Chiếm 2 cột
        add(jLabel5, gbc);

        // Các hành động cho các nút
        UploadBtn.addActionListener(evt -> uploadImage()); // Hành động khi bấm nút chọn ảnh
        BackBtn.addActionListener(evt -> backToManage()); // Hành động khi bấm nút trở lại
        AddBtn.addActionListener(evt -> addMovie()); // Hành động khi bấm nút thêm phim
        jButton1.addActionListener(evt -> uploadVideo()); // Hành động khi bấm nút chọn video

        pack();
    }

    private void uploadImage() {
        JFileChooser fileChooser = new JFileChooser(); // Hộp thoại chọn tệp
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir"))); // Thư mục hiện tại
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "gif"); // Bộ lọc ảnh
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) { // Nếu người dùng chọn ảnh
            File selectedFile = fileChooser.getSelectedFile();
            imageName = selectedFile.getName();
            jLabel4.setText(imageName); // Hiển thị tên ảnh
        }
    }

    private void uploadVideo() {
        JFileChooser fileChooser = new JFileChooser(); // Hộp thoại chọn tệp
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir"))); // Thư mục hiện tại
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Videos", "mp4", "avi", "mkv"); // Bộ lọc video
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) { // Nếu người dùng chọn video
            File selectedFile = fileChooser.getSelectedFile();
            videoName = selectedFile.getName();
            JOptionPane.showMessageDialog(this, "Trailer được chọn: " + videoName); // Thông báo
        }
    }

    private void addMovie() {
        String movieName = jTextField1.getText(); // Lấy tên phim
        String director = jTextField2.getText(); // Lấy đạo diễn
        String description = jTextArea1.getText(); // Lấy mô tả

        if (movieName.isEmpty() || director.isEmpty() || description.isEmpty() || imageName.isEmpty() || videoName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đủ thông tin và tải lên các tệp cần thiết.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking", "root", "")) {
            String sql = "INSERT INTO movie (name, director, description, poster, trailer) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, movieName);
            pstmt.setString(2, director);
            pstmt.setString(3, description);
            pstmt.setString(4, imageName);
            pstmt.setString(5, videoName);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Phim được thêm thành công.");
            clearFields(); // Xóa các trường dữ liệu

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Thêm phim thất bại: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        jTextField1.setText(""); // Xóa tên phim
        jTextField2.setText(""); // Xóa đạo diễn
        jTextArea1.setText(""); // Xóa mô tả
        jLabel4.setText("IMAGE"); // Reset nhãn ảnh
        imageName = ""; // Reset tên ảnh
        videoName = ""; // Reset tên video
    }

    private void backToManage() {
        this.dispose();  // Đóng cửa sổ hiện tại
        new manage().setVisible(true);  // Mở lại màn hình Admin
    }

    // Giao diện người dùng biến thành phần
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5;
    private JTextField jTextField1, jTextField2;
    private JTextArea jTextArea1;
    private JScrollPane jScrollPane1;
    private JButton UploadBtn, BackBtn, AddBtn, jButton1;
}
