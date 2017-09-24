package com.mySociety.model.orm.basic;

import com.mySociety.model.orm.manage.noticeboard.NoticeBoardAnnouncement;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by sandesh on 9/9/17.
 */

@Entity
@Table(name = "society")
public class SocietyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "society_id", unique = true, nullable = false)
    private Integer societyId;

    @Column(name = "country", nullable = false)
    @NotEmpty(message = "*Please provide valid country")
    private String country;

    @Column(name = "state", nullable = false)
    @NotEmpty(message = "*Please provide your state")
    private String state;

    @Column(name = "society_name", nullable = false, unique = true)
    @NotEmpty(message = "*Please provide your apartment/society name")
    private String societyName;

    @Column(name = "city", nullable = false)
    @NotEmpty(message = "*Please provide your city")
    private String city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "societyId")
    private Set<NoticeBoardAnnouncement> noticeBoardAnnouncements;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "society")
    private Set<UserSocietyEntity> userSociety;

    @Column(name = "active", nullable = false)
    private char active;

    @Column(name = "created_timestamp", nullable = false)
    private Date createdTimestamp;

    @Column(name = "created_user", nullable = false)
    private String createdUser;

    @Column(name = "updated_timestamp", nullable = false)
    private Date updatedTimestamp;

    @Column(name = "updated_user", nullable = false)
    private String updatedUser;


    public Integer getSocietyId() {
        return societyId;
    }

    public void setSocietyId(Integer societyId) {
        this.societyId = societyId;
    }

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

    public Set<NoticeBoardAnnouncement> getNoticeBoardAnnouncements() {
        return noticeBoardAnnouncements;
    }

    public void setNoticeBoardAnnouncements(Set<NoticeBoardAnnouncement> noticeBoardAnnouncements) {
        this.noticeBoardAnnouncements = noticeBoardAnnouncements;
    }

    public Set<UserSocietyEntity> getUserSociety() {
        return userSociety;
    }

    public void setUserSociety(Set<UserSocietyEntity> userSociety) {
        this.userSociety = userSociety;
    }


    public char getActive() {
        return active;
    }

    public void setActive(char active) {
        this.active = active;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Date updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }
}