package com.foodexpress.adminservice.common.exceptions;

public class CategoryAlreadyExistException extends RuntimeException {

    public CategoryAlreadyExistException() {
        super("이미 존재하는 카테고리명 입니다.");
    }

}
