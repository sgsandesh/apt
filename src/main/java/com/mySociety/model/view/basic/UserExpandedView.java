package com.mySociety.model.view.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandesh on 17/9/17.
 */
public class UserExpandedView {

    private Integer userId;

    private String email;

    private String fullName;

    private String phoneNumber;


    private List<UserSocietyView> societies = new ArrayList<>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public List<UserSocietyView> getSocieties() {
        return societies;
    }

    public void setSocieties(List<UserSocietyView> societies) {
        this.societies = societies;
    }
}
