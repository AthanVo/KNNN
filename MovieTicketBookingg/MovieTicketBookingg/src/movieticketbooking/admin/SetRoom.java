
package movieticketbooking.admin;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import movieticketbooking.user.KeyValue;
import movieticketbooking.user.Seat;


public class SetRoom extends javax.swing.JFrame{

 
        
        private JPanel p = new JPanel();
        private JPanel q = new JPanel();
        private int removedSeat[][];
        private int column;
        private int row;
        private int id_room;
        private int seatSum=0;
        public SetRoom() {
        initComponents();
         this.pack();
        this.setLocationRelativeTo(null);
        this.setEnabled(true);
        creatButton();
        
    }
 
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đặt vé xem phim");
        setPreferredSize(new java.awt.Dimension(800, 650));

        jLabel1.setText("Nhập hàng");

        jLabel2.setText("Nhập cột");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Khởi tạo");
        jButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jButton1StateChanged(evt);
            }
        });
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

        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nhập số phòng");

        jButton3.setText("Trở lại");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Tổng số ghế:");

        jLabel5.setText("0");

        jButton4.setText("Kiểm tra");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Xóa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Cập nhật");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(jTextField2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(225, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void creatButton(){
        JButton btnCreat=new JButton("Tạo phòng");
        int btnWidth=120;
        int btnHeight=60;
        int xLocation=(getContentPane().getWidth()/2)-(btnWidth/2);
        int yLocation=(getContentPane().getHeight()-btnHeight);
        
        btnCreat.setBounds(xLocation,yLocation, btnWidth, btnHeight);
        btnCreat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement st;
                boolean checksame=true;
                boolean haveMatrix=true;
                boolean haveRoomNumber=true;
                // check row,column box has empty
                if(jTextField1.getText().isEmpty()||jTextField2.getText().isEmpty()){
                    haveMatrix=false;
                }
                // check room number box has exist
                if(jTextField3.getText().isEmpty()){
                    haveRoomNumber=false;
                }
          // insert room table
                if(haveMatrix&&haveRoomNumber){
                       id_room=insertRoomTable(haveMatrix,haveRoomNumber,id_room);
                       if(id_room!=0){
                        if(haveMatrix&&haveRoomNumber){
                       insertRemovedSeats(id_room);
                       JOptionPane.showMessageDialog(rootPane, "Tạo phòng thành công!");
                       }
                        }
                       else{
                        JOptionPane.showMessageDialog(rootPane, "Số phòng đã tồn tại", "Error",  JOptionPane.ERROR_MESSAGE);
                       }
         // insert removedseats table    
                        
                }
                 else if(!haveMatrix){
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa tạo ", "Error",  JOptionPane.ERROR_MESSAGE);
                  }
                 else if(!haveRoomNumber){
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập số phòng", "Error",  JOptionPane.ERROR_MESSAGE);
                     }
             
              
        } 
         });
        this.add(btnCreat);
        jLabel5.setText(Integer.toString(seatSum));
    }
    public void insertRemovedSeats(int id_room){
         try
        {
         Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8","root","");
       
         for(int i=0;i<row;i++)
          {
               for(int j=0;j<column;j++)
               {
                   if(removedSeat[i][j]==0){
                       System.out.println("trung r");
                       PreparedStatement st=conn.prepareStatement("insert into removedseats(rowIndex,colIndex,id_room) values(?,?,?)");
                       st.setInt(1, i);
                       st.setInt(2, j);
                       st.setInt(3, id_room);
                       st.executeUpdate();
                   }
               }
          }
          PreparedStatement st=conn.prepareStatement("update room set quantity =? where id = ?");
          System.out.println("seatsum la"+seatSum);
          st.setInt(1, seatSum);
          st.setInt(2, id_room);
          st.executeUpdate();
        }
        catch(Exception ex)
	{
		System.out.println("creat removedseats fail");
	}
    }
    public int insertRoomTable(boolean haveMatrix,boolean haveRoomNumber,int id_room){
        row=Integer.parseInt(jTextField1.getText());
        column=Integer.parseInt(jTextField2.getText());
        try
        {
            // check room number has exist (=0:not exist)
                if(checkSame(jTextField3.getText())==0)
                {
                       int roomNumber=Integer.parseInt(jTextField3.getText()) ;
                       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8","root","");
                       PreparedStatement st=conn.prepareStatement("insert into room(number,quantity,colNums,rowNums) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                       st.setInt(1,roomNumber);
                       st.setInt(2, column*row);
                       st.setInt(3, column);
                       st.setInt(4, row);
                       st.executeUpdate();
                       ResultSet rs = st.getGeneratedKeys();
                       if (rs.next()){
                        id_room=rs.getInt(1);
                       }
                }    
                else
                {
                        return 0;
                }
        }
        catch(Exception ex)
	{
		System.out.println("Tạo phòng thất bại");
	}
        // check error
       
           return id_room;       
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //
    }//GEN-LAST:event_jButton1ActionPerformed
    boolean flag=true;
    private void seatArrayInit(int row,int column){
          removedSeat=new int[row][column];
          for(int i=0;i<row;i++)
          {
               for(int j=0;j<column;j++)
               {
                   removedSeat[i][j]=1;
               }
          }
    }
    public void creatMatrix(int row,int column){
        seatSum=row*column;
        jLabel5.setText(Integer.toString(seatSum));
        //set all seats have value = 0 
        seatArrayInit(row, column);
        int boxSum=column*row;
        final JButton btn[]=new JButton[boxSum];
        p.setBounds(50, 120, 700, 400);
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        this.add(p);
        GridLayout g=new GridLayout(row,column,4,2);
        p.setLayout(g);
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
            btn[i]=new JButton();
            btn[i].setFont((new Font("Arial", Font.PLAIN, 10)));
            final JButton b=btn[i];
            final int I=i;
            final int J=j;
            btn[i].addActionListener(new ActionListener() {
            private int clickCount=1;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickCount%2!=0){
                      b.setBackground(Color.BLACK);
                      b.setBorder(null);
                      b.setOpaque(false);
                      removedSeat[I][J]=0;
                      seatSum--;
                      jLabel5.setText(Integer.toString(seatSum));
                }
                else{
                    // seat position was be removed
                    //hanlde view
                    b.setBackground(jButton1.getBackground());
                    b.setBorder(new JButton().getBorder());
                    //controller
                    removedSeat[I][J]=1;
                    seatSum++;
                    jLabel5.setText(Integer.toString(seatSum));
                }
                clickCount++;
         }
        });
            p.add(btn[i]);
            }
          
        }
         revalidate();
         p.validate();
    }
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(flag==true){
         int row=Integer.parseInt(jTextField1.getText());
         int col=Integer.parseInt(jTextField2.getText());
         creatMatrix(row,col);
         flag=false;
        }
    }//GEN-LAST:event_jButton1MouseClicked
    private void jButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jButton1StateChanged
    }//GEN-LAST:event_jButton1StateChanged
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       flag=true;
        p.removeAll();
        repaint();
