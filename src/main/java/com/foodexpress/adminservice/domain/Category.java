package com.foodexpress.adminservice.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Category(CategoryId categoryId, String categoryName, boolean active, String createdBy, LocalDateTime createdDate,
                       String updatedBy, LocalDateTime updatedDate) {

}
