
package movieticketbooking.user;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.Vector;


public class BookSuccess extends javax.swing.JFrame {
    String movieName="";
    String hour="";
    String date="";
    int room=0;
    Vector<String> number_seats=new Vector<>();
    String price="70000";
    double total=0;
    
    public BookSuccess() {
    }
     public BookSuccess(int id_bill) {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
         getBillData(id_bill);
         renderBill();
    }
     public void getBillData(int id_bill){
          try
        {
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking","root","");
        PreparedStatement ps;
        ps = conn.prepareStatement("SELECT * FROM bill WHERE id = ?;");
         // get id bill
         ps.setInt(1, id_bill);
         ResultSet rs= ps.executeQuery();
         rs.next();
         // get bill total
         total=rs.getDouble("total");
         // get id showcalendar
         int id_showcalendar=rs.getInt("id_showcalendar");
          ps=conn.prepareStatement("select * from showcalendar where id like ?;");   
          ps.setInt(1, id_showcalendar);
          ResultSet r1= ps.executeQuery();
          r1.next();
          // get all data showcalendar 
          int id_movie=r1.getInt("id_movie");
          int id_room=r1.getInt("id_room");
          int id_timer=r1.getInt("id_timer");
          //get room number
           room=id_room;
          ps=conn.prepareStatement("select * from movie where id like ?;");   
          // get movie name
          ps.setInt(1, id_movie);
          ResultSet r2= ps.executeQuery();
          r2.next();
          movieName=r2.getString("name");
           ps=conn.prepareStatement("select * from timer where id like ?;");
           // get day and hour
          ps.setInt(1, id_timer);
          ResultSet r3= ps.executeQuery();
          r3.next();
          date=r3.getString("Date");
          // get day
          int id_hour=r3.getInt("id_hour");
           ps=conn.prepareStatement("select * from hour where id like ?;");  
           // get hour
          ps.setInt(1, id_hour);
          ResultSet r4= ps.executeQuery();
          r4.next();
          hour=r4.getString("value");
          // get seat position
          ps = conn.prepareStatement("SELECT * FROM seat WHERE id_bill = ?");
          ps.setInt(1, id_bill);
          ResultSet r5 = ps.executeQuery();
          while (r5.next()) {
              number_seats.add(r5.getString("number"));
          }

        }
	catch(Exception ex)
	{
		System.out.println("Kết nối thất bại");
	}
     }
     public void renderBill() {
    	    // Hiển thị thông tin phim, giờ chiếu, phòng chiếu
    	    jLabel7.setText(movieName);
    	    jLabel8.setText(hour);
    	    jLabel9.setText(Integer.toString(room));

    	    // Kiểm tra xem list ghế có chứa dữ liệu hay không
    	    if (number_seats.isEmpty()) {
    	        jLabel10.setText("Không có ghế nào được chọn");
    	    } else {
    	        StringBuilder seatPos = new StringBuilder();
    	        for (int i = 0; i < number_seats.size(); i++) {
    	            seatPos.append(number_seats.get(i));
    	            if (i < number_seats.size() - 1) {
    	                seatPos.append(", ");  // Thêm dấu phẩy giữa các ghế
    	            }
    	        }
    	        jLabel10.setText(seatPos.toString()); // Cập nhật vào giao diện
    	    }

    	    // Hiển thị giá vé và tổng tiền
    	    jLabel11.setText(price);
    	    jLabel13.setText(Double.toString(total));
    	}


   
 
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đặt vé xem phim");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Chúc mừng bạn đã đặt vé thành công");

        jLabel2.setText("Tên phim");

        jLabel3.setText("Suất chiếu");

        jLabel4.setText("Phòng");

        jLabel5.setText("Ghế");

        jLabel6.setText("Giá vé");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel12.setText("Total bill");

        jLabel13.setText("jLabel7");

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(19, 19, 19))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(7, 7, 7))
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jButton1)))
                .addGap(0, 94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addGap(59, 59, 59))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.setVisible(false);
        Home hm=new Home();
        hm.setVisible(true);
       
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookSuccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookSuccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookSuccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookSuccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookSuccess().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
   
}
