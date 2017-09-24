package com.mySociety.resources;

import com.mySociety.model.orm.basic.UserEntity;
import com.mySociety.model.view.basic.UserSocietyResidenceView;
import com.mySociety.services.basic.UserSocietyService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sandesh on 10/9/17.
 */
@RestController
@RequestMapping("/user-society")
public class UserSocietyResource {

    private final UserSocietyService userSocietyService;

    public UserSocietyResource(UserSocietyService userSocietyService) {
        this.userSocietyService = userSocietyService;
    }


    @RequestMapping(value = "admin/add", method = RequestMethod.POST)
    public void addToSociety(@RequestBody final UserSocietyResidenceView userSocietyResidenceView) throws Exception {
        userSocietyService.addMap(userSocietyResidenceView);
    }

    @RequestMapping(value = "resident/remove/{userId}/{societyId}", method = RequestMethod.DELETE)
    public void removeFromSociety(@PathVariable final Integer userId, @PathVariable final Integer societyId) throws Exception {
         userSocietyService.deleteMap(userId, societyId);
    }

    @RequestMapping(value = "resident/request-join", method = RequestMethod.POST)
    public void requestToJoinSociety(@RequestBody final UserSocietyResidenceView userSocietyResidenceView) throws Exception {

        //TO DO - implement staging workflow
//        userSocietyService.addMap(userId, societyId, role);
    }

    @RequestMapping(value = "admin/role/update/{userId}/{societyId}/{role}", method = RequestMethod.POST)
    public void updateRole(@PathVariable final Integer userId, @PathVariable final Integer societyId, @PathVariable final String role) throws Exception {
        userSocietyService.updateRole(userId, societyId, role);
    }


    @RequestMapping(value = "resident/get/{userId}", method = RequestMethod.GET)
    public UserEntity getAllUserSocietyMappings(@PathVariable final Integer userId) throws Exception {
        return userSocietyService.getMaps(userId);
    }
}
