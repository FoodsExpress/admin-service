package com.foodexpress.adminservice.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.foodexpress.adminservice.application.port.in.ModifyCategoryCommand;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class ModifyCategoryRequest {

    /**
     * 카테고리 식별자
     */
    private String categoryId;

    /**
     * 카테고리 명
     */
    private String categoryName;

    /**
     * 활성 여부
     */
    @JsonProperty("isActive")
    private boolean active;

    public ModifyCategoryCommand mapToCommand() {
        ModifyCategoryCommand command = new ModifyCategoryCommand();
        copyProperties(this, command);
        return command;
    }

}
