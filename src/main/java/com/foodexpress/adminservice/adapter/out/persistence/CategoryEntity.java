package com.foodexpress.adminservice.adapter.out.persistence;

import com.foodexpress.adminservice.domain.Category;
import com.foodexpress.adminservice.domain.CategoryId;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Entity
@ToString
@Table(name = "category")
@EqualsAndHashCode(callSuper = false)
public class CategoryEntity extends UpdatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 카테고리 식별자
     */
    private String categoryId;

    /**
     * 카테고리 명
     */
    private String categoryName;

    /**
     * 사용 여부
     */
    @Column(name = "isUse")
    private boolean use;

    public static CategoryEntity mapToEntity(Category category) {
        CategoryEntity entity = new CategoryEntity();
        entity.categoryId = UUID.randomUUID().toString();
        entity.categoryName = category.categoryName();
        entity.use = category.use();
        return entity;
    }

    public Category mapToDomain() {
        return Category.builder()
            .categoryId(CategoryId.of(categoryId))
            .categoryName(categoryName)
            .use(use)
            .build();
    }

}
