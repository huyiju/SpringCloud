package com.thit.dao;

import com.thit.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author :huyiju
 * @date :2020-04-07 15:50
 */
@Repository
public interface UserMapper {

    int add(User u);



}
