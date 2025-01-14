
package movieticketbooking.user;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.util.Vector;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.Collections;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.net.InetAddress;
import java.net.UnknownHostException;

import movieticketbooking.user.DayHour;
public class Booking extends javax.swing.JFrame {
    private int userId;
    private String userName;
    private Vector<DayHour> dhList;


    public Booking(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        initComponents();
        System.out.println("User ID: " + userId);
        System.out.println("User Name: " + userName);
    }
    public void SetImageSize(String anh) {
        try {
            if (anh == null || anh.isEmpty()) {
                throw new Exception("Invalid image path");
            }

            // Kiểm tra xem file ảnh có tồn tại không
            ImageIcon MyImage = new ImageIcon(getClass().getResource("/Image/" + anh));
            Image img = MyImage.getImage();
            Image newImg = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(newImg);
            jLabel1.setIcon(image);
        } catch (Exception ex) {
            System.out.println("Error loading image: " + anh + ". Using default placeholder.");
            // Nếu lỗi, sử dụng ảnh mặc định
            jLabel1.setIcon(new ImageIcon(getClass().getResource("/Image/default_placeholder.jpg")));
        }
    }
    public Booking() {
        initComponents(); 
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        initCustom();
        
     
        
    }
    public void SortHour(Vector<KeyValue> v){
        for(int i=0;i<v.size()-1;i++){
            for(int j=i+1;j<v.size();j++){
                String[] vi= v.elementAt(i).getValue().split("\\:");
                String[] vj = v.elementAt(j).getValue().split("\\:");
                int check=0;
                for(int k=0;k<2;k++){
                    if(Integer.parseInt(vj[k])<Integer.parseInt(vi[k])){
                        check=1;
                        break;
                    }
                    else if(Integer.parseInt(vj[k])>Integer.parseInt(vi[k])){
                         check=-1;
                        break;
                    }
                }
                if(check==1){
                    KeyValue tmp=v.elementAt(j);
                    v.setElementAt(v.elementAt(i), j);
                    v.setElementAt(tmp, i);
                }               
            }
        }
    }
    public void SortDay(Vector<String> v){
        for(int i=0;i<v.size()-1;i++){
            for(int j=i+1;j<v.size();j++){
                String[] vi= v.elementAt(i).split("\\/");
                String[] vj = v.elementAt(j).split("\\/");
                int check=0;
              
                for(int k=2;k>=0;k--){
                    if(Integer.parseInt(vj[k])<Integer.parseInt(vi[k])){
                        check=1;
                        break;
                    }
                    else if(Integer.parseInt(vj[k])>Integer.parseInt(vi[k])){
                         check=-1;
                        break;
                    }
                }
                if(check==1){
                    String tmp=v.elementAt(j);
                    v.setElementAt(v.elementAt(i), j);
                    v.setElementAt(tmp, i);
                }                
            }
        }
    }
    String movieName="",description="",poster="",director="",trailer="";
	private int currentIndex;
	
