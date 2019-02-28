package com.junky.springboot.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Class HttpAspect
 * Effect
 * Created by junky
 * on 2018/12/11
 */

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.junky.springboot.controller.*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();


        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null){
            session.setAttribute("user","89757");
            logger.info("不存在session，赋值：" + session.getAttribute("user"));
        }else {
            logger.info("存在session，值为：" + session.getAttribute("user"));
        }

        logger.info("*****************请求开始****************");

        //method
        logger.info("请求url：{}", request.getRequestURL());

        //method
        logger.info("请求方法：{}", request.getMethod());

        //ip
        logger.info("来源IP：{}", request.getRemoteAddr());

        //类方法
        logger.info("调用方法：{}", joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());

        //参数
        logger.info("参数：{}", JSON.toJSON(joinPoint.getArgs()));
    }

    @After("log()")
    public void doAfter() {
        logger.info("-----------------请求结束------------------");
    }


    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("请求结果：{}",JSON.toJSON(object));
    }







}
