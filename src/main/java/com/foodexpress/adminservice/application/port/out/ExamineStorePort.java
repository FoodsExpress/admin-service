package com.foodexpress.adminservice.application.port.out;

import com.foodexpress.adminservice.domain.Store;

public interface ExamineStorePort {

    Store examineStore(Store store, String loginUserId, String examineReason);

}
