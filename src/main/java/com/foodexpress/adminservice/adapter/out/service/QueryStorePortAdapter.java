package com.foodexpress.adminservice.adapter.out.service;

import com.foodexpress.adminservice.application.port.out.QueryStorePort;
import com.foodexpress.adminservice.common.ServiceAdapter;
import com.foodexpress.adminservice.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

@ServiceAdapter
@RequiredArgsConstructor
public class QueryStorePortAdapter implements QueryStorePort {

    private final StoreClient storeClient;

    @Override
    public List<Store> findAllByStoreSearchQuery(StoreSearchCondition storeSearchCondition, Pageable pageable) {
        return storeClient.getStoreList(storeSearchCondition, pageable);
    }

}
