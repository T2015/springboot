package com.junky.springboot.controller;

import com.junky.springboot.entity.User;
import com.junky.springboot.service.UserService;
import com.junky.springboot.utils.Result;
import com.junky.springboot.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Class UserController
 * Effect
 * Created by junky
 * on 2018/12/11
 */


@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/register.do")
    public Result register(@Valid User user){

        userService.insterUser(user);

        return ResultUtil.success(user);
    }

    @RequestMapping("/login.do")
    public Result login(@Valid User user){


        return ResultUtil.success("login");
    }



}
