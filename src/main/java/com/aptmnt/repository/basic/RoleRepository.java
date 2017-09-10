package com.aptmnt.repository.basic;

import com.aptmnt.model.basic.Apartment;
import com.aptmnt.model.basic.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sandesh on 9/9/17.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
