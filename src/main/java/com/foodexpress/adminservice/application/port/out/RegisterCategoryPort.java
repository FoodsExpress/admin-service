package com.foodexpress.adminservice.application.port.out;

import com.foodexpress.adminservice.domain.Category;

public interface RegisterCategoryPort {

    Category saveCategory(Category category);

}
