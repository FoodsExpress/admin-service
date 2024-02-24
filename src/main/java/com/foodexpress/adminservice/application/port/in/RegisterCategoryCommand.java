package com.foodexpress.adminservice.application.port.in;

import com.foodexpress.adminservice.domain.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterCategoryCommand {

    private String categoryName;

    private boolean use;

    public static RegisterCategoryCommand of(String categoryName, boolean use) {
        return new RegisterCategoryCommand(categoryName, use);
    }

    public Category mapToDomain() {
        return Category.builder()
            .categoryName(categoryName)
            .use(use)
            .build();
    }

    public String getName() {
        return this.categoryName;
    }

}
