package com.aptmnt.model.basic;

import com.aptmnt.model.manage.noticeboard.NoticeBoardAnnouncement;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by sandesh on 9/9/17.
 */

@Entity
@Table(name = "apartment", catalog = "my_apartment", uniqueConstraints = {
        @UniqueConstraint(columnNames = "apt_name")})
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apt_id", unique = true, nullable = false)
    private Integer aptId;

/*    @Column(name = "country", nullable = false)
    @NotEmpty(message = "*Please provide valid country")
    private String country;

    @Column(name = "state", nullable = false)
    @NotEmpty(message = "*Please provide your state")
    private String state;*/

    @Column(name = "apt_name", nullable = false)
    @NotEmpty(message = "*Please provide your apartment/society name")
    private String aptName;

    @Column(name = "city", nullable = false)
    @NotEmpty(message = "*Please provide your city")
    private String city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aptId")
//    @JoinTable(joinColumns = @JoinColumn(name = "apt_id"), inverseJoinColumns = @JoinColumn(name = "notice_announcement_id"))
    private Set<NoticeBoardAnnouncement> noticeBoardAnnouncements;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aptId")
//    @JoinTable(joinColumns = @JoinColumn(name = "apt_id"), inverseJoinColumns = @JoinColumn(name = "notice_announcement_id"))
    private Set<UserApartment> userApartmentMappings;

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


    public Integer getAptId() {
        return aptId;
    }

    public void setAptId(Integer aptId) {
        this.aptId = aptId;
    }

    public String getAptName() {
        return aptName;
    }

    public void setAptName(String aptName) {
        this.aptName = aptName;
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

    public Set<UserApartment> getUserApartmentMappings() {
        return userApartmentMappings;
    }

    public void setUserApartmentMappings(Set<UserApartment> userApartmentMappings) {
        this.userApartmentMappings = userApartmentMappings;
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