//        revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
       this.setVisible(false);
       manage mn=new manage();
       mn.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
    public int checkSame(String txt){
       
        try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8","root","");
            PreparedStatement st=conn.prepareStatement("select * from room where number like ?");
            System.out.println(txt);
            st.setInt(1,Integer.parseInt(txt));
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                return rs.getInt("id");
            }
        }catch(Exception ex){
            System.out.println("fail");
        }
        return 0;
    }
    int roomNumber=0,maxRow=0,maxColumn=0;
    private void removedSeatInit(int id_room){
         try{
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieTicketBooking","root","");
         PreparedStatement ps=con.prepareStatement("select * from room where id like ?;");
         ps.setInt(1,id_room);
         ResultSet r0=ps.executeQuery();
         while(r0.next()){
            maxRow=r0.getInt("rowNums");
            maxColumn=r0.getInt("colNums");
            seatSum=r0.getInt("quantity");
           jLabel5.setText(Integer.toString(seatSum));
         }
        }
        catch(Exception ex){
	ex.printStackTrace();
        }
          removedSeat=new int[maxRow][maxColumn];
          for(int i=0;i< maxRow;i++)
          {
               for(int j=0;j< maxColumn;j++)
               {
                   removedSeat[i][j]=1;
               }
          }
        try{
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieTicketBooking","root","");
         PreparedStatement ps=con.prepareStatement("select * from removedseats where id_room like ?;");
         ps.setInt(1,id_room);
         ResultSet r0=ps.executeQuery();
         while(r0.next()){
             int i=r0.getInt("rowIndex");
             int j=r0.getInt("colIndex");
             removedSeat[i][j]=0;
         }
    }
     catch(Exception ex){
	ex.printStackTrace();
        }
    }
     public void renderSeat(){
        //get room and get removedSeat
       
        //handle view
        final JButton btn[][]=new JButton[maxRow][maxColumn];
        p.setBounds(50, 120, 700, 400);
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        this.add(p);
        GridLayout g=new GridLayout(maxRow,maxColumn,4,2);
        p.setLayout(g);
        for(int i = 0; i < maxRow; i++) {
            for(int j = 0; j < maxColumn; j++) {
            btn[i][j]=new JButton();
            btn[i][j].setFont((new Font("Arial", Font.PLAIN, 10)));
             btn[i][j].setMargin(new Insets(0,0,0,0));
            final JButton b=btn[i][j];
            final int I=i;
            final int J=j;
            btn[i][j].addActionListener(new ActionListener() {
            private int clickCount=1;
            @Override
            public void actionPerformed(ActionEvent e) {
               if(!b.getBackground().equals(Color.black)){
                      b.setBackground(Color.BLACK);
                      b.setBorder(null);
                      b.setOpaque(false);
                      removedSeat[I][J]=0;
                      seatSum--;
                      jLabel5.setText(Integer.toString(seatSum));
                }
                else{
                    // seat position was be removed
                    //hanlde view
                    b.setBackground(jButton1.getBackground());
                    b.setBorder(new JButton().getBorder());
                    //controller
                    removedSeat[I][J]=1;
                    seatSum++;
                    jLabel5.setText(Integer.toString(seatSum));
                }
                clickCount++;
             }
             });
             if(removedSeat[i][j]==0){
                     b.setBackground(Color.BLACK);
                     b.setBorder(null);
                     b.setOpaque(false); 
             }
             
            p.add(btn[i][j]);
                  }
           
          }
         revalidate();
         p.validate();
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(!jTextField3.getText().isEmpty()){
              if(checkSame(jTextField3.getText())!=0){
               if(flag==true){
                removedSeatInit(checkSame(jTextField3.getText()));
                renderSeat();
                flag=false;
            }
             }
             else{
            JOptionPane.showMessageDialog(rootPane, "Phòng trống", "Success",  JOptionPane.INFORMATION_MESSAGE);
            }
         }
        else{
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập số phòng", "Error",  JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton4ActionPerformed
    public int getIdRoom(int number){
        int id=0;
        try
            {        
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8","root","");
                 PreparedStatement st=conn.prepareStatement("Select * from room where number like ?", Statement.RETURN_GENERATED_KEYS);
                 st.setInt(1,number);
                 ResultSet rs=st.executeQuery();
                 if(rs.next()){
                     id=rs.getInt("id");
                 }
            }catch(Exception ex){
                System.out.println("Tạo phòng thất bại");
            }
        return id;
    }
    public boolean checkShowTime(int idRoom){
         try
            {
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8","root","");
                PreparedStatement st=conn.prepareStatement("Select * from showcalendar where id_room like ?");
                 st.setInt(1,idRoom);
                 ResultSet rs=st.executeQuery();
                 if(rs.next()){
                     return true;
                 }
            }catch(Exception ex){
                System.out.println("Tạo phòng thất bại");
            }
        return false;
    }
    public void deleteRemovedSeat(int idRoom){
        try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8","root","");
              PreparedStatement st=conn.prepareStatement("delete from removedseats where id_room like ?");
                       st.setInt(1,idRoom);
                       st.executeUpdate();
        }catch(Exception ex){
            System.out.println("Tạo phòng thất bại");
        }
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // delete removedseat table
        if(!jTextField3.getText().isEmpty()){
        int number=Integer.parseInt(jTextField3.getText());
        int idRoom=getIdRoom(number);
        if(!checkShowTime(idRoom)){
        try
        {
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8","root","");
             PreparedStatement st=conn.prepareStatement("delete from removedseats where id_room like ?");
                       st.setInt(1,idRoom);
                       st.executeUpdate();
            try
            {
                 st=conn.prepareStatement("Bạn có chắc xóa phòng ?");
                 st.setInt(1,idRoom);
                 st.executeUpdate();
                 JOptionPane.showMessageDialog(rootPane, "Phòng đã bị xóa", "Success",  JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception ex){
                System.out.println("Tạo phòng thất bại");
            }
         }
        catch(Exception ex)
	{
		System.out.println("Tạo chỗ ngồi bị xóa không thành công");
               
	}
        }
        else{
             JOptionPane.showMessageDialog(rootPane, "Phòng đã có lịch chiếu", "Error",  JOptionPane.ERROR_MESSAGE);
        }
        }
        else{
             JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập số phòng", "Error",  JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       if(!jTextField3.getText().isEmpty()){
      
       int number_room=Integer.parseInt(jTextField3.getText());
       int id_room=getIdRoom(number_room);
       try{
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking?useUnicode=true&characterEncoding=UTF-8","root","");
             PreparedStatement st=conn.prepareStatement("Select * from room where id like ?");
             st.setInt(1, id_room);
             ResultSet rs=st.executeQuery();
             if(rs.next()){
                 column=rs.getInt("colNums");
                 row=rs.getInt("rowNums");
             }
       }catch(Exception ex){
       }
        deleteRemovedSeat(id_room);
        insertRemovedSeats(id_room);
        JOptionPane.showMessageDialog(rootPane, "Cập nhật phòng thành công!");
       }else{
 JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập số phòng", "Error",  JOptionPane.ERROR_MESSAGE);

       }
    }//GEN-LAST:event_jButton6ActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SetRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetRoom().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    

    
}
