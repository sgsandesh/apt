package com.mySociety.services.basic.helpers;

import com.mySociety.model.orm.basic.UserEntity;
import com.mySociety.model.view.basic.DisplayUserBasic;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by sandesh on 17/9/17.
 */

@Component
public class UserEntityViewMapper {
    public List<DisplayUserBasic> mapUserBasicDetails(final List<UserEntity> userEntities) {

        List<DisplayUserBasic> userBasicViews = new ArrayList<>();
        userEntities.forEach(userEntity -> {
            userBasicViews.add( mapUserBasicDetails(userEntity));
        });

        return userBasicViews;
    }

    public DisplayUserBasic mapUserBasicDetails(UserEntity userEntity) {
        DisplayUserBasic userBasicView = new DisplayUserBasic();
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
