package com.foodexpress.adminservice.adapter.in.web;

import com.foodexpress.adminservice.application.port.in.ExamineStoreUseCase;
import com.foodexpress.adminservice.common.security.JwtAuthentication;
import com.foodexpress.adminservice.common.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.foodexpress.adminservice.common.util.ApiUtil.success;

/**
 * 상점 심사 컨트롤러
 * <p>상점의 적합 부적합을 판단한 뒤, 승인 혹은 거절을 할 수 있다.</p>
 *
 * @author seunggu.lee
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/store/examine")
public class ExamineStoreController {

    private final ExamineStoreUseCase examineStoreUseCase;

    @PatchMapping
    public ApiUtil.ApiResult<StoreResponse> examineStore(@RequestBody ExamineStoreRequest examineStoreRequest, @AuthenticationPrincipal
    JwtAuthentication authentication) {
        return success(StoreResponse.mapToResponse(examineStoreUseCase.examineStore(examineStoreRequest.mapToCommand(),
                                                                                    authentication.accountId(),
                                                                                    examineStoreRequest.getExamineReason())));
    }

}
