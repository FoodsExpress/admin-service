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
    @Column(name = "isActive")
    private boolean active;

    public static CategoryEntity mapToEntity(Category category) {
        CategoryEntity entity = new CategoryEntity();
        entity.categoryId = UUID.randomUUID().toString();
        entity.categoryName = category.categoryName();
        entity.active = category.active();
        return entity;
    }

    public Category mapToDomain() {
        return Category.builder()
            .categoryId(CategoryId.of(categoryId))
            .categoryName(categoryName)
            .active(active)
            .createdBy(createdBy)
            .createdDate(createdDate)
            .updatedBy(updatedBy)
            .updatedDate(updatedDate)
            .build();
    }

    public void sync(Category category) {
        this.categoryName = category.categoryName();
        this.active = category.active();
    }

}
