package com.junky.springboot.utils;

/**
 * Class ResultUtil
 * Effect
 * Created by junky
 * on 2018/12/11
 */
public class ResultUtil {

    public static Result success(Object object){

        Result result = new Result();
        result.setCode(1);
        result.setMsg("请求成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){

        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
