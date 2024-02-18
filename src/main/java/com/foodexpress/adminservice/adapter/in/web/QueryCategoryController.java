package com.foodexpress.adminservice.adapter.in.web;

import com.foodexpress.adminservice.application.port.in.SearchStoreUseCase;
import com.foodexpress.adminservice.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class QueryCategoryController {

    private final SearchStoreUseCase searchStoreUseCase;

    public List<Store> getStoreList(StoreSearchRequest storeSearchRequest, Pageable pageable) {
        return searchStoreUseCase.searchStoreList(storeSearchRequest.convertQuery(), pageable);
    }

}
