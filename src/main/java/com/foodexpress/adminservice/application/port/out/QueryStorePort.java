package com.foodexpress.adminservice.application.port.out;

import com.foodexpress.adminservice.adapter.out.service.StoreSearchCondition;
import com.foodexpress.adminservice.domain.Store;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryStorePort {

    List<Store> findAllByStoreSearchQuery(StoreSearchCondition storeSearchCondition, Pageable pageable);

}
