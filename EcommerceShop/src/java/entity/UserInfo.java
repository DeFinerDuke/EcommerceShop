/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author BenNguyen
 */
public class UserInfo {
    @SerializedName(value="userId")
    private String id;
    @SerializedName (value="id")
    private String facebookID;
    private String name;
    private String username;
    private String link;

    public UserInfo() {
    }

    public UserInfo(String id, String facebookID, String name, String username, String link) {
        this.id = id;
        this.facebookID = facebookID;
        this.name = name;
        this.username = username;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
}
