package com.mySociety.model.orm.manage.noticeboard;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by sandesh on 9/9/17.
 */

@Entity
@Table(name = "notice_board_announcement")
public class NoticeBoardAnnouncement implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notice_announcement_id", unique = true, nullable = false)
    private Integer noticeAnnouncementId;

    @Column(name = "society_id", nullable = false)
    private Integer societyId;

    @Column(name = "subject", nullable = false)
    private String subject;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noticeAnnouncementId")
//    @JoinTable(name = "announcement_detail", joinColumns = @JoinColumn(name = "notice_announcement_id"), inverseJoinColumns = @JoinColumn(name = "announcement_detail_id"))
    private Set<AnnouncementDetail> announcementDetails;

    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;

    @Column(name = "importance", nullable = false)
    private String importance;

    @Column(name = "notice_removal_date")
    private Date noticeRemovalDate;

    @Column(name = "created_timestamp", nullable = false)
    private Date createdTimestamp;

    @Column(name = "created_user_id", nullable = false)
    private String createdUserId;

    @Column(name = "updated_timestamp", nullable = false)
    private Date updatedTimestamp;

    @Column(name = "updated_user_id", nullable = false)
    private String updatedUserId;

    public Integer getNoticeAnnouncementId() {
        return noticeAnnouncementId;
    }

    public void setNoticeAnnouncementId(Integer noticeAnnouncementId) {
        this.noticeAnnouncementId = noticeAnnouncementId;
    }

    public Integer getSocietyId() {
        return societyId;
    }

    public void setSocietyId(Integer societyId) {
        this.societyId = societyId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<AnnouncementDetail> getAnnouncementDetails() {
        return announcementDetails;
    }

    public void setAnnouncementDetails(Set<AnnouncementDetail> announcementDetails) {
        this.announcementDetails = announcementDetails;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public Date getNoticeRemovalDate() {
        return noticeRemovalDate;
    }

    public void setNoticeRemovalDate(Date noticeRemovalDate) {
        this.noticeRemovalDate = noticeRemovalDate;
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

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }
}
