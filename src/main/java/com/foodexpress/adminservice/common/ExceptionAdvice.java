package com.foodexpress.adminservice.common;

import com.foodexpress.adminservice.common.exceptions.CategoryAlreadyExistException;
import com.foodexpress.adminservice.common.util.ApiUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.foodexpress.adminservice.common.util.ApiUtil.fail;
import static org.springframework.http.HttpStatus.BAD_GATEWAY;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiUtil.ApiResult<Void> defaultException(Exception e) {
        return fail(e, BAD_REQUEST);
    }

    @ExceptionHandler(CategoryAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiUtil.ApiResult<?> categoryAlreadyExists(CategoryAlreadyExistException e) {
        return fail(e, BAD_GATEWAY);
    }

}
