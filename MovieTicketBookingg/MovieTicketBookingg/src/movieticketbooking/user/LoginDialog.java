
package movieticketbooking.user;

import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import movieticketbooking.Main;
import movieticketbooking.admin.manage;


public class LoginDialog extends javax.swing.JFrame {

   
    String direction="";
    public LoginDialog(String d,String user) {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        direction=d;
        jTextField1.setText(user);
    
    }       
            
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đặt vé xem phim");

        jLabel1.setText("Tài khoản");

        jLabel2.setText("Mật khẩu");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jButton1.setText("Đăng nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Trở lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 51));
        jLabel3.setText("Đăng nhập");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setText("Đăng ký");
        jLabel4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel4AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jPasswordField1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(57, 57, 57))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(144, 144, 144))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44))
        );

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
    public boolean checkUserBelongToSessionTable(int id){
        try
        {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8","root","");
        PreparedStatement ps=con.prepareStatement("Select * from id_session where id_user like ? and privateIpAdress like ?");
        ps.setInt(1,id);
        ps.setString(2,getIpAdress());
        ResultSet rs=ps.executeQuery();
            if(!rs.next()){
            return false;
            }
         }
        catch(Exception ex)
         {
        System.out.println("Kết nối thất bại");
        }     
        return true;
    }
    public int checkCorrectInfor(String username,String password){
        try
    {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8","root","");
        PreparedStatement ps=con.prepareStatement("Select * from user where username like ? and password like ?");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs=ps.executeQuery();
        // user was founded
        if(rs.next()){
           
            int id_user=rs.getInt("id");
            return id_user; 
        }
     }
    catch(Exception ex)
    {
        System.out.println("Kết nối thất bại");
    }     
        return 0;
    }
    public String getIpAdress() throws UnknownHostException{
        InetAddress localhost = InetAddress.getLocalHost(); 
        return localhost.getHostAddress().trim(); 
       
    }
    public void Login(){
           String username=jTextField1.getText();
           String password=String.valueOf(jPasswordField1.getPassword());
     int id_user=checkCorrectInfor(username,password);
     if(id_user!=0){
        JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
        try{
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieTicketBooking?useUnicode=true&characterEncoding=UTF-8","root","");
         PreparedStatement ps;
         if(checkUserBelongToSessionTable(id_user)){
              ps=con.prepareStatement("update id_session set type = 1 where id_user like ? and privateIpAdress like ?");
              ps.setInt(1, id_user);
              ps.setString(2, getIpAdress());
              ps.executeUpdate();
              System.out.println("belong");
         }
         else{
              ps=con.prepareStatement("insert into id_session(id_user,type,privateIpAdress) values(?,?,?)");
              ps.setInt(1, id_user);
              ps.setInt(2, 1);
              ps.setString(3, getIpAdress());
              ps.executeUpdate();
         }
        }
        catch(Exception ex){
         System.out.println("Thất bại");
        }
        if(direction=="home"){
            this.setVisible(false);
         Home hm=new Home();
        hm.setVisible(true);
        }
        else if(direction=="booking"){
            this.setVisible(false);
         Booking bk=new Booking();
        bk.setVisible(true);
        }
        else if(direction=="manage"){
            this.setVisible(false);
         manage bk=new manage();
        bk.setVisible(true);
        }
        }
     else{
            ImageIcon iconic=new ImageIcon("error.png");
	JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu"," error!",JOptionPane.INFORMATION_MESSAGE,iconic);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Login();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(direction=="booking"){
             this.setVisible(false);
         Booking bk=new Booking();
        bk.setVisible(true);
       }
       else if(direction=="home"){
             this.setVisible(false);
         Home hm=new Home();
        hm.setVisible(true);
       }
       else if(direction=="manage"){
        this.setVisible(false);
        Main lg;
           try {
               lg = new Main();
               lg.setVisible(true);
           } catch (UnknownHostException ex) {
               Logger.getLogger(LoginDialog.class.getName()).log(Level.SEVERE, null, ex);
           }
      
       }
               
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4AncestorAdded(javax.swing.event.AncestorEvent evt) {

    }

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
         this.setVisible(false);
         SignupDialog sd=new SignupDialog(direction);
         sd.setVisible(true);        
    }
    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           Login();
       }
    }

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {
          if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           Login();
       }
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
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
