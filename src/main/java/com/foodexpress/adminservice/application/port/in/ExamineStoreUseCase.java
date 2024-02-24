package com.foodexpress.adminservice.application.port.in;

import com.foodexpress.adminservice.domain.Store;

public interface ExamineStoreUseCase {

    Store examineStore(ExamineStoreCommand command);
    
}
