/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author BenNguyen
 */
public class StoreDTO {
    private String StoreID;
    private String StoreName;

    public StoreDTO() {
    }

    public StoreDTO(String StoreID, String StoreName) {
        this.StoreID = StoreID;
        this.StoreName = StoreName;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String StoreID) {
        this.StoreID = StoreID;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String StoreName) {
        this.StoreName = StoreName;
    }
    
    
}
