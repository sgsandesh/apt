package com.mySociety.resources;

import com.mySociety.model.orm.basic.UserEntity;
import com.mySociety.services.basic.UserSocietyService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sandesh on 10/9/17.
 */
@RestController
@RequestMapping("/rest/user-society")
public class UserSocietyResource {

    private final UserSocietyService userSocietyService;

    public UserSocietyResource(UserSocietyService userSocietyService) {
        this.userSocietyService = userSocietyService;
    }


    @RequestMapping(value = "admin/add/{userId}/{societyId}/{role}", method = RequestMethod.POST)
    public void addToSociety(@PathVariable final Integer userId, @PathVariable final Integer societyId,
                                @PathVariable final String role) throws Exception {
        userSocietyService.addMap(userId, societyId, role);
    }

    @RequestMapping(value = "admin/remove/{userId}/{societyName}", method = RequestMethod.DELETE)
    public UserEntity removeMapToSociety(@PathVariable final Integer userId, @PathVariable final String aptName) throws Exception {
        return userSocietyService.deleteMap(userId, aptName);
    }

    @RequestMapping(value = "resident/request-join/{userId}/{societyId}/{role}", method = RequestMethod.POST)
    public void requestToJoinSociety(@PathVariable final Integer userId, @PathVariable final Integer societyId,
                                @PathVariable final String role) throws Exception {

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
