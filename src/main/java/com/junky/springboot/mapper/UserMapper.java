package com.junky.springboot.mapper;

import com.junky.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Class UserMapper
 * Effect
 * Created by junky
 * on 2018/12/11
 */
public interface UserMapper {

    @Insert("insert into user (uid,account,user_name,male,device_token) " +
            "value (#{uid},#{account},#{userName},#{male},#{deviceToken})")
    int insertUser(User user);

    @Delete("delete from user where uid=#{uid}")
    int deleteUserByUid(String uid);


    @Delete("delete from user where uid=#{account}")
    int deleteUserByAccount(String account);


    @Update("update user set account=#{account},user_name=#{userName}," +
            "male=#{male},device_token=#{deviceToken} where uid=#{uid}")
    int updateUser(User user);


    @Select("select * from user where uid=#{uid}")
    @Results({
            @Result(column = "uid", property = "uid"),
            @Result(column = "account", property = "account"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "male", property = "male"),
            @Result(column = "device_token", property = "deviceToken")
    })
    User selectUserByUid(String uid);


    @Select("select * from user where account=#{account}")
    @Results({
            @Result(column = "uid", property = "uid"),
            @Result(column = "account", property = "account"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "male", property = "male"),
            @Result(column = "device_token", property = "deviceToken")
    })
    User selectUserByAccount(String account);


    @Select("select * from user limit #{pageNo},#{pageSize}")
    @Results({
            @Result(column = "uid", property = "uid"),
            @Result(column = "account", property = "account"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "male", property = "male"),
            @Result(column = "device_token", property = "deviceToken")
    })
    List<User> seletUserList(@Param("pageNo") int pageNo,
                             @Param("pageSize") int pageSize);


}
