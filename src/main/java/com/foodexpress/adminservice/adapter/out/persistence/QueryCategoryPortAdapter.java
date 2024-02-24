package com.foodexpress.adminservice.adapter.out.persistence;

import com.foodexpress.adminservice.application.port.out.QueryCategoryPort;
import com.foodexpress.adminservice.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

/**
 * 검색을 위한 포트 아답터
 *
 * @author seunggu.lee
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class QueryCategoryPortAdapter implements QueryCategoryPort {

    private final CategoryRepository categoryRepository;

    @Override
    public boolean existsByCategoryName(String categoryName) {
        return categoryRepository.existsByCategoryName(categoryName);
    }

}
