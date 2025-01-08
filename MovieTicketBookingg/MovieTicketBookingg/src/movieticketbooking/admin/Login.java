package movieticketbooking.admin;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import movieticketbooking.Main;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPasswordField jPasswordField1;
    private JTextField jTextField1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {

        jLabel1 = new JLabel("Id");
        jLabel2 = new JLabel("Pass");
        jTextField1 = new JTextField();
        jButton1 = new JButton("Login");
        jButton2 = new JButton("Back");
        jLabel3 = new JLabel("Admin login");
        jPasswordField1 = new JPasswordField();

        jButton1.addActionListener(evt -> login());
        jButton2.addActionListener(evt -> goBack());

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addComponent(jPasswordField1)))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2)
                        .addComponent(jLabel3))
                    .addGap(58, 58, 58)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(47, 47, 47)
                    .addComponent(jButton1)
                    .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }

    private void login() {
        boolean checkLogined = false;
        String username = jTextField1.getText();
        String password = String.valueOf(jPasswordField1.getPassword());

        // Sử dụng try-with-resources để đóng kết nối tự động
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                checkLogined = true;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed: " + ex.getMessage());
        }

        if (checkLogined) {
            this.setVisible(false);
            manage mn = new manage();
            mn.setVisible(true);
        } else {
            ImageIcon iconic = new ImageIcon("error.png");
            JOptionPane.showMessageDialog(this, "Incorrect username or password", "Error!", JOptionPane.INFORMATION_MESSAGE, iconic);
        }
    }

    private void goBack() {
        this.setVisible(false);
        try {
            Main m = new Main();
            m.setVisible(true);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
