package com.foodexpress.adminservice.adapter.in.web;

import com.foodexpress.adminservice.application.port.in.ModifyCategoryUseCase;
import com.foodexpress.adminservice.common.util.ApiUtil;
import com.foodexpress.adminservice.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.foodexpress.adminservice.common.util.ApiUtil.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/category")
public class ModifyCategoryController {

    private final ModifyCategoryUseCase modifyCategoryUseCase;

    @PatchMapping
    public ApiUtil.ApiResult<ModifyCategoryResponse> modifyCategory(@RequestBody ModifyCategoryRequest request) {
        Category category = modifyCategoryUseCase.modifyCategory(request.mapToCommand());
        return success(ModifyCategoryResponse.mapToResponse(category));
    }

}
