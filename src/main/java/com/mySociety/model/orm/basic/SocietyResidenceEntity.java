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
@Table(name = "society_residence",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"society_id", "block_number", "residence_number"}))
public class SocietyResidenceEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "society_residence_id", unique = true, nullable = false)
    private int societyResidenceId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "societyResidence")
    private Set<UserSocietyResidenceEntity> userSocietyResidences;

    @ManyToOne
    @JoinColumn(name = "society_id", nullable = false)
    private SocietyEntity society;

    @Column(name = "block_number")
    private String blockNumber;

    @Column(name = "residence_number", nullable = false)
    private String residenceNumber;

    @Column(name = "intercom")
    private String intercom;

    public Set<UserSocietyResidenceEntity> getUserSocietyResidences() {
        return userSocietyResidences;
    }

    public void setUserSocietyResidences(Set<UserSocietyResidenceEntity> userSocietyResidences) {
        this.userSocietyResidences = userSocietyResidences;
    }

    public SocietyEntity getSociety() {
        return society;
    }

    public void setSociety(SocietyEntity society) {
        this.society = society;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public int getSocietyResidenceId() {
        return societyResidenceId;
    }

    public void setSocietyResidenceId(int societyResidenceId) {
        this.societyResidenceId = societyResidenceId;
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


}
