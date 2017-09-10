package com.aptmnt.recources;

import com.aptmnt.model.basic.User;
import com.aptmnt.services.basic.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping(method = RequestMethod.GET)
    List<User> getUsers(){
       return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"})
    public User createUser(@RequestBody User user) throws Exception {
        return userService.createUser(user);
    }
}
