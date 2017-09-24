package com.mySociety.repository.basic;

import com.mySociety.model.orm.basic.SocietyEntity;
import com.mySociety.model.orm.basic.SocietyResidenceEntity;
import com.mySociety.model.orm.basic.UserSocietyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by sandesh on 9/9/17.
 */
public interface SocietyResidenceRepository extends JpaRepository<SocietyResidenceEntity, Integer> {
    Set<SocietyResidenceEntity> findBySociety(final SocietyEntity society);
    SocietyResidenceEntity findBySocietyAndBlockNumberAndResidenceNumber(final SocietyEntity society,
                                                                         final String blockNumber, final String residenceNumber);

}
