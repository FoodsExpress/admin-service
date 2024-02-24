package com.foodexpress.adminservice.adapter.in.web;

import com.foodexpress.adminservice.domain.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterCategoryResponse {

    private Category category;

    public static RegisterCategoryResponse of(Category category) {
        return new RegisterCategoryResponse(category);
    }

}
