/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Address;
import entity.User;
import entity.UserDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author BenNguyen
 */
public class UserDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public UserDTO CheckLogin(String Username, String Password) {
        String query = "select * from verifieduser where username = ? and password = ?";

        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Username);
            ps.setString(2, Password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new UserDTO(
                        rs.getString(1),
                        rs.getString(2));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    public User Profile(String Username) {
        String query = "select * from [USER] WHERE USERNAME = ?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getDate(7)
                );
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    public ArrayList<Address> Addresses(String Username) {
        String query = "select ad.ADDRESSID, ad.FULLNAME, ad.PHONENUMBER, ad.CITY, ad.DISTRICT, ad.WARD, ad.STREETNAMEANDHOUSENO, ad.LABEL, ad.[DEFAULT] from [ADDRESS] ad, [USER] u where ad.USERID = u.USERID and u.USERNAME = ? ";
        ArrayList<Address> lstAddress = new ArrayList();
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Username);
            rs = ps.executeQuery();
            while (rs.next()) {
                Address address = new Address();
                address.setAddressID(rs.getString(1));
                address.setFullName(rs.getString(2));
                address.setPhoneNumber(rs.getString(3));
                address.setCity(rs.getString(4));
                address.setDistrict(rs.getString(5));
                address.setWard(rs.getString(6));
                address.setStreetNameHouseNo(rs.getString(7));
                address.setLabel(rs.getString(8));
                address.setDefault(rs.getInt(9));
                lstAddress.add(address);
            }
            return lstAddress;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    public boolean AddAddress(String FullName, String PhoneNumber, String City, String District, String Ward, String StreetNameHouseNo, String Label, String Default, String Username) {
        String query = "INSERT INTO [ADDRESS] (FULLNAME, PHONENUMBER, CITY, DISTRICT, WARD, STREETNAMEANDHOUSENO, [LABEL], [DEFAULT], USERID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, (SELECT USERID FROM [USER] WHERE USERNAME = ?))";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, FullName);
            ps.setString(2, PhoneNumber);
            ps.setString(3, City);
            ps.setString(4, District);
            ps.setString(5, Ward);
            ps.setString(6, StreetNameHouseNo);
            ps.setString(7, Label);
            ps.setString(8, Default);
            ps.setString(9, Username);
            int row = ps.executeUpdate();
            return row > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return false;
    }

    public boolean DeleteAddress(String AddressID) {
        String query = "delete from [ADDRESS] where ADDRESSID = ?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, AddressID);
            int ans = ps.executeUpdate();
            return ans > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return false;
    }

    public boolean UpdateAddress(String FullName, String PhoneNumber, String City, String District, String Ward, String StreetNameHouseNo, String Label, String Default, String AddressID) {
        String query = "UPDATE [ADDRESS] SET FULLNAME = ?, PHONENUMBER = ?, CITY = ?, DISTRICT = ?, WARD = ?, STREETNAMEANDHOUSENO = ?, [LABEL] = ?, [DEFAULT] = ? WHERE ADDRESSID = ?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, FullName);
            ps.setString(2, PhoneNumber);
            ps.setString(3, City);
            ps.setString(4, District);
            ps.setString(5, Ward);
            ps.setString(6, StreetNameHouseNo);
            ps.setString(7, Label);
            ps.setString(8, Default);
            ps.setString(9, AddressID);
            int row = ps.executeUpdate();
            return row > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return false;
    }

    public boolean ChangePassword(String Username, String Password) {
        String query = "update VERIFIEDUSER set [PASSWORD] = ? where USERNAME = ?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Password);
            ps.setString(2, Username);
            int ans = ps.executeUpdate();
            return ans > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return false;
    }

    public UserDTO CheckedPassword(String Username, String Password) {
        String query = "SELECT * FROM VERIFIEDUSER WHERE USERNAME = ? AND [PASSWORD] = ?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Username);
            ps.setString(2, Password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new UserDTO(rs.getString(2), rs.getString(3));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return null;
    }

    public boolean UpdateAccount(String Username, String Name, String PhoneNumber, String Gender, String DOB) {
        String query = "UPDATE [USER] SET FULLNAME = ? , PHONENUMBER = ?, GENDER = ?, DOB = ? WHERE USERNAME = ?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Name);
            ps.setString(2, PhoneNumber);
            ps.setString(3, Gender);
            ps.setString(4, DOB);
            ps.setString(5, Username);
            int ans = ps.executeUpdate();
            return ans > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }

        return false;
    }

    public boolean RegisterAccount(String Username, String FullName, String PhoneNumber, String Email, String Gender, String DOB) {
        String query = "INSERT INTO [USER](USERNAME, [FULLNAME], EMAIL, PHONENUMBER, GENDER, DOB)"
                + "VALUES (?, ?, ?, ?, ?, ?);";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Username);
            ps.setString(2, FullName);
            ps.setString(3, Email);
            ps.setString(4, PhoneNumber);
            ps.setString(5, Gender);
            ps.setString(6, DOB);
            int ans = ps.executeUpdate();
            return ans > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }

        return false;
    }

    public boolean CreatePassword(String Username, String Password) {
        String query = "INSERT INTO VERIFIEDUSER (USERID, USERNAME, [PASSWORD]) SELECT USERID, USERNAME, ? FROM [USER]  WHERE USERNAME = ?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Password);
            ps.setString(2, Username);
            int ans = ps.executeUpdate();
            return ans > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return false;
    }
}
