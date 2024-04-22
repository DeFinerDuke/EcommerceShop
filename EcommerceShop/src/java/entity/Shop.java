/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author BenNguyen
 */
public class Shop {
    private String storeID;
    private int followers;
    private double rating;
    private Date joinedDate;
    private String storeName;
    private int products;

    public Shop() {
    }

    
    public Shop(String storeID, int followers, double rating, Date joinedDate, String storeName, int products) {
        this.storeID = storeID;
        this.followers = followers;
        this.rating = rating;
        this.joinedDate = joinedDate;
        this.storeName = storeName;
        this.products = products;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }
    
    
}
