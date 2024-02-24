package com.foodexpress.adminservice.application.port.in;

import com.foodexpress.adminservice.domain.Store;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchStoreUseCase {

    List<Store> searchStoreList(StoreSearchQuery storeSearchQuery, Pageable pageable);

}
