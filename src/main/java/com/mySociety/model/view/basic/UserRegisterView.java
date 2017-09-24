package com.mySociety.model.view.basic;

/**
 * Created by sandesh on 9/9/17.
 */

public class UserRegisterView {
    private String email;

    private String password;

    private String fullName;

    private String phoneNumber;

    private char hidePhoneNumber;
    private char hideEmail;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getHidePhoneNumber() {
        return hidePhoneNumber;
    }

    public void setHidePhoneNumber(char hidePhoneNumber) {
        this.hidePhoneNumber = hidePhoneNumber;
    }

    public char getHideEmail() {
        return hideEmail;
    }

    public void setHideEmail(char hideEmail) {
        this.hideEmail = hideEmail;
    }
}
