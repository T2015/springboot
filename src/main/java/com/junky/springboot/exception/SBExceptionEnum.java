package com.junky.springboot.exception;

/**
 * Class SBExceptionEnum
 * Effect
 * Created by junky
 * on 2018/12/11
 */
public enum SBExceptionEnum {

    UNKNOW_ERROR("未知错误"),
    PARA_ERROR("参数错误"),
    SQL_ERROR("数据库错误"),
    SQL_EXITE("数据已存在");

    private String msg;

    SBExceptionEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}
