package com.mySociety.services.basic;

import com.mySociety.model.orm.basic.SocietyEntity;
import com.mySociety.model.orm.basic.UserEntity;
import com.mySociety.model.view.basic.UserBasicView;
import com.mySociety.model.view.basic.UserExpandedView;
import com.mySociety.model.view.basic.UserRegisterView;
import com.mySociety.model.view.basic.UserSocietyView;
import com.mySociety.repository.basic.UserRepository;
import com.mySociety.services.basic.helpers.UserEntityViewMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
        userEntity.setActive('Y');
        userRepository.save(userEntity);
    }


    public List<UserBasicView> getAllBasicUserDetails() {
        return userEntityViewMapper.mapUserBasicDetails(userRepository.findAll());
    }

    public UserBasicView getBasicUserDetails(final Integer userId) {
        return userEntityViewMapper.mapUserBasicDetails(userRepository.findByUserId(userId));
    }


    private void validateRegisterUser(final UserRegisterView userRegister) throws Exception {
        if(userRepository.findByEmail(userRegister.getEmail()) != null){
            throw new Exception(String.format("email id %s already exists", userRegister.getEmail()));
        }
    }

    public UserExpandedView getUserExpandedDetails(final Integer userId) {
        UserExpandedView userExpandedView = new UserExpandedView();
        final UserEntity userEntity = userRepository.findByUserId(userId);
        userExpandedView.setFullName(userEntity.getFullName());
        userExpandedView.setEmail(userEntity.getEmail());
        userExpandedView.setPhoneNumber(userEntity.getPhoneNumber());
        userExpandedView.setUserId(userEntity.getUserId());

        userEntity.getUserSocietyMappings().forEach(userSocietyEntity -> {
            UserSocietyView userSocietyView = new UserSocietyView();

            final SocietyEntity societyEntity = userSocietyEntity.getSociety();
            userSocietyView.setSocietyName(societyEntity.getSocietyName());
            userSocietyView.setCountry(societyEntity.getCountry());
            userSocietyView.setState(societyEntity.getState());
            userSocietyView.setCity(societyEntity.getCity());
            userSocietyView.setActive(societyEntity.getActive());
            userSocietyView.setIntercom(userSocietyEntity.getIntercom());
            userExpandedView.getSocieties().add(userSocietyView);
        });

        return userExpandedView;

    }
}
