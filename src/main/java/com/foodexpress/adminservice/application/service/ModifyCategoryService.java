package com.foodexpress.adminservice.application.service;

import com.foodexpress.adminservice.application.port.in.ModifyCategoryCommand;
import com.foodexpress.adminservice.application.port.in.ModifyCategoryUseCase;
import com.foodexpress.adminservice.application.port.out.ModifyCategoryPort;
import com.foodexpress.adminservice.common.UseCase;
import com.foodexpress.adminservice.domain.Category;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ModifyCategoryService implements ModifyCategoryUseCase {

    private final ModifyCategoryPort modifyCategoryPort;

    @Override
    public Category modifyCategory(ModifyCategoryCommand command) {
        return modifyCategoryPort.modifyCategory(command.mapToDomain());
    }

}
