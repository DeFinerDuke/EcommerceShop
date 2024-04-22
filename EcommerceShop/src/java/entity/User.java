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
public class User {
    private String UserName;
    private String FullName;
    private String Email;
    private int PhoneNumber;
    private String Gender;
    private Date DOB;

    public User() {
    }

    public User(String UserName, String FullName, String Email, int PhoneNumber, String Gender, Date DOB) {
        this.UserName = UserName;
        this.FullName = FullName;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Gender = Gender;
        this.DOB = DOB;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
    
    
}
