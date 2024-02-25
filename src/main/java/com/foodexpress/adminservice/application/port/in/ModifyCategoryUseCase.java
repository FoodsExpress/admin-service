package com.foodexpress.adminservice.application.port.in;

import com.foodexpress.adminservice.domain.Category;

public interface ModifyCategoryUseCase {

    Category modifyCategory(ModifyCategoryCommand command);

}
