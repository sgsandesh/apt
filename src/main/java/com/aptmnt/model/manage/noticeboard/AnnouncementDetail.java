package com.aptmnt.model.manage.noticeboard;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sandesh on 9/9/17.
 */
@Entity
@Table(name = "announcement_detail" , catalog = "my_apartment")
public class AnnouncementDetail implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "announcement_detail_id", unique = true, nullable = false)
    private Integer announcementDetailId;

    @Column(name = "notice_announcement_id", nullable = false)
    private Integer noticeAnnouncementId;

    @Column(name = "announcement_point", nullable = false)
    private String announcementPoint;

    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;

    @Column(name = "created_timestamp", nullable = false)
    private Date createdTimestamp;

    @Column(name = "created_user", nullable = false)
    private String createdUser;

    @Column(name = "updated_timestamp", nullable = false)
    private Date updatedTimestamp;

    @Column(name = "updated_user", nullable = false)
    private String updatedUser;
}
