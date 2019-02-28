package com.junky.springboot.handle;


import com.junky.springboot.exception.SBException;
import com.junky.springboot.utils.Result;
import com.junky.springboot.utils.ResultUtil;
import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class ExceptionHandle
 * Effect
 * Created by junky
 * on 2018/12/11
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof SBException) {
            return ResultUtil.error(0, e.getMessage());
        }

        logger.error("【系统异常】{}", e);
        return ResultUtil.error(-1, "未知错误");
    }
}
