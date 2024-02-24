package com.foodexpress.adminservice.adapter.in.web;

import com.foodexpress.adminservice.application.port.in.SearchStoreUseCase;
import com.foodexpress.adminservice.common.util.ApiUtil;
import com.foodexpress.adminservice.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.foodexpress.adminservice.common.util.ApiUtil.success;

/**
 * 상점 검색용 컨트롤러
 * store-service 에 원하는 상점에 대해 검색한다.
 *
 * @author seunggu.lee
 */
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class QueryStoreController {

    private final SearchStoreUseCase searchStoreUseCase;

    /**
     * 상점을 승인하기 위해 조회하는 메서드
     *
     * @param storeSearchRequest 상점 조회용 요청부
     * @param pageable           페이징 처리 요청부
     * @return List<Store>
     */
    @GetMapping("/store")
    public ApiUtil.ApiResult<List<StoreResponse>> getStoreList(StoreSearchRequest storeSearchRequest, Pageable pageable) {
        List<Store> stores = searchStoreUseCase.searchStoreList(storeSearchRequest.convertQuery(), pageable);
        return success(stores.stream().map(StoreResponse::mapToResponse).collect(Collectors.toList()));
    }

}
