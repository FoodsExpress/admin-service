package com.foodexpress.adminservice.domain;

import lombok.Builder;

@Builder
public record Category(CategoryId categoryId, String categoryName, boolean use) {

}
