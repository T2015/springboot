package com.junky.springboot.exception;


/**
 * Class SBException
 * Effect
 * Created by junky
 * on 2018/12/11
 */
public class SBException extends RuntimeException {

    public SBException(SBExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
    }
}
