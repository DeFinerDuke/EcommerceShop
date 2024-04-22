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
public class Product {
    private String storeID;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private String type;
    private Date createdDate;
    private String image;

    public Product() {
    }

    public Product(String storeID, String name, double price, int quantity, String description, String type, Date createdDate, String image) {
        this.storeID = storeID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.type = type;
        this.createdDate = createdDate;
        this.image = image;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
}
