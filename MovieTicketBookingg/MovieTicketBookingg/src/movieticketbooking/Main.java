package movieticketbooking;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import movieticketbooking.user.*;
import movieticketbooking.admin.*;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Main() throws UnknownHostException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Vẽ hình nền cho contentPane
                ImageIcon backgroundImage = new ImageIcon("E:/HinhMovie/background.jpg");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);

        loadIcons();
    }

    private void initComponents() {
        jLabel1 = new JLabel("Admin");
        jLabel1.setBounds(50, 200, 100, 30);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        contentPane.add(jLabel1);

        jLabel2 = new JLabel("Customer");
        jLabel2.setBounds(300, 200, 100, 30);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        contentPane.add(jLabel2);

        jLabel3 = new JLabel();
        jLabel3.setBounds(150, 100, 100, 30);
        contentPane.add(jLabel3);

        jLabel4 = new JLabel();
        jLabel4.setBounds(250, 100, 100, 30);
        contentPane.add(jLabel4);

        jLabel5 = new JLabel();
        jLabel5.setBounds(100, 10, 250, 150);
        contentPane.add(jLabel5);
    }

    private void loadIcons() {
        // Đọc hình ảnh từ thư mục trên máy tính
        ImageIcon MyImage = new ImageIcon("E:/HinhMovie/manager.jpg");
        Image img = MyImage.getImage();
        // Thay đổi kích thước hình ảnh
        Image resizedImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(resizedImg);
        jLabel1.setIcon(image);

        MyImage = new ImageIcon("E:/HinhMovie/user.jpg");
        img = MyImage.getImage();
        resizedImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        image = new ImageIcon(resizedImg);
        jLabel2.setIcon(image);

        // Cập nhật hình ảnh cho jLabel5 (có thể là logo)
        MyImage = new ImageIcon("E:/HinhMovie/cgv.jpg");
        img = MyImage.getImage();
        resizedImg = img.getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        image = new ImageIcon(resizedImg);
        jLabel5.setIcon(image);
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
        Login hm = new Login();
        hm.setVisible(true);
    }

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
        Home hm = new Home();
        hm.setVisible(true);
    }

    public ImageIcon ResizeImage(JLabel j, String ImagePath) {
        ImageIcon MyImage = new ImageIcon(getClass().getResource("/resources/" + ImagePath));
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(j.getWidth(), j.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}
