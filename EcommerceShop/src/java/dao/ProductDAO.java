/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.InsertedProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import utils.DBUtils;

/**
 *
 * @author BenNguyen
 */
public class ProductDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean addProduct(String storeID, String name, String price, String quantity, String description, String type, String image) {
        java.util.Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String createdDate = dateFormat.format(date);
        String query = "INSERT INTO PRODUCT (STOREID, PRODUCTNAME, ORIGINALPRICE, QUANTITY, PRODUCTDESCRIPTION, [TYPE], CREATEDDATE, LINKIMAGE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, storeID);
            ps.setString(2, name);
            ps.setString(3, price);
            ps.setString(4, quantity);
            ps.setString(5, description);
            ps.setString(6, type);
            ps.setString(7, createdDate);
            ps.setString(8, image);
            int ans = ps.executeUpdate();
            return ans > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return false;
    }

    public ArrayList<InsertedProduct> showListSpecificProduct(String storeID) {
        ArrayList<InsertedProduct> listProduct = new ArrayList();
        String query = "SELECT * FROM PRODUCT WHERE STOREID = ?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, storeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                InsertedProduct product = new InsertedProduct();
                product.setProductID(rs.getString("PRODUCTID"));
                product.setName(rs.getString("PRODUCTNAME"));
                product.setPrice(rs.getDouble("ORIGINALPRICE"));
                product.setQuantity(rs.getInt("QUANTITY"));
                product.setDescription(rs.getString("PRODUCTDESCRIPTION"));
                product.setType(rs.getString("TYPE"));
                product.setCreatedDate(rs.getDate("CREATEDDATE"));
                product.setLinkIMG(rs.getString("LINKIMAGE"));
                listProduct.add(product);
            }
            return listProduct;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return null;
    }
      
    public ArrayList<InsertedProduct> showListProduct() {
        ArrayList<InsertedProduct> listProduct = new ArrayList();
        String query = "SELECT * FROM PRODUCT";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                InsertedProduct product = new InsertedProduct();
                product.setProductID(rs.getString("PRODUCTID"));
                product.setName(rs.getString("PRODUCTNAME"));
                product.setPrice(rs.getDouble("ORIGINALPRICE"));
                product.setQuantity(rs.getInt("QUANTITY"));
                product.setDescription(rs.getString("PRODUCTDESCRIPTION"));
                product.setType(rs.getString("TYPE"));
                product.setCreatedDate(rs.getDate("CREATEDDATE"));
                product.setLinkIMG(rs.getString("LINKIMAGE"));
                listProduct.add(product);
            }
            return listProduct;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return null;
    }
}
