package com.mySociety.model.orm.basic;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sandesh on 9/9/17.
 */
@Entity
@Table(name = "user_society_residence",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"user_society_id", "society_residence_id"}))
public class UserSocietyResidenceEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_society_residence_id", unique = true, nullable = false)
    private int userSocietyResidenceId;

    @ManyToOne
    @JoinColumn(name = "user_society_id", nullable = false)
    private UserSocietyEntity userSociety;

    @ManyToOne
    @JoinColumn(name = "society_residence_id", nullable = false)
    private SocietyResidenceEntity societyResidence;

    @Column(name = "resident_type", nullable = false)
    private String residentType;


    public int getUserSocietyResidenceId() {
        return userSocietyResidenceId;
    }

    public void setUserSocietyResidenceId(int userSocietyResidenceId) {
        this.userSocietyResidenceId = userSocietyResidenceId;
    }

    public UserSocietyEntity getUserSociety() {
        return userSociety;
    }

    public void setUserSociety(UserSocietyEntity userSociety) {
        this.userSociety = userSociety;
    }

    public SocietyResidenceEntity getSocietyResidence() {
        return societyResidence;
    }

    public void setSocietyResidence(SocietyResidenceEntity societyResidence) {
        this.societyResidence = societyResidence;
    }

    public String getResidentType() {
        return residentType;
    }

    public void setResidentType(String residentType) {
        this.residentType = residentType;
    }
}

