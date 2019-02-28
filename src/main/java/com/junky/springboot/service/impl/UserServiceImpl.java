package com.junky.springboot.service.impl;

import com.junky.springboot.entity.User;
import com.junky.springboot.exception.SBException;
import com.junky.springboot.exception.SBExceptionEnum;
import com.junky.springboot.mapper.UserMapper;
import com.junky.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Class UserServiceImpl
 * Effect
 * Created by junky
 * on 2018/12/11
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int insterUser(User user) {

        if (user.getUid() == null || StringUtils.isEmpty(user.getUid())){
            throw new SBException(SBExceptionEnum.PARA_ERROR);
        }
        if (user.getAccount() == null || StringUtils.isEmpty(user.getAccount())){
            throw new SBException(SBExceptionEnum.PARA_ERROR);
        }

        User resultUser = userMapper.selectUserByAccount(user.getAccount());
        if (resultUser != null){
            throw new SBException(SBExceptionEnum.SQL_EXITE);
        }

        int result = userMapper.insertUser(user);
        if (result != 1){
            throw new SBException(SBExceptionEnum.SQL_ERROR);
        }

        return result;
    }

    @Override
    public int deleteUserByUid(String uid) {



        return 0;
    }

    @Override
    public int deleteUserByAccount(String account) {



        return 0;
    }

    @Override
    public int updateUser(User user) {



        return 0;
    }

    @Override
    public List<User> selectUserList(int pageNo, int pageSize) {



        return null;
    }

    @Override
    public User selectUserByUid(String uid) {



        return null;
    }

    @Override
    public User selectUserByAccount(String account) {



        return null;
    }
}
