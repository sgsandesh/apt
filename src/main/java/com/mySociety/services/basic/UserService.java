package com.mySociety.services.basic;

import com.mySociety.model.orm.basic.SocietyEntity;
import com.mySociety.model.orm.basic.SocietyResidenceEntity;
import com.mySociety.model.orm.basic.UserEntity;
import com.mySociety.model.orm.basic.UserSocietyResidenceEntity;
import com.mySociety.model.view.basic.*;
import com.mySociety.repository.basic.UserRepository;
import com.mySociety.services.basic.helpers.UserEntityViewMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by sandesh on 10/9/17.
 */
@Component
public class UserService {

    private final UserRepository userRepository;
    private final UserEntityViewMapper userEntityViewMapper;

    public UserService(final UserRepository userRepository, final UserEntityViewMapper userEntityViewMapper) {
        this.userRepository = userRepository;
        this.userEntityViewMapper = userEntityViewMapper;
    }

    @Transactional
    public void registerUser(final UserRegisterView userRegisterView) throws Exception {
        validateRegisterUser(userRegisterView);
        UserEntity userEntity =  new UserEntity();
        userEntity.setEmail(userRegisterView.getEmail());
        userEntity.setPassword(userRegisterView.getPassword());
        userEntity.setFullName(userRegisterView.getFullName());
        userEntity.setPhoneNumber(userRegisterView.getPhoneNumber());
        userEntity.setHidePhoneNumber(userRegisterView.getHidePhoneNumber());
        userEntity.setHideEmail(userRegisterView.getHideEmail());
        userEntity.setCreatedTimestamp(new Date());
        userEntity.setUpdatedTimestamp(new Date());
        userEntity.setActive("Y");
        userRepository.save(userEntity);
    }


    public List<DisplayUserBasic> getAllBasicUserDetails() {
        return userEntityViewMapper.mapUserBasicDetails(userRepository.findAll());
    }

    public DisplayUserBasic getBasicUserDetails(final Integer userId) {
        return userEntityViewMapper.mapUserBasicDetails(userRepository.findByUserId(userId));
    }


    private void validateRegisterUser(final UserRegisterView userRegister) throws Exception {
        if(userRepository.findByEmail(userRegister.getEmail()) != null){
            throw new Exception(String.format("email id %s already exists", userRegister.getEmail()));
        }
    }

    public DisplayUser getUserExpandedDetails(final Integer userId) {
        DisplayUser userExpandedView = new DisplayUser();
        final UserEntity userEntity = userRepository.findByUserId(userId);
        userExpandedView.setFullName(userEntity.getFullName());
        userExpandedView.setEmail(userEntity.getEmail());
        userExpandedView.setPhoneNumber(userEntity.getPhoneNumber());
        userExpandedView.setUserId(userEntity.getUserId());

        userEntity.getUserSocietyMappings().forEach(userSocietyEntity -> {
            DisplayUserSociety userSocietyView = new DisplayUserSociety();

            final SocietyEntity societyEntity = userSocietyEntity.getSociety();


            userSocietyView.setSocietyName(societyEntity.getSocietyName());
            userSocietyView.setCity(societyEntity.getCity());
            userSocietyView.setActive(societyEntity.getActive());
            userSocietyView.setRole(userSocietyEntity.getRole());

            
            final Set<UserSocietyResidenceEntity> userSocietyResidences = userSocietyEntity.getUserSocietyResidences();
            userSocietyResidences.forEach(userSocietyResidenceEntity -> {
                DisplayResidence residenceView = new DisplayResidence();

                residenceView.setResidentType(userSocietyResidenceEntity.getResidentType());

                final SocietyResidenceEntity societyResidenceEntity = userSocietyResidenceEntity.getSocietyResidence();
                residenceView.setIntercom(societyResidenceEntity.getIntercom());
                residenceView.setBlockNumber(societyResidenceEntity.getBlockNumber() == null ?
                        " " : societyResidenceEntity.getBlockNumber());
                residenceView.setResidenceNumber(societyResidenceEntity.getResidenceNumber());
                userSocietyView.getDisplayResidences().add(residenceView);

            });
            userExpandedView.getUserSocieties().add(userSocietyView);
        });
        return userExpandedView;

    }
}
