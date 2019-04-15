package com.ybx.authority.common.exception;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

/**
 * 描述 ：异常统一处理类
 *
 * @author : maozebing
 * @version : v1.00
 * @CreationDate : 2018/3/27 14:22
 * @Description :
 * @update : 修改人，修改时间，修改内容
 * @see :[相关类/方法]
 */
@ControllerAdvice
public class ExceptionAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> errorHandler(Exception ex) {
        logger.error(ex.getMessage());
        if (ex instanceof ParseException) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } else if (ex instanceof NotFoundException) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        } else if (ex instanceof LoginException) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        } else if (ex instanceof HttpMessageConversionException) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
