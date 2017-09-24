package com.mySociety.services.basic.helpers;

import com.mySociety.model.orm.basic.UserEntity;
import com.mySociety.model.view.basic.UserBasicView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by sandesh on 17/9/17.
 */

@Component
public class UserEntityViewMapper {
    public List<UserBasicView> mapUserBasicDetails(final List<UserEntity> userEntities) {

        List<UserBasicView> userBasicViews = new ArrayList<>();
        userEntities.forEach(userEntity -> {
            userBasicViews.add( mapUserBasicDetails(userEntity));
        });

        return userBasicViews;
    }

    public UserBasicView mapUserBasicDetails(UserEntity userEntity) {
        UserBasicView userBasicView = new UserBasicView();
        if(Objects.isNull(userEntity)){
            userBasicView.getErrors().add("User not found!!");
        }
        userBasicView.setPhoneNumber('Y' == userEntity.getHidePhoneNumber() ?
                "HIDDEN" : userEntity.getPhoneNumber());
        userBasicView.setEmail('Y' == userEntity.getHideEmail() ?
                "HIDDEN" : userEntity.getEmail());

        userBasicView.setFullName(userEntity.getFullName());
        userBasicView.setUserId(userEntity.getUserId());
        return userBasicView;
    }

}
