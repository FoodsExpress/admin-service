package com.foodexpress.adminservice.adapter.in.web;

import com.foodexpress.adminservice.domain.Store;
import com.foodexpress.adminservice.domain.StoreStatus;
import com.foodexpress.adminservice.domain.StoreType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StoreResponse {

    private Long id;
    private String storeId;
    private String bizNo;
    private String storeUserId;
    private String franchiseId;
    private StoreType storeType;
    private String storeName;
    private StoreStatus storeStatus;
    private LocalDate startedAt;

    public static StoreResponse mapToResponse(Store store) {
        StoreResponse storeResponse = new StoreResponse();
        storeResponse.id = store.id();
        storeResponse.storeId = store.storeId();
        storeResponse.bizNo = store.bizNo();
        storeResponse.storeUserId = store.storeUserId();
        storeResponse.franchiseId = store.franchiseId();
        storeResponse.storeType = store.storeType();
        storeResponse.storeName = store.storeName();
        storeResponse.storeStatus = store.storeStatus();
        storeResponse.startedAt = store.startedAt();
        return storeResponse;
    }

}
