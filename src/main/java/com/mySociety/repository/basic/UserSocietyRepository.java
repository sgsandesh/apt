package com.mySociety.repository.basic;

import com.mySociety.model.orm.basic.SocietyEntity;
import com.mySociety.model.orm.basic.UserEntity;
import com.mySociety.model.orm.basic.UserSocietyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sandesh on 9/9/17.
 */
public interface UserSocietyRepository extends JpaRepository<UserSocietyEntity, Integer> {
    UserSocietyEntity findByUserAndSociety(final UserEntity user, final SocietyEntity society);

}
