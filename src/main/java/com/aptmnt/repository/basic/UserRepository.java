package com.aptmnt.repository.basic;

import com.aptmnt.model.basic.Role;
import com.aptmnt.model.basic.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sandesh on 9/9/17.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
     User findByEmail(final String email);
}
