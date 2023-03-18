/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package transaction;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import service.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import user.customerPage;
import review.rating;
import rooms.Room;


public class transactionHistory extends javax.swing.JFrame {
    /**
     * Creates new form transactionHistory
     */
    public transactionHistory() {
        initComponents();
        setSize(1200, 550);
        setLocation(50,100);
        setResizable(false);
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
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);
        jTextField6.setEditable(false);
        jTextField7.setEditable(false);
        jTextField8.setEditable(false);
        jLabel10.setText(customerPage.jLabel4.getText());
        jLabel10.setVisible(false);
        showTransactionInJTable();
    }   
    public ArrayList<transactionlist> ListTransaction()
    {
        ArrayList<transactionlist> tList = new ArrayList<>();
        Connection con;
        Statement st;
        ResultSet rs;
        ResultSet rs2;
        int userid= Integer.parseInt(customerPage.jLabel4.getText());
        
        String query = "SELECT * FROM transaction where userid =" + userid;
        String query2= "SELECT * FROM users where userid =" + userid;
        try{
                con =database.getConnection() ;
                st = con.createStatement();
                rs2=st.executeQuery(query2);
                while(rs2.next()){
                jTextField8.setText(rs2.getString("Name"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            con =database.getConnection() ;
            st = con.createStatement();
            rs = st.executeQuery(query);
            transactionlist list;
            while(rs.next())
            {
                list = new transactionlist(
                              rs.getString("roomid"),
                              rs.getString("roomtype"),
                              rs.getDouble("total_pay"),
                              rs.getInt("noOfDay"),
                              rs.getDate("checkindate"),
                              rs.getDate("checkoutdate"),
                              rs.getTimestamp("datetimeTransaction")
                               );
                tList.add(list);
            }
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }     
        return tList;      
    }
    public void showTransactionInJTable()
    {
        ArrayList<transactionlist> list= ListTransaction();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"RoomID","RoomType","TotalPay","NoOfDay","CheckInDate","CheckOutDate","TransactionTime"});
        Object[] row = new Object[7];
        
        for(int i = 0; i <list.size(); i++)
        {
            row[0] = list.get(i).getRoomid();
            row[1] = list.get(i).getRoomtype();
            row[2] =list.get(i).getTotal_pay();
            row[3] =list.get(i).getNoOfDay();
            row[4] =list.get(i).getCheckindate();
            row[5] =list.get(i).getCheckoutdate();
            row[6] =list.get(i).getDatetimeTransaction();
            model.addRow(row);
        }
        
        jTable1.setModel(model);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 1195, 190);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Rate it");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1040, 200, 149, 23);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1040, 230, 149, 23);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Generate Invoice");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(1040, 270, 149, 23);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Back to Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(1040, 470, 149, 23);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Room ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 250, 82, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Room Type");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 290, 70, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Total Pay");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 330, 80, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("No Of Day");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 370, 70, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Check In Date");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 410, 90, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Check Out Date");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 450, 113, 15);

        jLabel7.setText("Transaction Date Time");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 527, 113, 14);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(180, 240, 588, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(180, 280, 588, 30);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(180, 320, 588, 30);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(180, 360, 588, 30);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(180, 400, 588, 30);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(180, 440, 588, 30);
        getContentPane().add(jTextField7);
        jTextField7.setBounds(179, 524, 588, 20);
        getContentPane().add(jTextField8);
        jTextField8.setBounds(180, 200, 588, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Name");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 200, 82, 30);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(1155, 524, 20, 0);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hotel大厅2(may be user).png"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(-10, 0, 1200, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();       
        jTextField1.setText(model.getValueAt(selectedRowIndex, 0).toString());
        jTextField2.setText(model.getValueAt(selectedRowIndex, 1).toString());
        jTextField3.setText(model.getValueAt(selectedRowIndex, 2).toString());
        jTextField4.setText(model.getValueAt(selectedRowIndex, 3).toString());
        jTextField5.setText(model.getValueAt(selectedRowIndex, 4).toString());
        jTextField6.setText(model.getValueAt(selectedRowIndex, 5).toString());
        jTextField7.setText(model.getValueAt(selectedRowIndex, 6).toString());       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:      
        try {
             if((jTextField1.getText()).equals("")){
                JOptionPane.showMessageDialog(null, "Please select your row before commenting");
             }else{
                 new rating().setVisible(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(transactionHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String Query;
        SimpleDateFormat SQLFormat = new SimpleDateFormat("yyyy/MM/dd");
        String roomid = jTextField1.getText();
        String checkInDate=jTextField5.getText();
        String checkOutDate=jTextField6.getText();            
        if((jTextField1.getText()).equals("")){
                JOptionPane.showMessageDialog(null, "Please select your row before deleting");
        }else{
        try {
            ResultSet rs = selection.getData("SELECT * FROM transaction WHERE roomid = '"+roomid+"'");
            if(rs.next()){
                Query = "DELETE FROM transaction WHERE roomid = '"+roomid+"'";
                Update.setData(Query,"Delete Successfully");
                setVisible(false);
                new transactionHistory().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "No such transaction");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new customerPage().setVisible(true);
        customerPage.jLabel4.setText(jLabel10.getText());
        customerPage.jLabel4.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       if((jTextField1.getText()).equals("")){
              JOptionPane.showMessageDialog(null, "Please select your row to generate the invoice");
        }else{
        Document document =new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Invoice1.pdf"));
            document.open();
            document.add(new Paragraph("Invoice",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.BLUE))); 
            document.add(new Paragraph("---------------------------------------------------------------------"));  
            document.add(new Paragraph("\n\n\n\nName:\t"+jTextField8.getText()+"\n\n"+
                                        "RoomID:\t"+jTextField1.getText()+"\n\n"+
                                        "RoomType:\t"+jTextField2.getText()+"\n\n"+
                                        "TotalPay:\t"+jTextField3.getText()+"\n\n"+
                                        "NoOfDay:\t"+jTextField4.getText()+"\n\n"+
                                        "CheckInDate:\t"+jTextField5.getText()+"\n\n"+
                                        "CheckOutDate:\t"+jTextField6.getText()+"\n\n"+
                                        "TransactionTime:\t"+jTextField7.getText()+"\n"
                                       ));
            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(transactionHistory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(transactionHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Invoice Generated Successfully");
       }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(transactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transactionHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
