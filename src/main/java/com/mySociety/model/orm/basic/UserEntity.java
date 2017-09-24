package com.mySociety.model.orm.basic;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by sandesh on 9/9/17.
 */

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    private int userId;

    @Column(name = "email", nullable = false)
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "password", nullable = false)
    @Length(min = 8, message = "*Your password must have at least 8 characters")
    @NotEmpty(message = "*Please provide your password")
//    @Transient
    private String password;

    @Column(name = "full_name", nullable = false)
    @NotEmpty(message = "*Please provide your full name")
    private String fullName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "hide_phone_number", nullable = false, columnDefinition = "char default 'N'")
    private char hidePhoneNumber;

    @Column(name = "hide_email", nullable = false, columnDefinition = "char default 'N'")
    private char hideEmail;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<UserSocietyEntity> userSocietyMappings;

    @Column(name = "active", nullable = false)
    private char active;

    @Column(name = "created_timestamp", nullable = false)
    private Date createdTimestamp;


    @Column(name = "updated_timestamp", nullable = false)
    private Date updatedTimestamp;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<UserSocietyEntity> getUserSocietyMappings() {
        return userSocietyMappings;
    }

    public void setUserSocietyMappings(Set<UserSocietyEntity> userSocietyMappings) {
        this.userSocietyMappings = userSocietyMappings;
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

    public Date getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Date updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

}
