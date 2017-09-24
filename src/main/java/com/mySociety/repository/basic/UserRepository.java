package com.mySociety.repository.basic;

import com.mySociety.model.orm.basic.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sandesh on 9/9/17.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
     UserEntity findByEmail(final String email);
     UserEntity findByUserId(final Integer userId);
}
