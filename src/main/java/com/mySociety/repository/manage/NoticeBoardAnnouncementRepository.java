package com.mySociety.repository.manage;

import com.mySociety.model.orm.manage.noticeboard.NoticeBoardAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sandesh on 9/9/17.
 */
public interface NoticeBoardAnnouncementRepository extends JpaRepository<NoticeBoardAnnouncement, Integer> {

}
