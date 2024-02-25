package com.foodexpress.adminservice.application.port.in;

import com.foodexpress.adminservice.domain.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterCategoryCommand {

    private String categoryName;

    private boolean active;

    public static RegisterCategoryCommand of(String categoryName, boolean active) {
        return new RegisterCategoryCommand(categoryName, active);
    }

    public Category mapToDomain() {
        return Category.builder()
            .categoryName(categoryName)
            .active(active)
            .build();
    }

    public String getName() {
        return this.categoryName;
    }

}
