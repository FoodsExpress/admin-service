package com.foodexpress.adminservice.adapter.in.web;

import com.foodexpress.adminservice.application.port.in.RegisterCategoryCommand;
import com.foodexpress.adminservice.application.port.in.RegisterCategoryUseCase;
import com.foodexpress.adminservice.common.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.foodexpress.adminservice.common.util.ApiUtil.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class RegisterCategoryController {

    private final RegisterCategoryUseCase registerCategoryUseCase;

    @PostMapping("/category")
    public ApiUtil.ApiResult<RegisterCategoryResponse> registerCategory(@RequestBody RegisterCategoryRequest request) {
        RegisterCategoryCommand command = request.mapToCommand();
        return success(RegisterCategoryResponse.of(registerCategoryUseCase.registerCategory(command)));
    }

}
