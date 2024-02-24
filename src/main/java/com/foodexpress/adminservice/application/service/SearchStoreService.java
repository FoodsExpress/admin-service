package com.foodexpress.adminservice.application.service;

import com.foodexpress.adminservice.application.port.in.SearchStoreUseCase;
import com.foodexpress.adminservice.application.port.in.StoreSearchQuery;
import com.foodexpress.adminservice.application.port.out.QueryStorePort;
import com.foodexpress.adminservice.common.UseCase;
import com.foodexpress.adminservice.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class SearchStoreService implements SearchStoreUseCase {

    private final QueryStorePort queryStorePort;

    @Override
    public List<Store> searchStoreList(StoreSearchQuery storeSearchQuery, Pageable pageable) {
        return queryStorePort.findAllByStoreSearchQuery(storeSearchQuery.convertCondition(), pageable);
    }

}
