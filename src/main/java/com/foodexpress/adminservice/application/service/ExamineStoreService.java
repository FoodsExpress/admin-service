package com.foodexpress.adminservice.application.service;

import com.foodexpress.adminservice.application.port.in.ExamineStoreCommand;
import com.foodexpress.adminservice.application.port.in.ExamineStoreUseCase;
import com.foodexpress.adminservice.application.port.out.ExamineStorePort;
import com.foodexpress.adminservice.common.UseCase;
import com.foodexpress.adminservice.domain.Store;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ExamineStoreService implements ExamineStoreUseCase {

    private final ExamineStorePort examineStorePort;

    @Override
    public Store examineStore(ExamineStoreCommand command, String loginUserId, String examineReason) {
        return examineStorePort.examineStore(command.mapToStore(), loginUserId, examineReason);
    }

}
