/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rooms;


import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import service.*;



public class SearchRoom extends javax.swing.JFrame{
    String sortPRICE;
    String sortRATING;
    String sortGUEST;
    String sortBED;
     /* Creates new form SearchRoom
     */
    
    public SearchRoom() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choose = JOptionPane.showConfirmDialog(null,
                        "Do you really want to exit the application?",
                        "Confirm Close", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (choose == JOptionPane.YES_OPTION) {
                    e.getWindow().dispose();
                }
            }
        });
        this.setTitle("SEARCH ROOM");
        ImageIcon image = new ImageIcon("ICON.png");
        this.setIconImage(image.getImage());
        jComboBox7.setEnabled(false);
        jDateChooser1.getJCalendar().setMinSelectableDate(new Date());
        jDateChooser2.getJCalendar().setMinSelectableDate(new Date());
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(false);
        jComboBox4.setEnabled(false);
        jComboBox5.setEnabled(false);
        jComboBox6.setEnabled(false);
        jComboBox7.setEnabled(false);
        jButton2.setEnabled(false);
        try {
            showItem(pos);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    int pos = 0;
    public List<RoomAvailable> getItemList(){
        if(RATING.isSelected()){
            sortRATING = "ASC";
            RATING.setText("RATING ASC");
        }else{
            sortRATING = "DESC";
            RATING.setText("RATING DESC");
        }
        if(PRICE.isSelected()){
            sortPRICE = "DESC";
            PRICE.setText("PRICE DESC");
        }else{
            sortPRICE = "ASC";
            PRICE.setText("PRICE ASC");
        }
        if(GUEST.isSelected()){
            sortGUEST = "ASC";
            GUEST.setText("GUEST ASC");
        }else{
            sortGUEST = "DESC";
            GUEST.setText("GUEST DESC");
        }
        if(BED.isSelected()){
            sortBED = "DESC";
            BED.setText("BED ASC");
        }else{
            sortBED = "ASC";
            BED.setText("BED DESC");
        }
        try {
            ResultSet rs;
            jTextField2.setText(SearchRoomCondition.jTextField2.getText());
            rs = selection.getData("SELECT room.roomid,room.roomtype,roomtypes.guestAdult,roomtypes.guestKid,roomtypes.noOfBed1,roomtypes.bedtype1,"
                + "roomtypes.noOfBed2,roomtypes.bedtype2,room.description,room.price,room.image,room.rating,room.review\n" 
                + "FROM room INNER JOIN roomtypes ON room.roomtype = roomtypes.roomtype WHERE price <= '"+jTextField2.getText()+"' ORDER BY rating "+sortRATING+", price "+sortPRICE+", (IFNULL(guestAdult,0)+IFNULL(guestKid,0)) "+sortGUEST+", (IFNULL(noOfBed1,0)+IFNULL(noOfBed2,0)) "+sortBED);
            
            if(SearchRoomCondition.jButton1.getModel().isArmed()){
                jTextField1.setText(SearchRoomCondition.jTextField1.getText());
                rs = selection.getData("SELECT room.roomid,room.roomtype,roomtypes.guestAdult,roomtypes.guestKid,roomtypes.noOfBed1,roomtypes.bedtype1,"
                    + "roomtypes.noOfBed2,roomtypes.bedtype2,room.description,room.price,room.image,room.rating,room.review\n" 
                    + "FROM room INNER JOIN roomtypes ON room.roomtype = roomtypes.roomtype WHERE roomid = '"+jTextField1.getText()+"'");
//                jButton4.setEnabled(false);
//                jButton5.setEnabled(false);
//                jButton7.setEnabled(false);
//                jButton8.setEnabled(false);
                
            }
            
            
            List<RoomAvailable> list = new ArrayList<RoomAvailable>();
            RoomAvailable RoomAvailable;
            while(rs.next()){
                String bed = Integer.toString(rs.getInt(5))+" "+rs.getString(6)+"\t "+Integer.toString(rs.getInt(7))+" "+rs.getString(8);
                bed = bed.replace("0", "");
                bed = bed.replace("null","");
                RoomAvailable = new RoomAvailable(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),bed,rs.getString(9),rs.getDouble(10),rs.getBytes(11),rs.getDouble(12),rs.getString(13));
                list.add(RoomAvailable);
            }
            
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        
    }
    
        public void showItem(int index) throws ParseException{
            jButton6.setEnabled(true);
            jLabel26.setVisible(false);
            jLabel20.setText(getItemList().get(index).getRoomID());
            jLabel21.setText(getItemList().get(index).getRoomType());
            jLabel22.setText(Integer.toString(getItemList().get(index).getGuestAdult()));
            jLabel23.setText(Integer.toString(getItemList().get(index).getGuestKid()));
            jLabel24.setText(getItemList().get(index).getBed());
            jLabel25.setText(Double.toString(getItemList().get(index).getPrice()));
            jLabel31.setText(Double.toString(getItemList().get(index).getRating()));
            jTextArea1.setText(getItemList().get(index).getDescription());
            jTextArea2.setText(getItemList().get(index).getReview());
            ImageIcon icon = new ImageIcon(getItemList().get(index).getImage());
            Image image = icon.getImage().getScaledInstance(jLabel11.getWidth(),jLabel11.getHeight(), Image.SCALE_SMOOTH);
            jLabel11.setText("It seems NO images about this room (╥_╥)");
            jLabel11.setIcon(new ImageIcon(image));
            
            
            jDateChooser1.setDate(SearchRoomCondition.jDateChooser1.getDate());
            jDateChooser2.setDate(SearchRoomCondition.jDateChooser2.getDate());
            SimpleDateFormat SQLFormat = new SimpleDateFormat("yyyy/MM/dd");
            String checkInDate = SQLFormat.format(jDateChooser1.getDate());
            java.util.Date dateBefore = SQLFormat.parse(checkInDate);
            String checkOutDate = SQLFormat.format(jDateChooser2.getDate());
            java.util.Date dateAfter = SQLFormat.parse(checkOutDate);
            ResultSet rs2 = selection.getData("SELECT * FROM transaction WHERE roomid = '"+jLabel20.getText()+"'");
            try {
                while(rs2.next()){
                    Date checkOut = rs2.getDate("checkoutdate");
                    Date checkIn = rs2.getDate("checkindate");
                    if((checkOut.after(dateBefore)&&(checkOut.before(dateAfter)||checkOut.equals(dateAfter)))
                  ||((checkIn.after(dateBefore)||checkIn.equals(dateBefore))&&(checkOut.before(dateAfter)||checkOut.equals(dateAfter)))
                  ||(checkIn.after(dateBefore)&&checkIn.before(dateAfter))||checkIn.equals(dateBefore)||checkOut.equals(dateAfter)){
                        jButton6.setEnabled(false);
                        jLabel26.setVisible(true);
                    }
            }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            
        }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        PRICE = new javax.swing.JToggleButton();
        RATING = new javax.swing.JToggleButton();
        GUEST = new javax.swing.JToggleButton();
        BED = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(2560, 1600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Forte", 1, 48)); // NOI18N
        jLabel1.setText("Searching Room");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 74));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 330, 290));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("PREVIOUS ROOM");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 190, 53));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("LAST ROOM");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 390, 180, 53));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("Book");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 127, 51));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Room ID");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 140, 31));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Room Type");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 140, 31));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Max Guest (Adult)");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 182, 31));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Review");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 182, 31));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Bed");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 182, 31));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Rating");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 182, 31));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 204));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 204));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(245, 245, 191));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextArea1.setCaretColor(new java.awt.Color(255, 239, 203));
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 220, 170));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Description");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 182, 31));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("jLabel20");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 173, 31));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("jLabel20");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 173, 31));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("jLabel20");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 146, 31));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("jLabel20");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 146, 31));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("jLabel20");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 146, 31));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("jLabel20");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 146, 31));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("FIRST ROOM");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 190, 53));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("NEXT ROOM");
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, 159, 53));

        jLabel26.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 102, 102));
        jLabel26.setText("This Room is NOT Available during your Check In and Check Out Date.");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 430, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("SORT BY:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 60, 20));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setText("Max Guest (Kid)");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 182, 31));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(245, 245, 191));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setBorder(null);
        jScrollPane3.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 220, 170));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setText("Price Per Day");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 160, 31));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("jLabel20");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 340, 146, 31));

        PRICE.setText("PRICE ASC");
        PRICE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRICEActionPerformed(evt);
            }
        });
        jPanel1.add(PRICE, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, -1, -1));

        RATING.setText("RATING DESC");
        RATING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RATINGActionPerformed(evt);
            }
        });
        jPanel1.add(RATING, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        GUEST.setText("GUEST DESC");
        GUEST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUESTActionPerformed(evt);
            }
        });
        jPanel1.add(GUEST, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        BED.setText("BED DESC");
        BED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEDActionPerformed(evt);
            }
        });
        jPanel1.add(BED, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Pristina", 1, 36)); // NOI18N
        jLabel2.setText("ROOM   AVAILABLE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 366, 39));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 1470, 650));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel3.setText("Room ID");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, 28));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel4.setText("Room Type");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 152, 28));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel5.setText("Check In Date");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 28));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel7.setText("No of adults");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, 28));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel8.setText("No of kids");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, 28));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel9.setText("No of Bed");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 127, 28));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel10.setText("Max Price Per Day");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, 210, 28));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton2.setText("Show This Room");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, -1, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 110, 28));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel14.setText("RM");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 50, 44, 28));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 50, 146, 28));
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 210, 27));
        jPanel2.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 200, 27));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "Triple", "Quad", "Twin", "Double-double", "Smoking Room", "Disabled Room", "Mini Suite", "Female Executive Floors" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 213, 28));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { null, "1", "2", "3", "4","5"}));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 270, 34));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { null, "1", "2", "3", "4","5"}));
        jPanel2.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 270, 30));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { null, "Single","Super Single","Double", "Queen", "King", "Double Decker" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, 100, 36));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { null, "1", "2", "3", "4"}));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, -1, 36));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { null, "Single","Super Single","Double", "Queen", "King", "Double Decker" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 103, 34));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { null, "1", "2", "3", "4"}));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, 34));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel6.setText("Check Out Date");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, 42));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton3.setText("Show Details");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, 25));

        jLabel27.setText("     ");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1326, 84, 150, 20));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setText("View All Room");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 90, 170, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1470, 160));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 70, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        try {
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date checkIn = jDateChooser1.getDate();
            Date checkOut = jDateChooser2.getDate();
            String dateBeforestr = myFormat.format(checkIn);
            java.util.Date dateBefore = myFormat.parse(dateBeforestr);
            String dateAfterstr = myFormat.format(checkOut);
            java.util.Date dateAfter = myFormat.parse(dateAfterstr);
            long diff = dateBefore.getTime() - dateAfter.getTime();
            int noOfDay = (int)(diff/(1000*60*60*24));
            
            if(noOfDay>-1){
                JOptionPane.showMessageDialog(null, "The Check Out Date cannot be earlier or same as Check In Date!");
            }else{
                setVisible(false);
                SearchRoomCondition x = new SearchRoomCondition();
                SearchRoomCondition.jTextField1.setText(SearchRoom.jTextField1.getText());
                SearchRoomCondition.jTextField2.setText(SearchRoom.jTextField2.getText());
                SearchRoomCondition.jDateChooser1.setDate(SearchRoom.jDateChooser1.getDate());
                SearchRoomCondition.jDateChooser2.setDate(SearchRoom.jDateChooser2.getDate());
                SearchRoomCondition.jComboBox1.setSelectedItem(SearchRoom.jComboBox1.getSelectedItem());
                SearchRoomCondition.jComboBox2.setSelectedIndex(SearchRoom.jComboBox2.getSelectedIndex());
                SearchRoomCondition.jComboBox3.setSelectedItem(SearchRoom.jComboBox3.getSelectedItem());
                SearchRoomCondition.jComboBox4.setSelectedIndex(SearchRoom.jComboBox4.getSelectedIndex());
                SearchRoomCondition.jComboBox5.setSelectedItem(SearchRoom.jComboBox5.getSelectedItem());
                SearchRoomCondition.jComboBox6.setSelectedIndex(SearchRoom.jComboBox6.getSelectedIndex());
                SearchRoomCondition.jComboBox7.setSelectedItem(SearchRoom.jComboBox7.getSelectedItem());
                SearchRoomCondition.jButton1.setEnabled(true);
                SearchRoomCondition.jButton1.doClick();
            }
            
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch(java.lang.NullPointerException e){
            JOptionPane.showMessageDialog(null, "Check In Date and Check Out Date cannot be empty！");
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String roomid = jTextField1.getText();
            if(roomid.equals("")){
                JOptionPane.showMessageDialog(null, "Your Room ID is empty");
            }else{
                ResultSet rs = selection.getData("SELECT * FROM room WHERE roomid = '"+roomid+"'");

                if(rs.next()){
                    jComboBox1.setSelectedItem(rs.getString(2));
                    jTextField2.setText(Double.toString(rs.getDouble(5)));
                    jTextField2.setEnabled(false);

                    rs = selection.getData("SELECT * FROM roomtypes WHERE roomtype = '"+jComboBox1.getSelectedItem()+"'");

                    if(rs.next()){
                        jComboBox2.setSelectedItem(rs.getString(2));
                        jComboBox3.setSelectedItem(rs.getString(3));
                        jComboBox4.setSelectedItem(rs.getString(4));
                        jComboBox5.setSelectedItem(rs.getString(5));
                        jComboBox6.setSelectedItem(rs.getString(6));
                        jComboBox7.setSelectedItem(rs.getString(7));
                        jButton2.setEnabled(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No Such Room");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        pos = 0;
        try {
            showItem(pos);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            // TODO add your handling code here:
            pos++;
            if(pos >= getItemList().size()){
                pos = getItemList().size()-1;
                JOptionPane.showMessageDialog(null, "This is the last room.");
            }
            showItem(pos);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            pos--;
            if(pos < 0){
                pos = 0;
                JOptionPane.showMessageDialog(null, "This is the first room.");
            }
            showItem(pos);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            pos = getItemList().size() - 1;
            showItem(pos);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new SearchRoomCondition().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)){
            evt.consume();
        }
        try{
            double maxPrice = Double.parseDouble(jTextField2.getText());
            
            if(maxPrice < 200){
                jLabel27.setText("Min Price is RM200");
                jButton9.setEnabled(false);
            }else{
                jLabel27.setText("");
                jButton9.setEnabled(true);
            }
        }catch(java.lang.NumberFormatException e){
            jLabel27.setText("Price cannot be empty.");
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Roomlist().setVisible(true);  
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date checkIn = jDateChooser1.getDate();
            Date checkOut = jDateChooser2.getDate();
            String dateBeforestr = myFormat.format(checkIn);
            java.util.Date dateBefore = myFormat.parse(dateBeforestr);
            String dateAfterstr = myFormat.format(checkOut);
            java.util.Date dateAfter = myFormat.parse(dateAfterstr);
            long diff = dateBefore.getTime() - dateAfter.getTime();
            int noOfDay = (int)(diff/(1000*60*60*24));
            if(noOfDay>-1){
                JOptionPane.showMessageDialog(null, "The Check Out Date cannot be earlier or same as Check In Date!");
            }else{
                setVisible(false);
                new ConfirmBooking().setVisible(true);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    
    }//GEN-LAST:event_jButton6ActionPerformed

    private void PRICEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRICEActionPerformed
        // TODO add your handling code here:
        jButton7.doClick(1);
    }//GEN-LAST:event_PRICEActionPerformed

    private void RATINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RATINGActionPerformed
        // TODO add your handling code here:
        jButton7.doClick(1);
    }//GEN-LAST:event_RATINGActionPerformed

    private void GUESTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUESTActionPerformed
        // TODO add your handling code here:
        jButton7.doClick(1);
    }//GEN-LAST:event_GUESTActionPerformed

    private void BEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEDActionPerformed
        // TODO add your handling code here:
        jButton7.doClick(1);
    }//GEN-LAST:event_BEDActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
   
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
            java.util.logging.Logger.getLogger(SearchRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchRoom().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BED;
    private javax.swing.JToggleButton GUEST;
    private javax.swing.JToggleButton PRICE;
    private javax.swing.JToggleButton RATING;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    public static javax.swing.JComboBox<String> jComboBox1;
    public static javax.swing.JComboBox<String> jComboBox2;
    public static javax.swing.JComboBox<String> jComboBox3;
    public static javax.swing.JComboBox<String> jComboBox4;
    public static javax.swing.JComboBox<String> jComboBox5;
    public static javax.swing.JComboBox<String> jComboBox6;
    public static javax.swing.JComboBox<String> jComboBox7;
    public static com.toedter.calendar.JDateChooser jDateChooser1;
    public static com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel21;
    public static javax.swing.JLabel jLabel22;
    public static javax.swing.JLabel jLabel23;
    public static javax.swing.JLabel jLabel24;
    public static javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
