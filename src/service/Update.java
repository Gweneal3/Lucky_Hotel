/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import java.sql.*;
import javax.swing.JOptionPane;
public class Update {
    public static void setData(String query, String message){
        Connection connection=null;
        Statement statement=null;
        try{
            connection=database.getConnection();
            statement=connection.createStatement();
            statement.executeUpdate(query);
            if(!message.equals(""))
                JOptionPane.showMessageDialog(null, message);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally{
            try{
                connection.close();
                statement.close();
            }
            catch(Exception e){            
            }
        }
    }
}
