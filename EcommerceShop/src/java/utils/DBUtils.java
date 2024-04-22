/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.UserInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Hoa Doan
 */
public class DBUtils {
//    Do not change this code
    private static final String DB_NAME = "StoreManagement";
    private static final String DB_USER_NAME = "SA";
    private static final String DB_PASSWORD = "12345";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME;
        conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
        return conn;
    }
    
    public static boolean register(String username, String password, String name){
        PreparedStatement stm = null;
        Connection conn = null;
        
        try {
            conn = DBUtils.getConnection();
            String sql = "INSERT INTO USERFB (Username, Password, Name) Values (?, ?, ?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, name);
            int row = stm.executeUpdate();
            return row > 0;
        } catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                if (stm != null){
                    stm.close();
                }
                if (conn != null){
                    conn.close();
                }
                
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    public static UserInfo checkLogin(String username, String password){
         PreparedStatement stm = null;
        Connection conn = null;
        
        return null;
    }
}
