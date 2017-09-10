package com.aptmnt.repository.basic;

import com.aptmnt.model.basic.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sandesh on 9/9/17.
 */
public interface ApartmentRepository  extends JpaRepository<Apartment, Integer> {
    Apartment findByAptName(final String aptName);
    Apartment findByAptId(final Integer aptid);
}
