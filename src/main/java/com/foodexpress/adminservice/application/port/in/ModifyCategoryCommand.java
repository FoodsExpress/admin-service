package com.foodexpress.adminservice.application.port.in;

import com.foodexpress.adminservice.common.SelfValidating;
import com.foodexpress.adminservice.domain.Category;
import com.foodexpress.adminservice.domain.CategoryId;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ModifyCategoryCommand extends SelfValidating<ModifyCategoryCommand> {

    @NotNull(message = "카테고리 식별자는 필수입니다.")
    private String categoryId;

    /**
     * 카테고리 명
     */
    private String categoryName;

    /**
     * 활성 여부
     */
    private boolean active;

    public Category mapToDomain() {
        this.validateSelf();
        return Category.builder()
            .categoryId(CategoryId.of(categoryId))
            .categoryName(categoryName)
            .active(active)
            .build();
    }

}
