package com.foodexpress.adminservice.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.foodexpress.adminservice.application.port.in.RegisterCategoryCommand;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

/**
 * 카테고리 등록 요청
 *
 * @author seunggu.lee
 */
@Setter
@ToString
@EqualsAndHashCode
public class RegisterCategoryRequest {

    /**
     * 카테고리 명
     */
    private String categoryName;

    /**
     * 사용 여부
     * 자바에서는 자바 빈즈 규약 때문에 boolean 값의 is 를 붙이지 않았지만, 인터페이스에서는 isUse 로 쓰이기 위해 {@link JsonProperty} 에 `isUse` 를 선언
     */
    @JsonProperty("isUse")
    private boolean use;

    public RegisterCategoryCommand mapToCommand() {
        return RegisterCategoryCommand.of(categoryName, use);
    }

}
