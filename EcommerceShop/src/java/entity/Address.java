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
public class Address {

    private String AddressID;
    private String FullName;
    private String PhoneNumber;
    private String City;
    private String District;
    private String Ward;
    private String StreetNameHouseNo;
    private String Label;
    private int Default;

    public Address() {
    }

    public Address(String AddressID, String FullName, String PhoneNumber, String City, String District, String Ward, String StreetNameHouseNo, String Label, int Default) {
        this.AddressID = AddressID;
        this.FullName = FullName;
        this.PhoneNumber = PhoneNumber;
        this.City = City;
        this.District = District;
        this.Ward = Ward;
        this.StreetNameHouseNo = StreetNameHouseNo;
        this.Label = Label;
        this.Default = Default;
    }

    public String getAddressID() {
        return AddressID;
    }

    public void setAddressID(String AddressID) {
        this.AddressID = AddressID;
    }
    

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public String getWard() {
        return Ward;
    }

    public void setWard(String Ward) {
        this.Ward = Ward;
    }

    public String getStreetNameHouseNo() {
        return StreetNameHouseNo;
    }

    public void setStreetNameHouseNo(String StreetNameHouseNo) {
        this.StreetNameHouseNo = StreetNameHouseNo;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String Label) {
        this.Label = Label;
    }

    public int getDefault() {
        return Default;
    }

    public void setDefault(int Default) {
        this.Default = Default;
    }

}
