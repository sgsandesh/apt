package com.mySociety.services.basic;

import com.mySociety.model.orm.basic.SocietyEntity;
import com.mySociety.repository.basic.SocietyRepository;
import com.mySociety.utils.Constants;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.mySociety.utils.Constants.Role.ADMIN;

/**
 * Created by sandesh on 10/9/17.
 */
@Component
public class SocietyService {
    private final SocietyRepository societyRepository;
    private final UserSocietyService userSocietyService;


    public SocietyService(SocietyRepository societyRepository, UserSocietyService userSocietyService) {
        this.societyRepository = societyRepository;
        this.userSocietyService = userSocietyService;
    }

    public List<SocietyEntity> getAll() {
        return societyRepository.findAll();
    }

    public SocietyEntity getSocietyDetails(final Integer societyId) {
        return societyRepository.findBySocietyId(societyId);
    }

    @Transactional
    public void create(final SocietyEntity societyEntity, final Integer userId) throws Exception {
        if(societyRepository.findBySocietyName(societyEntity.getSocietyName()) != null){
            throw new Exception("Society name already exists");
        }
        societyEntity.setCreatedUser("LOGGED-IN-USER-ID");
        societyEntity.setCreatedTimestamp(new Date());
        addAuditDetails(societyEntity, "LOGGED-IN-USER-ID", "Y");
        final SocietyEntity societyRegistered = societyRepository.saveAndFlush(societyEntity);
        userSocietyService.addMap(userId, societyRegistered.getSocietyId(), ADMIN.name());
    }

    @Transactional
    public SocietyEntity update(SocietyEntity societyEntity) throws Exception {
        SocietyEntity existingEntity = societyRepository.findBySocietyId(societyEntity.getSocietyId());
        if(existingEntity == null){
            throw new Exception("SocietyEntity does not exist");
        }
        existingEntity.setSocietyName(societyEntity.getSocietyName());
        existingEntity.setCity(societyEntity.getCity());
        addAuditDetails(existingEntity, "LOGGED-IN-USER-ID", "Y");
        return existingEntity;
    }

    private void addAuditDetails(final SocietyEntity apartmentEntity, final String userName, final String isActive) {
        apartmentEntity.setUpdatedUser(userName);
        apartmentEntity.setUpdatedTimestamp(new Date());
        apartmentEntity.setActive(isActive);
    }
}
