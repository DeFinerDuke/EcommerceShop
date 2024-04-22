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
public class RegistrationInsertError {
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String confirmNotMatch;
    private String fullNameLengthErr;
    private String usernameIsExisted;
    private String phonenumberIsInvalid;
    private String emailIsInvalid;
    public RegistrationInsertError() {
    }

    public RegistrationInsertError(String usernameLengthErr, String passwordLengthErr, String confirmNotMatch, String fullNameLengthErr, String usernameIsExisted, String phonenumberIsInvalid, String emailIsInvalid) {
        this.usernameLengthErr = usernameLengthErr;
        this.passwordLengthErr = passwordLengthErr;
        this.confirmNotMatch = confirmNotMatch;
        this.fullNameLengthErr = fullNameLengthErr;
        this.usernameIsExisted = usernameIsExisted;
        this.phonenumberIsInvalid = phonenumberIsInvalid;
        this.emailIsInvalid = emailIsInvalid;
    }

    

    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    public String getFullNameLengthErr() {
        return fullNameLengthErr;
    }

    public void setFullNameLengthErr(String fullNameLengthErr) {
        this.fullNameLengthErr = fullNameLengthErr;
    }

    public String getUsernameIsExisted() {
        return usernameIsExisted;
    }

    public void setUsernameIsExisted(String usernameIsExisted) {
        this.usernameIsExisted = usernameIsExisted;
    }

    public String getPhonenumberIsInvalid() {
        return phonenumberIsInvalid;
    }

    public void setPhonenumberIsInvalid(String phonenumberIsInvalid) {
        this.phonenumberIsInvalid = phonenumberIsInvalid;
    }

    public String getEmailIsInvalid() {
        return emailIsInvalid;
    }

    public void setEmailIsInvalid(String emailIsInvalid) {
        this.emailIsInvalid = emailIsInvalid;
    }
    
    
}
