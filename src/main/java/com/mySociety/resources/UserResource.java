package com.mySociety.resources;

import com.mySociety.model.view.basic.UserBasicView;
import com.mySociety.model.view.basic.UserExpandedView;
import com.mySociety.model.view.basic.UserRegisterView;
import com.mySociety.services.basic.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sandesh on 10/9/17.
 */
@RestController
@RequestMapping("/rest/user")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "secure/basic/all", method = RequestMethod.GET)
    List<UserBasicView> getUserBasicDetails(){
       return userService.getAllBasicUserDetails();
    }

    @RequestMapping(value = "default/register", method = RequestMethod.POST, consumes = {"application/json"})
    public void registerUser(@RequestBody UserRegisterView userRegister) throws Exception {
         userService.registerUser(userRegister);
    }

    @RequestMapping(value = "secure/basic/{userId}", method = RequestMethod.GET)
    UserBasicView getUserBasicDetails(@PathVariable final Integer userId){
        return userService.getBasicUserDetails(userId);
    }

    @RequestMapping(value = "secure/{userId}", method = RequestMethod.GET)
    UserExpandedView getUserExpandedDetails(@PathVariable final Integer userId){
        return userService.getUserExpandedDetails(userId);
    }


}
