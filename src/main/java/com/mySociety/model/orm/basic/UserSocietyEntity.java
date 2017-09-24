package com.mySociety.model.orm.basic;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by sandesh on 9/9/17.
 */

@Entity
@Table(name = "user_society",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"user_id", "society_id"})
)
public class UserSocietyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_society_id", unique = true, nullable = false)
    private int userSocietyId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "society_id", nullable = false)
    private SocietyEntity society;

    @OneToMany(mappedBy = "userSociety")
    private Set<UserSocietyResidenceEntity> userSocietyResidences = new LinkedHashSet<>();


    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "intercom")
    private String intercom;

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



    public int getUserSocietyId() {
        return userSocietyId;
    }

    public void setUserSocietyId(int userSocietyId) {
        this.userSocietyId = userSocietyId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public SocietyEntity getSociety() {
        return society;
    }

    public void setSociety(SocietyEntity society) {
        this.society = society;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UserSocietyResidenceEntity> getUserSocietyResidences() {
        return userSocietyResidences;
    }

    public void setUserSocietyResidences(Set<UserSocietyResidenceEntity> userSocietyResidences) {
        this.userSocietyResidences = userSocietyResidences;
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
