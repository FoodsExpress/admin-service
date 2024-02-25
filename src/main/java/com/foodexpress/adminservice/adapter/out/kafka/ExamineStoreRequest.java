package com.foodexpress.adminservice.adapter.out.kafka;

import com.foodexpress.adminservice.domain.StoreStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExamineStoreRequest {

    private String storeId;

    private StoreStatus storeStatus;

    private String userId;

    private String examineReason;

    public static ExamineStoreRequest of(String storeId, StoreStatus storeStatus, String loginUserId, String examineReason) {
        return new ExamineStoreRequest(storeId, storeStatus, loginUserId, examineReason);
    }

}
