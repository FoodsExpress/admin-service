package com.foodexpress.adminservice.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.foodexpress.adminservice.application.port.in.RegisterCategoryCommand;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@EqualsAndHashCode
public class RegisterCategoryRequest {

    private String categoryName;

    @JsonProperty("isUse")
    private boolean use;

    public RegisterCategoryCommand mapToCommand() {
        return RegisterCategoryCommand.of(categoryName, use);
    }

}
