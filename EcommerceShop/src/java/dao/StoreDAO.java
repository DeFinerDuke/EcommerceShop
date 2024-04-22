/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.StoreDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import utils.DBUtils;

/**
 *
 * @author BenNguyen
 */
public class StoreDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public StoreDTO checkRegisterShop(String Username) {
        String query = "select st.STOREID, st.STORENAME from STORE st, [USER] u where st.USERID = u.USERID and u.USERNAME = ?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new StoreDTO(rs.getString(1), rs.getString(2));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    public boolean RegisterStore(String StoreName, String UserName) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String joinedDate = dateFormat.format(date);
        String query = "INSERT INTO STORE (USERID,STORENAME,JOINEDDATE) SELECT USERID, ?, ? FROM [USER] WHERE USERNAME = ?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, StoreName);
            ps.setString(2, joinedDate);
            ps.setString(3, UserName);
            int ans = ps.executeUpdate();
            return ans > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return false;
    }
    
    
}
