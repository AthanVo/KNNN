
package movieticketbooking.admin;
import movieticketbooking.user.Home;
import movieticketbooking.user.KeyValue;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.sql.*;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class SetSchedule extends javax.swing.JFrame {
    Connection conn;
   
    Vector<String> list = new Vector<>();
    Vector<Integer> id_hours=new Vector<>();
    public SetSchedule() {
        initComponents();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setEnabled(true);
       
        ChangeButtonStatus(false);
       
	try{
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking","root","");
	Statement st=conn.createStatement();
        String q="Select * from movie;";
        ResultSet rs=st.executeQuery(q);
        while(rs.next()){
           jComboBox1.addItem(new KeyValue(rs.getInt("id"),rs.getString("name")));
        }
        q="Select * from room;";
        rs=st.executeQuery(q);
        while(rs.next()){
           jComboBox2.addItem(new KeyValue(rs.getInt("id"),rs.getString("number")));
        }
	}catch(Exception ex)
	{
		System.out.println("Kết nối thất bại");
	}
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<KeyValue>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<KeyValue>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        SetButton = new javax.swing.JButton();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        RefreshButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hệ thống đặt vé xem phim");

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 320));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Chọn phim");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Chọn phòng");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Thiết lập ngày");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Thiết lập thời gian");

        jButton3.setText("11:25");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("13:30");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("12:25");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("15:00");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("16:30");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("18:15");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("20:00");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setText("23:00");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton2.setText("9:15");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("8:00");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton10.setText("21:25");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton6)
                            .addComponent(jButton9))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton11)))
        );

        SetButton.setText("Thiết lập");
        SetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SetButtonMouseClicked(evt);
            }
        });

        dateChooserCombo1.setCurrentView(new datechooser.view.appearance.AppearancesList("Grey",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateChooserCombo1.setLocale(new java.util.Locale("vi", "", ""));
    dateChooserCombo1.addCommitListener(new datechooser.events.CommitListener() {
        public void onCommit(datechooser.events.CommitEvent evt) {
            dateChooserCombo1OnCommit(evt);
        }
    });

    RefreshButton.setBackground(new java.awt.Color(255, 204, 204));
    RefreshButton.setText("Tải lại");
    RefreshButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            RefreshButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(SetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                            .addComponent(RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(SetButton)
                .addComponent(RefreshButton))
            .addGap(25, 25, 25))
    );

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel5.setText("Thiết lập lịch chiếu");

    jButton13.setText("Trở lại");
    jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton13MouseClicked(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(77, 77, 77)))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(8, 8, 8)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton13)
                .addComponent(jLabel5))
            .addGap(18, 18, 18)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(52, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void TurnOffButton(int id){
        if(id==1){
            jButton1.setEnabled(false);
            jButton1.setBackground(null);
        }
        else if(id==2){
            jButton2.setEnabled(false);
            jButton2.setBackground(null);
        }
         else if(id==3){
            jButton3.setEnabled(false);
            jButton3.setBackground(null);
        }
        
         else if(id==4){
            jButton4.setEnabled(false);
            jButton4.setBackground(null);
        }
         else if(id==5){
            jButton5.setEnabled(false);
            jButton5.setBackground(null);
        }
         else if(id==6){
            jButton6.setEnabled(false);
            jButton6.setBackground(null);
        }
         else if(id==7){
            jButton7.setEnabled(false);
            jButton7.setBackground(null);
        }
         else if(id==8){
            jButton8.setEnabled(false);
            jButton8.setBackground(null);
        }
         else if(id==9){
            jButton9.setEnabled(false);
            jButton9.setBackground(null);
        }
         else if(id==10){
            jButton10.setEnabled(false);
            jButton10.setBackground(null);
        }
         else if(id==11){
              jButton11.setEnabled(false);
              jButton11.setBackground(null);
         }
    }
    public void ChangeButtonStatus(Boolean f){
        jButton1.setEnabled(f);
        jButton2.setEnabled(f);
        jButton3.setEnabled(f);
        jButton4.setEnabled(f);
        jButton5.setEnabled(f);
        jButton6.setEnabled(f);
        jButton7.setEnabled(f);
        jButton8.setEnabled(f);
        jButton9.setEnabled(f);
        jButton10.setEnabled(f);
        jButton11.setEnabled(f);
    }
    public void cleanHour(){
        ChangeButtonStatus(true);
        Vector<Integer> listId=new Vector<>();
        
        String day=dateChooserCombo1.getText();;
        try{
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking","root","");
         PreparedStatement st=conn.prepareStatement("Select * from showcalendar where id_room like ?;");
         st.setString(1,jComboBox2.getSelectedItem().toString());
         // select all time period in the day on selected room
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
              
              st=conn.prepareStatement("Select * from timer where Date like ? and id like ?;");
              st.setString(1,day);
              st.setInt(2,rs.getInt("id_timer"));
              ResultSet r1=st.executeQuery();
              while(r1.next())
              {
                 
                  listId.add(r1.getInt("id_hour"));
              }
        }
         st=conn.prepareStatement("Select * from showcalendar where id_movie like ?;");
         st.setInt(1,((KeyValue)jComboBox1.getSelectedItem()).getKey());
         // select all time period in the day on selected room
        ResultSet r0=st.executeQuery();
        while(r0.next())
        {
            System.out.println(jComboBox2.getSelectedItem().toString());
            System.out.println(day);
              st=conn.prepareStatement("Select * from timer where id like ? and Date like ?;");
              st.setInt(1,r0.getInt("id_timer"));
              st.setString(2, day);
              ResultSet r2=st.executeQuery();
              while(r2.next())
              {
                  listId.add(r2.getInt("id_hour"));
              }
        }
	}
        catch(Exception ex)
	{
		System.out.println("Connect fail");
	}
        for (Integer number : listId)
        { 
            
            TurnOffButton(number);
        }  
    }
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
       
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          if(jButton1.getBackground().getGreen()==255){
            jButton1.setBackground(null);
            removeID(id_hours,1);
        }
        else{
             jButton1.setBackground(Color.green);
             id_hours.add(1);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    public void removeID(Vector<Integer> x,int id){
        int i=0;
             while(i<x.size()) {
                 if(x.elementAt(i)==id){
                     x.remove(i);
                     break;
                 }
                 i++;
             }
    }
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
      
           
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
       
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseClicked

    private void SetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetButtonMouseClicked
        // set schedule and push to database
        Vector<Integer> id_timers=new Vector<>();
        if(id_hours.isEmpty()){
         ImageIcon iconic=new ImageIcon("error.png");
	JOptionPane.showMessageDialog(this,"You have not select time"," Warning!",JOptionPane.INFORMATION_MESSAGE,iconic);
        }
        else{
        try
        {
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking","root","");
        PreparedStatement ps;
         for (Integer number : id_hours) 
         { 
                  boolean checked=true;
                  //get id_timer same with days and hours input
                  ps=conn.prepareStatement("select * from timer where Date like ? and id_hour like ?;");   
                  ps.setString(1,dateChooserCombo1.getText());
                  ps.setInt(2,number);
                  ResultSet rs=ps.executeQuery();
                  while(rs.next())
                  {
                      id_timers.add(rs.getInt("id"));
                      checked=false;
                  }
                  if(checked)
                  {
                  ps=conn.prepareStatement("insert into timer(Date,id_hour) value(?,?);",Statement.RETURN_GENERATED_KEYS);   
                  ps.setString(1,dateChooserCombo1.getText());
                  ps.setInt(2,number);
                  ps.executeUpdate();
                  // get id of timer after created
                  ResultSet lastid = ps.getGeneratedKeys();
                  lastid.next();
                  id_timers.add(lastid.getInt(1));
                  }
           }
         for(Integer number:id_timers){
         ps=conn.prepareStatement("insert into showcalendar(id_movie,id_room,id_timer) value(?,?,?);",Statement.RETURN_GENERATED_KEYS);   
         ps.setInt(1,((KeyValue)jComboBox1.getSelectedItem()).getKey());//
         ps.setInt(2,((KeyValue)jComboBox2.getSelectedItem()).getKey());
         ps.setInt(3,number);
         ps.executeUpdate();
          ResultSet lastid = ps.getGeneratedKeys();
         lastid.next();
         }
         id_hours.removeAllElements();
            cleanHour();
        JOptionPane.showMessageDialog(this, "Set schedule success");
        }
	catch(Exception ex)
	{
		System.out.println("Connect fail");
	}
        }
    }//GEN-LAST:event_SetButtonMouseClicked

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
         this.setVisible(false);
         manage frame=new manage();
         frame.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         if(jButton2.getBackground().getGreen()==255){
            jButton2.setBackground(null);
            removeID(id_hours,2);
        }
        else{
             jButton2.setBackground(Color.green);
             id_hours.add(2);
        }
         System.out.println(id_hours);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         if(jButton3.getBackground().getGreen()==255){
            jButton3.setBackground(null);
            removeID(id_hours,3);
        }
        else{
             jButton3.setBackground(Color.green);
             id_hours.add(3);
        }
         
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         if(jButton4.getBackground().getGreen()==255){
            jButton4.setBackground(null);
            removeID(id_hours,4);
        }
        else{
             jButton4.setBackground(Color.green);
             id_hours.add(4);
        }
         System.out.println(id_hours);// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         if(jButton5.getBackground().getGreen()==255){
            jButton5.setBackground(null);
            removeID(id_hours,5);
        }
        else{
             jButton5.setBackground(Color.green);
             id_hours.add(5);
        }
         System.out.println(id_hours);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         if(jButton6.getBackground().getGreen()==255){
            jButton6.setBackground(null);
            removeID(id_hours,6);
        }
        else{
             jButton6.setBackground(Color.green);
             id_hours.add(6);
        }
         System.out.println(id_hours);// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         if(jButton7.getBackground().getGreen()==255){
            jButton7.setBackground(null);
            removeID(id_hours,7);
        }
        else{
             jButton7.setBackground(Color.green);
             id_hours.add(7);
        }
         System.out.println(id_hours);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(jButton8.getBackground().getGreen()==255){
            jButton8.setBackground(null);
            removeID(id_hours,8);
        }
        else{
             jButton8.setBackground(Color.green);
             id_hours.add(8);
        }
         System.out.println(id_hours);// TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(jButton9.getBackground().getGreen()==255){
            jButton9.setBackground(null);
            removeID(id_hours,9);
        }
        else{
             jButton9.setBackground(Color.green);
             id_hours.add(9);
        }
         System.out.println(id_hours);// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
         if(jButton10.getBackground().getGreen()==255){
            jButton10.setBackground(null);
            removeID(id_hours,10);
        }
        else{
             jButton10.setBackground(Color.green);
             id_hours.add(10);
        }
         System.out.println(id_hours);// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(jButton11.getBackground().getGreen()==255){
            jButton11.setBackground(null);
            removeID(id_hours,11);
        }
        else{
             jButton11.setBackground(Color.green);
             id_hours.add(11);
        }
         System.out.println(id_hours);// TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void dateChooserCombo1OnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserCombo1OnCommit
        cleanHour();
        // TODO add your handling code here:
    }//GEN-LAST:event_dateChooserCombo1OnCommit

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        //Refresh button
        Vector<Integer> id_timers=new Vector<>();
        boolean sameChecked=false;
        try{
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking","root","");
         PreparedStatement st=conn.prepareStatement("Select * from showcalendar where id_room like ? and id_movie like ?;");
         st.setInt(1,((KeyValue)jComboBox2.getSelectedItem()).getKey());
         st.setInt(2,((KeyValue)jComboBox1.getSelectedItem()).getKey());
        ResultSet rs=st.executeQuery();
        while(rs.next()){
           int id_showcalendar=rs.getInt("id");
           int id_timer=rs.getInt("id_timer");
           st=conn.prepareStatement("Select * from timer where Date like ? and id like ?;");
           st.setString(1,(dateChooserCombo1.getText()));
           st.setInt(2,id_timer);
           ResultSet r0=st.executeQuery();
           while(r0.next()){
                  st=conn.prepareStatement("Select * from bill where id_showcalendar like ?;");
                  st.setInt(1, id_showcalendar);
                  ResultSet r1=st.executeQuery();
                  while(r1.next()){
                      sameChecked=true;
                  }
                st=conn.prepareStatement("Delete from showcalendar where id = ?;");
                st.setInt(1, id_showcalendar);
                st.executeUpdate();
               
           }
        }
        JOptionPane.showMessageDialog(this, "Refresh success!");
        cleanHour();
	}catch(Exception ex)
	{
		if(sameChecked){
                    ImageIcon iconic=new ImageIcon("error.png");
                    JOptionPane.showMessageDialog(this, "You can not refresh this schedule because someone booked it"," error!",JOptionPane.INFORMATION_MESSAGE,iconic);
                }
                else{
                    System.out.println("connect fail");
                }
	}
        
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshButtonActionPerformed
    int j=0;
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
       if(j++>0){
            cleanHour();       
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    int i=0;
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        if(i++>0){
            cleanHour();       
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(SetSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetSchedule().setEnabled(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SetButton;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<KeyValue> jComboBox1;
    private javax.swing.JComboBox<KeyValue> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
