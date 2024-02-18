package com.foodexpress.adminservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class CategoryId {

    private String id;

    public static CategoryId of(String id) {
        CategoryId categoryId = new CategoryId();
        categoryId.id = id;
        return categoryId;
    }

}
