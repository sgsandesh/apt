package com.mySociety.repository.basic;

import com.mySociety.model.orm.basic.SocietyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sandesh on 9/9/17.
 */
public interface SocietyRepository extends JpaRepository<SocietyEntity, Integer> {
    SocietyEntity findBySocietyName(final String societyName);
    SocietyEntity findBySocietyId(final Integer societyid);
}
