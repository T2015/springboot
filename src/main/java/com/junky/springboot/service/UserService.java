package com.junky.springboot.service;

import com.junky.springboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class UserService
 * Effect
 * Created by junky
 * on 2018/12/11
 */


public interface UserService {


    int insterUser(User user);

    int deleteUserByUid(String uid);

    int deleteUserByAccount(String account);

    int updateUser(User user);

    List<User> selectUserList(int pageNo,int pageSize);

    User selectUserByUid(String uid);

    User selectUserByAccount(String account);
}
