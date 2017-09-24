package com.mySociety.model.view.basic;

import com.mySociety.model.orm.manage.noticeboard.NoticeBoardAnnouncement;

import java.util.Set;

/**
 * Created by sandesh on 17/9/17.
 */
public class UserSocietyView {

    private String country;

    private String state;

    private String societyName;

    private String city;

    private String roleName;

    private String residenceNumber;

    private String intercom;

    private char active;

    private Set<NoticeBoardAnnouncement> noticeBoardAnnouncements;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getResidenceNumber() {
        return residenceNumber;
    }

    public void setResidenceNumber(String residenceNumber) {
        this.residenceNumber = residenceNumber;
    }

    public String getIntercom() {
        return intercom;
    }

    public void setIntercom(String intercom) {
        this.intercom = intercom;
    }

    public char getActive() {
        return active;
    }

    public void setActive(char active) {
        this.active = active;
    }

    public Set<NoticeBoardAnnouncement> getNoticeBoardAnnouncements() {
        return noticeBoardAnnouncements;
    }

    public void setNoticeBoardAnnouncements(Set<NoticeBoardAnnouncement> noticeBoardAnnouncements) {
        this.noticeBoardAnnouncements = noticeBoardAnnouncements;
    }
}
