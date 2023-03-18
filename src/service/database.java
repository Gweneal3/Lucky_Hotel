/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
public class database {
    public static Connection getConnection() throws Exception{
    try{
            String dbURL = "jdbc:mysql://hoteldb.mysql.database.azure.com:3306/hoteldb?useSSL=true";
            String user = "jiayang";
            String pass = "Jy316#!^";
            Connection connection = DriverManager.getConnection(dbURL, user, pass);
            return connection;       
        }catch (SQLException e) {
            System.out.println(e);
        }
    
      return null;      
    }
  
}
