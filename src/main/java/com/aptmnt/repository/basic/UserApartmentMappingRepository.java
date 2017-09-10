package com.aptmnt.repository.basic;

import com.aptmnt.model.basic.UserApartment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sandesh on 9/9/17.
 */
public interface UserApartmentMappingRepository extends JpaRepository<UserApartment, Integer> {
}
