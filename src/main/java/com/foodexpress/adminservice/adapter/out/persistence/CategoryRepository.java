package com.foodexpress.adminservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    boolean existsByCategoryName(String categoryName);

    Optional<CategoryEntity> findByCategoryId(String categoryId);

}
