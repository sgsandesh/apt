package com.aptmnt.model.manage.noticeboard;

import com.aptmnt.model.basic.Apartment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by sandesh on 9/9/17.
 */

@Entity
@Table(name = "notice_board_announcement", catalog = "my_apartment")
public class NoticeBoardAnnouncement implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notice_announcement_id", unique = true, nullable = false)
    private Integer noticeAnnouncementId;

    @Column(name = "apt_id", nullable = false)
    private Integer aptId;

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

    @Column(name = "created_user", nullable = false)
    private String createdUser;

    @Column(name = "updated_timestamp", nullable = false)
    private Date updatedTimestamp;

    @Column(name = "updated_user", nullable = false)
    private String updatedUser;
}
