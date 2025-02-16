
package movieticketbooking.admin;

import movieticketbooking.user.Home;
import movieticketbooking.user.KeyValue;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class EditMovie extends javax.swing.JFrame {

  
    String imagePath="";
    String videoPath="";
    int SelectedMovie=0;
    Vector<KeyValue> id_movies=new Vector<>();
    public void InitCustom(){
        
        
        try{
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking","root","");
        PreparedStatement st=conn.prepareStatement("Select * from movie ;");
        ResultSet r0=st.executeQuery();
        int i=0;
        while(r0.next()){
            int id_movie=r0.getInt("id");
            String name=r0.getString("name");
            if(i++==0){
                SelectedMovie=id_movie;
                imagePath=r0.getString("poster");
            }
            KeyValue kv=new KeyValue(id_movie,name);
            id_movies.add(kv);
             
        }
        }catch(Exception ex)
	{
		System.out.println("Connect ");
	}
         
         for(KeyValue kv:id_movies)
         {
             jComboBox1.addItem(kv);
         }
    }
    public void renderInterface(int id_movie){
        
         try{
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking","root","");
         PreparedStatement st=conn.prepareStatement("Select * from movie where id like ?;");
         st.setInt(1,id_movie);
        ResultSet r0=st.executeQuery();
        while(r0.next())
        {
            String name=r0.getString("name");
            String description=r0.getString("description");
            String director=r0.getString("director");
             imagePath=r0.getString("poster");
            jTextField1.setText(director);
            jTextField2.setText(name);
             jTextArea1.setText(description);
             jTextArea1.setLineWrap(true);
             jLabel3.setIcon(ResizeImage(jLabel3,imagePath));
        }
        }catch(Exception ex)
	{
		System.out.println("Connect ");
	}
         
        
    }
    public EditMovie() {
        initComponents();
          this.pack();
          this.setLocationRelativeTo(null);
          this.setVisible(true);
          InitCustom();
          renderInterface(SelectedMovie);
        
    }

 
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<KeyValue>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        UploadImageBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        UploadDataBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tên phim");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Đạo diễn");

        jLabel3.setBackground(new java.awt.Color(204, 153, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 51, 255));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setText("Giới thiệu");

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        UploadImageBtn.setText("Cập nhật ảnh");
        UploadImageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadImageBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Sửa phim");

        jButton2.setText("Trở lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        UploadDataBtn.setText("Cập nhật dữ liệu");
        UploadDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadDataBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Sửa đoạn trailer phim");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 187, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(113, 113, 113)
                .addComponent(UploadImageBtn)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(UploadDataBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton2))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UploadImageBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(UploadDataBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getItemCount()!=0){
        renderInterface(((KeyValue)jComboBox1.getSelectedItem()).getKey());
        }
        
    }
   
    public void uploadImage()
    {
        JFileChooser file=new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","gif","png");
        file.addChoosableFileFilter(filter);
        int result=file.showSaveDialog(null);
        if(result==JFileChooser.APPROVE_OPTION){
            File selectedFile=file.getSelectedFile();
            String path=selectedFile.getName();
            imagePath=path;
            jLabel3.setIcon(ResizeImage(jLabel3,path));
        }
        else if(result==JFileChooser.CANCEL_OPTION)
        {
            System.out.println("error!");
        }
    }
    public ImageIcon ResizeImage(JLabel jb,String ImagePath){
        ImageIcon MyImage = new ImageIcon(getClass().getResource("/Image/"+ImagePath));
        Image img=MyImage.getImage();
        Image newImg=img.getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image= new ImageIcon(newImg);
        return image;
    }
    private void UploadImageBtnActionPerformed(java.awt.event.ActionEvent evt) {
        uploadImage();
    }
    private void UploadDataBtnActionPerformed(java.awt.event.ActionEvent evt) {
          try{
             System.out.println(imagePath+","+videoPath);
           
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8","root","");
         PreparedStatement st=conn.prepareStatement("update movie set name=?,director=?,description=?,poster=?,trailer=? where id=? ;");
         st.setString(1, jTextField2.getText());
         st.setString(2,  jTextField1.getText());
         st.setString(3,  jTextArea1.getText());
         st.setString(4, imagePath);
         st.setString(5, videoPath);
         st.setInt(6,((KeyValue)jComboBox1.getSelectedItem()).getKey());
         st.executeUpdate();
           JOptionPane.showMessageDialog(this, "Cập nhật phim thành công!");
          jComboBox1.removeAllItems();
          id_movies.removeAllElements();
          InitCustom();
        }catch(Exception ex)
	{
		System.out.println("Connect fail");
                ImageIcon iconic=new ImageIcon("error.png");
                 JOptionPane.showMessageDialog(this, "Cập nhật phim thất bại!"," error!",JOptionPane.INFORMATION_MESSAGE,iconic);
	}
                
      
        
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        manage hm=new manage();
        hm.setVisible(true);
        
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
          JFileChooser file=new JFileChooser();
    file.setCurrentDirectory(new File(System.getProperty("user.dir")));
    FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","mp4","png");
    file.addChoosableFileFilter(filter);
    int result=file.showSaveDialog(null);
    if(result==JFileChooser.APPROVE_OPTION){
	File selectedFile=file.getSelectedFile();
	String path=selectedFile.getName();
        videoPath=path;
    }
    else if(result==JFileChooser.CANCEL_OPTION){
	System.out.println("Phim lỗi");
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
            java.util.logging.Logger.getLogger(EditMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditMovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UploadDataBtn;
    private javax.swing.JButton UploadImageBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<KeyValue> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