	private Vector<Integer> movieList = new Vector<>();

    
	public void renderBookingInterface(int movieId) {
	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking", "root", "")) {
	        PreparedStatement st = conn.prepareStatement("SELECT * FROM movie WHERE id = ?;");
	        st.setInt(1, movieId);
	        ResultSet r0 = st.executeQuery();

	        if (r0.next()) {
	            movieName = r0.getString("name");
	            description = r0.getString("description");
	            poster = r0.getString("poster");
	            director = r0.getString("director");
	            trailer = r0.getString("trailer");
	        } else {
	            throw new Exception("Không tìm thấy phim" + movieId);
	        }

	        // Cập nhật giao diện
	        jTextArea1.setText(description);
	        jTextArea2.setText(movieName);
	        jLabel7.setText(director);
	        SetImageSize(poster);

	        // Reset ComboBox và danh sách giờ chiếu
	        DayCombobox.removeAllItems();
	        hourCombobox.removeAllItems();
	        dhList = new Vector<>();

	        // Truy vấn giờ chiếu
	        st = conn.prepareStatement("SELECT * FROM showcalendar WHERE id_movie LIKE ?;");
	        st.setString(1, Integer.toString(movieId));
	        ResultSet rs = st.executeQuery();

	        while (rs.next()) {
	            int id_timer = rs.getInt("id_timer");
	            st = conn.prepareStatement("SELECT * FROM timer WHERE id LIKE ?;");
	            st.setString(1, Integer.toString(id_timer));
	            ResultSet r1 = st.executeQuery();
	            if (r1.next()) {
	                String day = r1.getString("Date");
	                DayHour d = dhList.stream().filter(x -> x.getDay().equals(day)).findFirst().orElseGet(() -> {
	                    DayHour newDay = new DayHour();
	                    newDay.addDay(day);
	                    dhList.add(newDay);
	                    return newDay;
	                });

	                String id_hour = Integer.toString(r1.getInt("id_hour"));
	                st = conn.prepareStatement("SELECT * FROM hour WHERE id LIKE ?;");
	                st.setString(1, id_hour);
	                ResultSet r3 = st.executeQuery();
	                while (r3.next()) {
	                    String value = r3.getString("value");
	                    int key = r3.getInt("id");
	                    d.addHour(new KeyValue(key, value));
	                }
	            }
	        }

	        // Cập nhật ngày chiếu vào ComboBox
	        Vector<String> dayVector = new Vector<>();
	        for (DayHour dh : dhList) {
	            dayVector.add(dh.getDay());
	        }
	        SortDay(dayVector);
	        for (String day : dayVector) {
	            DayCombobox.addItem(day);
	        }
	    } catch (Exception ex) {
	        System.out.println("Lỗi trong renderBookingInterface: " + ex.getMessage());
	        ex.printStackTrace();
	    }
	}

	private Vector<Integer> movieList1 = new Vector<>();


	public void initCustom() {
	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking", "root", "")) {
	        PreparedStatement st = conn.prepareStatement("SELECT id FROM movie;");
	        ResultSet r0 = st.executeQuery();

	        if (movieList == null) {
	            movieList = new Vector<>();
	        } else {
	            movieList.clear();
	        }

	        // Thêm ID phim vào danh sách
	        while (r0.next()) {
	            movieList.add(r0.getInt("id"));
	        }

	        // Kiểm tra nếu không có phim nào
	        if (movieList.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Không tìm thấy phim nào trong cơ sở dữ liệu.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        // Hiển thị phim đầu tiên trong danh sách
	        renderBookingInterface(movieList.elementAt(currentIndex));

	    } catch (SQLException ex) {
	        System.out.println("Không thể lấy danh sách phim.");
	        ex.printStackTrace();
	    }
	}

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        LeftButton = new javax.swing.JLabel();
        RightButton = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        DayCombobox = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        hourCombobox = new javax.swing.JComboBox<KeyValue>();
        BookTicketBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đặt vé xem phim");
        LeftButton.setText("<");  // Hiển thị mũi tên trái
        LeftButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);  // Canh giữa nội dung
        LeftButton.setPreferredSize(new java.awt.Dimension(50, 50));  // Kích thước cố định
        RightButton.setPreferredSize(new java.awt.Dimension(50, 50));

        RightButton.setText(">");  // Hiển thị mũi tên phải
        RightButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);  // Canh giữa nội dung


        LeftButton.setBackground(new java.awt.Color(51, 10, 255));
        LeftButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LeftButtonMouseClicked(evt);
            }
        });

        RightButton.setBackground(new java.awt.Color(51, 10, 255));
        RightButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RightButtonMouseClicked(evt);
            }
        });

        jLabel8.setText("Chọn ngày");

        DayCombobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DayComboboxItemStateChanged(evt);
            }
        });
        DayCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayComboboxActionPerformed(evt);
            }
        });

        jLabel9.setText("Chọn giờ");

        BookTicketBtn.setText("Đặt vé");
        BookTicketBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookTicketBtnActionPerformed(evt);
            }
        });

        jButton2.setText("Trở lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel6.setText("Director :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel7.setText("James Wan");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(jTextArea2.getFont().deriveFont(jTextArea2.getFont().getStyle() | java.awt.Font.BOLD, jTextArea2.getFont().getSize()+5));
        jTextArea2.setRows(5);
        jTextArea2.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextArea2);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setFocusCycleRoot(true);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Serif", 1, 14)); 
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LeftButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RightButton)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(hourCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(DayCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(72, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(BookTicketBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DayCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(hourCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LeftButton)
                    .addComponent(RightButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BookTicketBtn)
                .addGap(20, 20, 20))
        );

        pack();
    }

    private void DayComboboxItemStateChanged(java.awt.event.ItemEvent evt) {
    }
    private void DayComboboxActionPerformed(java.awt.event.ActionEvent evt) {
        if(DayCombobox.getItemCount()!= 0)
        {
            String dayCheck=(DayCombobox.getSelectedItem().toString());
            for(DayHour dh:dhList){
             if(dayCheck==dh.getDay())
             {
                hourCombobox.removeAllItems();
                Vector<KeyValue> hour=new Vector<>();
                for(int i=0;i<dh.getHours().size();i++)
                {
                hour.add(((KeyValue)dh.getHours().elementAt(i)));
                }
                 SortHour(hour);
                 for(int i=0;i<hour.size();i++)
                {
                hourCombobox.addItem(hour.elementAt(i));
                }
              }
             }
        }
    }
    
    private void RightButtonMouseClicked(java.awt.event.MouseEvent evt) {
        if (movieList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No movies available.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Chuyển tới phim tiếp theo
        currentIndex = (currentIndex + 1) % movieList.size();
        renderBookingInterface(movieList.elementAt(currentIndex));
    }

    private void renderBookingInterface(KeyValue elementAt) {
		// TODO Auto-generated method stub
		
	}


	private void LeftButtonMouseClicked(java.awt.event.MouseEvent evt) {
        if (movieList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No movies available.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Chuyển tới phim trước
        if (currentIndex == 0) {
            currentIndex = movieList.size() - 1;
        } else {
            currentIndex--;
        }
        renderBookingInterface(movieList.elementAt(currentIndex));
    }

    public int getSessionIds(){
        try{
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieTicketBooking?useUnicode=true&characterEncoding=UTF-8","root","");
        PreparedStatement ps=con.prepareStatement("select * from id_session where type like 1 and privateIpAdress like ?");
        ps.setString(1, getIpAdress());
        ResultSet rs =ps.executeQuery();
        while(rs.next()){
            return rs.getInt("id_user");
        }
        }catch(Exception ex){
            System.out.println("connect fail");
        }
        return 0;
    }
    private String getIpAdress() {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            return localhost.getHostAddress().trim();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return ""; 
        }
    }

    private void BookTicketBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if(DayCombobox.getItemCount()!=0){

        int id_user=getSessionIds();
        if(id_user==0)
        {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "You must login before booking ! Do you want to login?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION)
        {
            this.setVisible(false);
            LoginDialog ld=new LoginDialog("booking","");
            ld.setVisible(true);
        }
        }
        else
        {         
        int id_movie=movieList.elementAt(currentIndex);
        int id_showcalendar=0;
        Connection conn;
	try{
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking","root","");
	 PreparedStatement st=conn.prepareStatement("Select * from showcalendar where id_movie like ?;");
         st.setString(1, Integer.toString(id_movie));
        ResultSet rs=st.executeQuery();

        while(rs.next()){
             int timer=rs.getInt("id_timer");
             st=conn.prepareStatement("Select * from timer where id like ?;");
             st.setString(1, Integer.toString(timer));
             ResultSet r1=st.executeQuery();
             r1.next();
             if(DayCombobox.getSelectedItem().toString().equals(r1.getString("Date"))){
                 if(((KeyValue)hourCombobox.getSelectedItem()).getKey()==r1.getInt("id_hour")){
                              st=conn.prepareStatement("Select * from showcalendar where id_movie like ? and id_timer like ?;");
                              st.setString(1, Integer.toString(id_movie));
                              st.setString(2, Integer.toString(timer));
                              ResultSet r2=st.executeQuery();
                              r2.next();
                              id_showcalendar=r2.getInt("id");
                              break;
                 }
             }
        }
	}catch(Exception ex)
	{
		System.out.println("Connect fail");
	}
        
        this.setVisible(false);
        BookSeat bs=new BookSeat(id_showcalendar,id_user);
        bs.setVisible(true);
        }
        }
        else{
         JOptionPane.showMessageDialog(rootPane, "This movie has no show schedule yet", "Error",  JOptionPane.ERROR_MESSAGE);

        }
       
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
         this.setVisible(false);
        Home hm=new Home();
        hm.setVisible(true);
        
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
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Booking().setVisible(true);
            }
        });
    }

    private javax.swing.JButton BookTicketBtn;
    private javax.swing.JComboBox<String> DayCombobox;
    private javax.swing.JLabel LeftButton;
    private javax.swing.JLabel RightButton;
    private javax.swing.JComboBox<KeyValue> hourCombobox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;

}
