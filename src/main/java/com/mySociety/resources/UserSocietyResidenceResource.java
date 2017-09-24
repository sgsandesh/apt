package com.mySociety.resources;

import com.mySociety.model.orm.basic.UserEntity;
import com.mySociety.model.view.basic.UserRegisterView;
import com.mySociety.model.view.basic.UserSocietyResidenceView;
import com.mySociety.services.basic.UserSocietyResidenceService;
import com.mySociety.services.basic.UserSocietyService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sandesh on 10/9/17.
 */
@RestController
@RequestMapping("/user-society-residence")
public class UserSocietyResidenceResource {

    private final UserSocietyResidenceService userSocietyResidenceService;

    public UserSocietyResidenceResource(UserSocietyResidenceService userSocietyResidenceService) {
        this.userSocietyResidenceService = userSocietyResidenceService;
    }

    @RequestMapping(value = "admin/add", method = RequestMethod.POST)
    public void addResidenceToUserSociety(@RequestBody UserSocietyResidenceView userSocietyResidenceView) throws Exception {
        userSocietyResidenceService.addResidence(userSocietyResidenceView);
    }

    @RequestMapping(value = "resident/add", method = RequestMethod.POST)
    public void requestToAddResidenceToUserSociety(@RequestBody UserSocietyResidenceView userSocietyResidenceView) throws Exception {
//        userSocietyResidenceService.addResidence(userSocietyResidenceView);
        //TODO workflow
    }


    @RequestMapping(value = "resident/remove", method = RequestMethod.POST)
    public void removeResidenceFromUserSociety(@RequestBody UserSocietyResidenceView userSocietyResidenceView) throws Exception {
        userSocietyResidenceService.removeResidence(userSocietyResidenceView);
    }

}
