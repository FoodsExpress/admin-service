package com.foodexpress.adminservice.adapter.out.persistence;

import com.foodexpress.adminservice.application.port.out.RegisterCategoryPort;
import com.foodexpress.adminservice.common.PersistenceAdapter;
import com.foodexpress.adminservice.domain.Category;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisterCategoryPortAdapter implements RegisterCategoryPort {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        CategoryEntity entity = CategoryEntity.mapToEntity(category);
        categoryRepository.save(entity);
        return entity.mapToDomain();
    }

}
