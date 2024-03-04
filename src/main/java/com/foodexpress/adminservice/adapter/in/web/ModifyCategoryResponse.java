package com.foodexpress.adminservice.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.foodexpress.adminservice.domain.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ModifyCategoryResponse {

    private String categoryId;

    private String categoryName;

    @JsonProperty("isActive")
    private boolean active;

    public static ModifyCategoryResponse mapToResponse(Category category) {
        return new ModifyCategoryResponse(category.categoryId().getId(), category.categoryName(), category.active());
    }

}
