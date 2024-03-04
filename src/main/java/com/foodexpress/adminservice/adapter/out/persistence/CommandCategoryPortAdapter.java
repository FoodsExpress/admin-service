package com.foodexpress.adminservice.adapter.out.persistence;

import com.foodexpress.adminservice.application.port.out.ModifyCategoryPort;
import com.foodexpress.adminservice.application.port.out.RegisterCategoryPort;
import com.foodexpress.adminservice.common.PersistenceAdapter;
import com.foodexpress.adminservice.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@PersistenceAdapter
@RequiredArgsConstructor
public class CommandCategoryPortAdapter implements RegisterCategoryPort, ModifyCategoryPort {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        CategoryEntity entity = CategoryEntity.mapToEntity(category);
        categoryRepository.save(entity);
        return entity.mapToDomain();
    }

    @Override
    @Transactional
    public Category modifyCategory(Category category) {
        CategoryEntity entity = categoryRepository.findByCategoryId(category.categoryId().getId()).orElseThrow();
        entity.sync(category);
        return entity.mapToDomain();
    }

}
