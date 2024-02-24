package com.foodexpress.adminservice.adapter.out.service;

import com.foodexpress.adminservice.application.port.out.QueryStorePort;
import com.foodexpress.adminservice.common.ServiceAdapter;
import com.foodexpress.adminservice.domain.Store;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ServiceAdapter
@RequiredArgsConstructor
public class QueryStorePortAdapter implements QueryStorePort {

    private final StoreClient storeClient;

    @Override
    @Retry(name = "simpleRetryConfig", fallbackMethod = "fallback")
    public List<Store> findAllByStoreSearchQuery(StoreSearchCondition storeSearchCondition, Pageable pageable) {
        return storeClient.getStoreList(storeSearchCondition, pageable);
    }

    private List<Store> fallback(StoreSearchCondition storeSearchCondition, Pageable pageable, Exception ex) {
        log.info("fallback! your request is " + storeSearchCondition);
        log.error(ex.getMessage());
        return new ArrayList<>();
    }

}
