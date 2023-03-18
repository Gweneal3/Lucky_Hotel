/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import java.sql.*;
import javax.swing.JOptionPane;
public class selection {
    public static ResultSet getData(String query){
        Connection connection =null;
        Statement statement=null;
        ResultSet resultset=null;
        try{
             connection=database.getConnection();
             statement=connection.createStatement();
             resultset=statement.executeQuery(query);
             return resultset;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
