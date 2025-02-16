package movieticketbooking.user;

import movieticketbooking.admin.AddMovie;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import movieticketbooking.Main;
import movieticketbooking.admin.EditMovie;
import movieticketbooking.admin.SetSchedule;

public class Home extends javax.swing.JFrame {
    Timer tm;
    int x=0;
    String[] list={
        "botubaothu.jpg",
        "madong.jpg",
        "hanhphuc.jpg"
    };
     int id_user=0;
     String name="";
    public Home() {
        initComponents();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        if(getSessionIds()!=0){
        id_user=getSessionIds();
        try{
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketooking?useUnicode=true&characterEncoding=UTF-8","root","");
             PreparedStatement ps=con.prepareStatement("select * from user where id like ?");
             ps.setInt(1, id_user);
             ResultSet rs=ps.executeQuery();
             while(rs.next()){
                 name=rs.getString("username");
             }
        }catch(Exception ex){
            
        }
        // creat name user
        jLabel2.setText("<html>"+name+"</html>");
        // creat exit button
        JButton btnExit=new JButton("Thoát");
        int btnWidth=50;
        int btnHeight=20;
        int xLocation=20;
        int yLocation=30;
        btnExit.setBounds(xLocation,yLocation, btnWidth, btnHeight);
        btnExit.setMargin(new Insets(0,0,0,0));
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8","root","");
                PreparedStatement ps=con.prepareStatement("update id_session set type=0 where id_user = ? and privateIpAdress=?");
                ps.setInt(1, id_user);
                System.out.println(getIpAdress());
                ps.setString(2, getIpAdress());
                ps.executeUpdate();
                setVisible(false);
                Main mn=new Main();
                mn.setVisible(true);
                }
                catch(Exception ex){
                    System.out.println("Thất bại");
                }
            }
            }); 
         add(btnExit);
        }
        else{
        JButton btnLogin=new JButton("Tài khoản");
        int btnWidth=80;
        int btnHeight=30;
        int xLocation=20;
        int yLocation=20;
        btnLogin.setBounds(xLocation,yLocation, btnWidth, btnHeight);
         btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginForm();
            }
            });
         add(btnLogin);
        }
     
       
        //image slide show
        SetImageSize(2);
        tm=new Timer(8000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            SetImageSize(x);
            x+=1;
            if(x>=list.length){
            x=0;
            } 
            }
        });
        tm.start();
        //
    }
    public void SetImageSize(int i){
        ImageIcon MyImage = new javax.swing.ImageIcon(getClass().getResource("/Image/"+list[i]));
        Image img=MyImage.getImage();
        Image newImg=img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image= new ImageIcon(newImg);
        jLabel1.setIcon(image);
    }
   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đặt vé xem phim");

        jButton3.setText("Đặt vé");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Hóa đơn");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(34, 34, 34))
        );

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Chào mừng đến với TTP");

        jButton1.setText("Trở lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(56, 56, 56)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
        Booking bk=new Booking();
        bk.setVisible(true);
        
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        int id_user=getSessionIds();
        if(id_user==0)
        {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn phải đăng nhập trước rồi mới được đặt vé! Bạn muốn đăng nhập chứ?","Cảnh báo",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION)
        {
            this.setVisible(false);
            LoginDialog ld=new LoginDialog("home","");
            ld.setVisible(true);
        }
        }
        else{
             this.setVisible(false);
             Bill b=new Bill(id_user);
             b.setVisible(true);  
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        Main m;
        try {
            m = new Main();
            m.setVisible(true);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    public String getIpAdress() throws UnknownHostException{
        InetAddress localhost = InetAddress.getLocalHost(); 
        return localhost.getHostAddress().trim(); 
    }
    public int getSessionIds(){
        try{
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8","root","");
        PreparedStatement ps=con.prepareStatement("select * from id_session where type like 1 and privateIpAdress like ?");
        ps.setString(1,getIpAdress());
        ResultSet rs =ps.executeQuery();
        while(rs.next()){
            return rs.getInt("id_user");
        }
        }catch(Exception ex){
            System.out.println("Kết nối thất bại");
        }
        return 0;
    }
    public void showLoginForm(){
        this.setVisible(false);
        LoginDialog lg=new LoginDialog("home","");
        lg.setVisible(true);
    }    
     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    
}
