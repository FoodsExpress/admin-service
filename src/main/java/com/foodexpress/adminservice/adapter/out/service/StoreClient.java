package com.foodexpress.adminservice.adapter.out.service;

import com.foodexpress.adminservice.domain.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "store-service")
public interface StoreClient {

    @GetMapping("/store")
    List<Store> getStoreList(@RequestParam StoreSearchCondition storeSearchCondition, Pageable pageable);

}
