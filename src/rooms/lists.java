/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rooms;
import java.sql.*;
import java.util.*;
import service.*;

/**
 *
 * @author jiaya
 */
public class lists {
    public ArrayList<RoomAvailable> BindTable(String query){
        
   ArrayList<RoomAvailable> list = new ArrayList<>();
   Connection con;
   Statement st;
   ResultSet rs;
        try {
             con = database.getConnection();
             st = con.createStatement();
             rs=st.executeQuery(query);
             RoomAvailable p;
                while(rs.next()){
                    p = new RoomAvailable(
                    rs.getString("roomid"),
                    rs.getString("roomtype"),
                    rs.getInt("guestAdult"),
                    rs.getInt("guestKid"),
                    rs.getInt("noOfBed1"),
                    rs.getInt("noOfBed2"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getBytes("image"),
                    rs.getDouble("rating"),
                    rs.getString("Review"));          
                     list.add(p);
             }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(lists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
   return list;
   }
}

