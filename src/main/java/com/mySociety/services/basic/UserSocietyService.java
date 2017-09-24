package com.mySociety.services.basic;

import com.mySociety.model.orm.basic.*;
import com.mySociety.model.view.basic.UserSocietyResidenceView;
import com.mySociety.repository.basic.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;

import static com.mySociety.utils.Constants.*;

/**
 * Created by sandesh on 10/9/17.
 */
@Component
public class UserSocietyService {

    private final UserSocietyRepository userSocietyRepository;
    private final SocietyRepository societyRepository;
    private final UserRepository userRepository;
    private final UserSocietyResidenceService userSocietyResidenceService;

    public UserSocietyService(UserSocietyRepository userSocietyRepository,
                              SocietyRepository societyRepository, UserRepository userRepository, UserSocietyResidenceService userSocietyResidenceService) {
        this.userSocietyRepository = userSocietyRepository;
        this.societyRepository = societyRepository;
        this.userRepository = userRepository;
        this.userSocietyResidenceService = userSocietyResidenceService;
    }


    @Transactional
    public void addMap(final UserSocietyResidenceView userSocietyResidenceView) throws Exception {
        final UserSocietyEntity userSocietyEntity = addMap(userSocietyResidenceView.getUserId(),
                userSocietyResidenceView.getSocietyId(), userSocietyResidenceView.getRoleName());

        userSocietyResidenceService.addResidence(userSocietyResidenceView);

    }

    @Transactional
    public void updateRole(Integer userId, Integer societyId, String roleName) throws Exception {
        final UserEntity user = userRepository.findByUserId(userId);
        final SocietyEntity society = societyRepository.findBySocietyId(societyId);
        final UserSocietyEntity userSociety = userSocietyRepository.findByUserAndSociety(user, society);

        if (userSociety == null) {
            throw new Exception(String.format("Error updating role!!. User %s is not a member of %s society", user.getFullName(), society.getSocietyName()));
        }
        validateRole(roleName);
        if (roleName.equalsIgnoreCase(userSociety.getRole()))
            throw new Exception(String.format("%s in already having %s role in %s society",
                    user.getFullName(), roleName, society.getSocietyName()));
        userSociety.setRole(roleName);
    }

    @Transactional
    public void deleteMap(Integer userId, Integer societyId) throws Exception {
        final UserEntity user = userRepository.findByUserId(userId);
        final SocietyEntity society = societyRepository.findBySocietyId(societyId);

        final UserSocietyEntity userSocietyEntity = userSocietyRepository.findByUserAndSociety(user, society);

        if(userSocietyEntity == null){
            throw new Exception("User society not found");
        }
        userSocietyRepository.delete(userSocietyEntity);

    }

    public UserEntity getMaps(Integer userId) {
        return null;
    }

    private void validateRole(String roleName) throws Exception {
        final Role role = roleLookup(roleName);
        if (role == null) {
            throw new Exception(String.format("Role %s not a valid!!  Available roles: %s", roleName, Arrays.toString(Role.values())));
        }
    }

    public UserSocietyEntity addMap(final Integer userId, final Integer societyId,final String roleName) throws Exception {

        final UserEntity user = userRepository.findByUserId(userId);
        final SocietyEntity society = societyRepository.findBySocietyId(societyId);
        if (userSocietyRepository.findByUserAndSociety(user, society) != null) {
            throw new Exception(String.format("user %s is already member of %s society", user.getFullName(), society.getSocietyName()));
        }

        UserSocietyEntity userSociety = new UserSocietyEntity();
        userSociety.setSociety(society);
        userSociety.setUser(user);


        final Role role = roleLookup(roleName);
        if (role == null) {
            throw new Exception(String.format("Role %s not a valid role. Available roles: %s", roleName, Arrays.toString(Role.values())));
        }

        validateRole(roleName);
        userSociety.setRole(roleName);
        userSociety.setActive("Y");
        userSociety.setCreatedUser("TEST USER");
        userSociety.setUpdatedUser("TEST USER");
        userSociety.setCreatedTimestamp(new Date());
        userSociety.setUpdatedTimestamp(new Date());
        return userSocietyRepository.saveAndFlush(userSociety);

    }
}
