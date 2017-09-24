package com.mySociety.model.view.basic;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by sandesh on 24/9/17.
 */
public class DisplayUserSociety {
    private String societyName;
    private String city;
    private String active;
    private String role;
    private Set<DisplayResidence> displayResidences = new LinkedHashSet<>();

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<DisplayResidence> getDisplayResidences() {
        return displayResidences;
    }

    public void setDisplayResidences(Set<DisplayResidence> displayResidences) {
        this.displayResidences = displayResidences;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
