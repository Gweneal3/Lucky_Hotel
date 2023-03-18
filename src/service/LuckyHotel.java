/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package service;


import Login.Login;
import java.sql.*;
import javax.swing.JOptionPane;
public class LuckyHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Connection connection;
       Statement statement;
       try{
          connection=database.getConnection();
          statement=connection.createStatement();
//          Creation of table and initialization of values        

//          statement.executeUpdate("create table users(userid int NOT NULL AUTO_INCREMENT,Name varchar(255),Gender varchar(10),Birth varchar(255), PhoneNum varchar(50), Email varchar(200), Password varchar(200),SecurityQuestion varchar(255),Answer varchar(255),Type varchar(15), PRIMARY KEY (userid))");
//          statement.executeUpdate("create table transaction(transaction_id int NOT NULL AUTO_INCREMENT,roomid varchar(20), userid int(20), card_no varchar(100),card_name varchar(100),card_type varchar(100), cvv_no varchar(3),expiry_date varchar(5),total_pay float(50),totalprice float(50), noOfDay integer(10),roomtype varchar(200),checkindate date,checkoutdate date,status tinyint(1),datetimeTransaction timestamp(6),PRIMARY KEY (transaction_id))");
//          statement.executeUpdate("create table roomtypes(roomtype varchar(255),guestAdult integer(10), guestKid integer(10),noOfBed1 integer(10),bedtype1 varchar(200),noOfBed2 integer(10),bedtype2 varchar(200))");
//          statement.executeUpdate("create table room(roomid varchar(255),roomtype varchar(255),rating double ,review varchar(1000) NOT NULL,price integer(10), image blob(10000),description varchar(500), PRIMARY KEY (roomid))");
//          statement.executeUpdate("create table review(reviewID int NOT NULL AUTO_INCREMENT,userid integer(20),roomid varchar(20),rating float(20),comment varchar(255),reviewDate varchar(50),reviewTime varchar(50),PRIMARY KEY (reviewID))");
//          statement.executeUpdate("insert into roomtypes values('Twin',2,1,2,'Super Single',null,null)");
//          statement.executeUpdate("insert into roomtypes values('Double',2,1,1,'Queen',null,null)");
//          statement.executeUpdate("insert into roomtypes values('Disable Room',3,1,1,'King',1,'Single')");
//          statement.executeUpdate("insert into roomtypes values('Double-Double',4,2,2,'Double',null,null)");
//          statement.executeUpdate("insert into roomtypes values('Female Executive Floors',2,null,2,'Single',null,null)");
//          statement.executeUpdate("insert into roomtypes values('Mini Suite',5,3,1,'King',1,'Queen')");
//          statement.executeUpdate("insert into roomtypes values('Quad',4,2,1,'Queen',2,'Single')");
//          statement.executeUpdate("insert into roomtypes values('Single',1,1,1,'Single',null,null)");
//          statement.executeUpdate("insert into roomtypes values('Smoking Room',2,null,2,'Single',null,null)");
//          statement.executeUpdate("insert into roomtypes values('Triple',3,2,1,'Queen',1,'Single')");
//           JOptionPane.showMessageDialog(null, "Table in database successfully created");

       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
         Login login =new Login();
           login.setVisible(true);
    }
    
}
