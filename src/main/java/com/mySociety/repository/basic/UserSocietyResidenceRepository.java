package com.mySociety.repository.basic;

import com.mySociety.model.orm.basic.*;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sandesh on 9/9/17.
 */
public interface UserSocietyResidenceRepository extends JpaRepository<UserSocietyResidenceEntity, Integer> {
    UserSocietyResidenceEntity findByUserSocietyAndSocietyResidence(final UserSocietyEntity userSociety,
                                                           final SocietyResidenceEntity societyResidence);

}
