package com.aptmnt.services.basic;

import com.aptmnt.model.basic.User;
import com.aptmnt.repository.basic.UserRepository;
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

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(final User user) throws Exception {
        validateCreateUser(user);
        user.setCreatedTimestamp(new Date());
        addAuditDetails(user, 'Y');
        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private void validateCreateUser(User user) throws Exception {
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new Exception(String.format("User email id %s already exists", user.getEmail()));
        }
    }

    private void addAuditDetails(final User user,  final char isActive) {
        user.setUpdatedTimestamp(new Date());
        user.setActive(isActive);
    }
}
