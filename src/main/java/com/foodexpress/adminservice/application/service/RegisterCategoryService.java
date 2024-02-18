package com.foodexpress.adminservice.application.service;

import com.foodexpress.adminservice.application.port.in.RegisterCategoryCommand;
import com.foodexpress.adminservice.application.port.in.RegisterCategoryUseCase;
import com.foodexpress.adminservice.application.port.out.QueryCategoryPort;
import com.foodexpress.adminservice.application.port.out.RegisterCategoryPort;
import com.foodexpress.adminservice.common.UseCase;
import com.foodexpress.adminservice.common.exceptions.CategoryAlreadyExistException;
import com.foodexpress.adminservice.domain.Category;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class RegisterCategoryService implements RegisterCategoryUseCase {

    private final RegisterCategoryPort registerCategoryPort;
    private final QueryCategoryPort queryCategoryPort;

    @Override
    public Category registerCategory(RegisterCategoryCommand registerCategoryCommand) {
        if (queryCategoryPort.existsByCategoryName(registerCategoryCommand.getName())) {
            throw new CategoryAlreadyExistException();
        }
        Category category = registerCategoryCommand.mapToDomain();

        return registerCategoryPort.saveCategory(category);
    }

}
