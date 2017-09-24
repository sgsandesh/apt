package com.mySociety.utils;


/**
 * Created by sandesh on 17/9/17.
 */
public class Constants {

    public enum Role{
        ADMIN, RESIDENT,MANAGER,GATE_KEEPER
    }

    public enum RESIDENT_TYPE{
        OWNER, TENANT, BUILDER, CARE_TAKER
    }

    public static Role roleLookup(String roleName) {
        for (Role role : Role.values()) {
            if (role.name().equalsIgnoreCase(roleName)) {
                return role;
            }
        }
        return null;
    }

    public static RESIDENT_TYPE residentTypeLookup(String residentTypeName) {
        for (RESIDENT_TYPE residentType : RESIDENT_TYPE.values()) {
            if (residentType.name().equalsIgnoreCase(residentTypeName)) {
                return residentType;
            }
        }
        return null;
    }





}
