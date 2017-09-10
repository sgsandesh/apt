package com.aptmnt.model.basic;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sandesh on 9/9/17.
 */

@Entity
@Table(name = "User_apartment",catalog = "my_apartment", uniqueConstraints =
        {@UniqueConstraint(columnNames = "apt_id"),
                @UniqueConstraint(columnNames = "user_id")})
public class UserApartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mapping_id", unique = true, nullable = false)
    private int mappingId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "role_id", nullable = false)
    private int roleId;

    @Column(name = "apt_id", nullable = false)
    private int aptId;

    @Column(name = "house_number", nullable = false)
    private String houseNumber;

    @Column(name = "active", nullable = false)
    private char active;

    @Column(name = "created_timestamp", nullable = false)
    private Date createdTimestamp;

    @Column(name = "created_user", nullable = false)
    private String createdUser;

    @Column(name = "updated_timestamp", nullable = false)
    private Date updatedTimestamp;

    @Column(name = "updated_user", nullable = false)
    private String updatedUser;

}
