package com.aptmnt.recources;

import com.aptmnt.model.basic.User;
import com.aptmnt.services.basic.UserApartmentService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sandesh on 10/9/17.
 */
@RestController
@RequestMapping("/rest/user-apartment")
public class UserApartmentResource {

    private final UserApartmentService userApartmentService;

    public UserApartmentResource(UserApartmentService userApartmentService) {
        this.userApartmentService = userApartmentService;
    }


    @RequestMapping(value = "create/{userId}/{apartmentName}/{role}", method = RequestMethod.POST)
    public User createMapToApartment(@PathVariable final Integer userId, @PathVariable final String aptName, @PathVariable final String role) throws Exception {
        return userApartmentService.createMap(userId, aptName, role);
    }

    @RequestMapping(value = "update/{userId}/{apartmentName}/{role}", method = RequestMethod.POST)
    public User UpdateRole(@PathVariable final Integer userId, @PathVariable final String aptName, @PathVariable final String role) throws Exception {
        return userApartmentService.updateRole(userId, aptName, role);
    }

    @RequestMapping(value = "delete/{userId}/{apartmentName}", method = RequestMethod.DELETE)
    public User DeleteMapToApartment(@PathVariable final Integer userId, @PathVariable final String aptName) throws Exception {
        return userApartmentService.deleteMap(userId, aptName);
    }

    @RequestMapping(value = "retrieve/{userId}", method = RequestMethod.GET)
    public User DeleteMapToApartment(@PathVariable final Integer userId) throws Exception {
        return userApartmentService.getMaps(userId);
    }

}
