package com.aptmnt.repository.manage;

import com.aptmnt.model.basic.Role;
import com.aptmnt.model.manage.noticeboard.NoticeBoardAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sandesh on 9/9/17.
 */
public interface NoticeBoardAnnouncementRepository extends JpaRepository<NoticeBoardAnnouncement, Integer> {

}
