package com.foodexpress.adminservice.domain;

import lombok.Builder;

import java.time.LocalDate;

/**
 * 상점 도메인
 *
 * @author seunggu.lee
 */
@Builder
public record Store(Long id, String storeId, String bizNo, String storeUserId, String franchiseId, StoreType storeType, String storeName,
                    StoreStatus storeStatus,
                    LocalDate startedAt) {

}
