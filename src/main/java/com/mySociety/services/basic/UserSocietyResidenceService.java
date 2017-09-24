package com.mySociety.services.basic;

import com.mySociety.model.orm.basic.*;
import com.mySociety.model.view.basic.UserSocietyResidenceView;
import com.mySociety.repository.basic.SocietyRepository;
import com.mySociety.repository.basic.UserRepository;
import com.mySociety.repository.basic.UserSocietyRepository;
import com.mySociety.repository.basic.UserSocietyResidenceRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;

import static com.mySociety.utils.Constants.Role;
import static com.mySociety.utils.Constants.roleLookup;

/**
 * Created by sandesh on 10/9/17.
 */
@Component
public class UserSocietyResidenceService {

    private final UserSocietyRepository userSocietyRepository;
    private final SocietyRepository societyRepository;
    private final UserRepository userRepository;
    private final SocietyResidenceService societyResidenceService;
    private final UserSocietyResidenceRepository userSocietyResidenceRepository;

    public UserSocietyResidenceService(UserSocietyRepository userSocietyRepository,
                                       SocietyRepository societyRepository, UserRepository userRepository,
                                       SocietyResidenceService societyResidenceService, UserSocietyResidenceRepository userSocietyResidenceRepository) {
        this.userSocietyRepository = userSocietyRepository;
        this.societyRepository = societyRepository;
        this.userRepository = userRepository;
        this.societyResidenceService = societyResidenceService;
        this.userSocietyResidenceRepository = userSocietyResidenceRepository;
    }


    @Transactional
    public void addResidence(final UserSocietyResidenceView userSocietyResidenceView) throws Exception {
        final UserEntity user = userRepository.findByUserId(userSocietyResidenceView.getUserId());
        final SocietyEntity society = societyRepository.findBySocietyId(userSocietyResidenceView.getSocietyId());
        final UserSocietyEntity userSociety = userSocietyRepository.findByUserAndSociety(user, society);

        if (userSociety == null) {
            throw new Exception(String.format("Error adding residence details!!. User %s is not a member of %s society",
                    user.getFullName(), society.getSocietyName()));
        }

        final String blockNumber = userSocietyResidenceView.getBlockNumber();
        final String residenceNumber = userSocietyResidenceView.getResidenceNumber();
        final String residentType = userSocietyResidenceView.getResidentType();

        addResidence(society, userSociety, blockNumber, residenceNumber, residentType);
    }


    public void addResidence(SocietyEntity society, UserSocietyEntity userSociety,
                     String blockNumber, String residenceNumber, String residentType) throws Exception {
        final SocietyResidenceEntity societyResidenceEntity = societyResidenceService.
                validateIfResidenceExistInSociety(society, blockNumber, residenceNumber);
        UserSocietyResidenceEntity userSocietyResidenceEntity = new UserSocietyResidenceEntity();
        userSocietyResidenceEntity.setUserSociety(userSociety);
        userSocietyResidenceEntity.setSocietyResidence(societyResidenceEntity);
        userSocietyResidenceEntity.setResidentType(residentType);

        userSocietyResidenceRepository.save(userSocietyResidenceEntity);
        userSociety.getUserSocietyResidences().add(userSocietyResidenceEntity);
    }

    @Transactional
    public void removeResidence(final UserSocietyResidenceView userSocietyResidenceView ) throws Exception {
        final UserEntity user = userRepository.findByUserId(userSocietyResidenceView.getUserId());
        final SocietyEntity society = societyRepository.findBySocietyId(userSocietyResidenceView.getSocietyId());
        final UserSocietyEntity userSociety = userSocietyRepository.findByUserAndSociety(user, society);

        if (userSociety == null) {
            throw new Exception(String.format("Error removing residence details!!. User %s is not a member of %s society",
                    user.getFullName(), society.getSocietyName()));
        }

        final SocietyResidenceEntity societyResidenceEntity = societyResidenceService.
                validateIfResidenceExistInSociety(society, userSocietyResidenceView.getBlockNumber(),
                        userSocietyResidenceView.getResidenceNumber());
        final UserSocietyResidenceEntity userSocietyResidence = userSocietyResidenceRepository.
                findByUserSocietyAndSocietyResidence(userSociety, societyResidenceEntity);
        userSociety.getUserSocietyResidences().remove(userSocietyResidence);
        userSocietyResidenceRepository.delete(userSocietyResidence);
    }
}
