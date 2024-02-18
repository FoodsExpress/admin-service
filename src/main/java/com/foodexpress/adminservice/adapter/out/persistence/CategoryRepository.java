package com.foodexpress.adminservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    boolean existsByCategoryName(String categoryName);

}
