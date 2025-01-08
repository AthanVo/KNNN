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
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Create GUI components
        jLabel1 = new JLabel("Movie Name:");
        jLabel2 = new JLabel("Director:");
        jLabel3 = new JLabel("Description:");
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextArea1 = new JTextArea(5, 20);
        jScrollPane1 = new JScrollPane(jTextArea1);
        UploadBtn = new JButton("Choose Poster for Movie");
        BackBtn = new JButton("Back");
        AddBtn = new JButton("Add Movie");
        jButton1 = new JButton("Add Trailer");
        jLabel4 = new JLabel("IMAGE", SwingConstants.CENTER);
        jLabel5 = new JLabel("Add New Movie", SwingConstants.CENTER);

        // Layout
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Movie Name Label and TextField
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(jLabel1, gbc);
        gbc.gridx = 1;
        add(jTextField1, gbc);

        // Director Label and TextField
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(jLabel2, gbc);
        gbc.gridx = 1;
        add(jTextField2, gbc);

        // Description Label and TextArea
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(jLabel3, gbc);
        gbc.gridx = 1;
        add(jScrollPane1, gbc);

        // Upload Poster Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(UploadBtn, gbc);
        gbc.gridx = 1;
        add(jLabel4, gbc);

        // Upload Trailer Button
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(jButton1, gbc);

        // Add Movie Button
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(AddBtn, gbc);

        // Back Button
        gbc.gridx = 1;
        add(BackBtn, gbc);

        // Add Movie Title
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(jLabel5, gbc);

        // Action Listeners
        UploadBtn.addActionListener(evt -> uploadImage());
        BackBtn.addActionListener(evt -> backToManage());
        AddBtn.addActionListener(evt -> addMovie());
        jButton1.addActionListener(evt -> uploadVideo());

        pack();
    }

    private void uploadImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "gif");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imageName = selectedFile.getName();
            jLabel4.setText(imageName);
        }
    }

    private void uploadVideo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Videos", "mp4", "avi", "mkv");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            videoName = selectedFile.getName();
            JOptionPane.showMessageDialog(this, "Trailer selected: " + videoName);
        }
    }

    private void addMovie() {
        String movieName = jTextField1.getText();
        String director = jTextField2.getText();
        String description = jTextArea1.getText();

        if (movieName.isEmpty() || director.isEmpty() || description.isEmpty() || imageName.isEmpty() || videoName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields and upload the necessary files.", "Error", JOptionPane.ERROR_MESSAGE);
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

            JOptionPane.showMessageDialog(this, "Movie added successfully.");
            clearFields();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to add movie: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextArea1.setText("");
        jLabel4.setText("IMAGE");
        imageName = "";
        videoName = "";
    }

    private void backToManage() {
        this.dispose();  // Đóng cửa sổ hiện tại
        new manage().setVisible(true);  // Mở lại màn hình Admin
    }

    // GUI Component Variables
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5;
    private JTextField jTextField1, jTextField2;
    private JTextArea jTextArea1;
    private JScrollPane jScrollPane1;
    private JButton UploadBtn, BackBtn, AddBtn, jButton1;
}
