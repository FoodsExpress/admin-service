package com.foodexpress.adminservice.adapter.in.web;

import com.foodexpress.adminservice.application.port.in.ExamineStoreCommand;
import com.foodexpress.adminservice.domain.StoreStatus;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * <p>상점 심사 요청</p>
 * <p>상점의 적합 부적합을 판단한 뒤, 승인 혹은 거절을 할 수 있다.</p>
 * 심사에 대한 내용을 {@link ExamineStoreRequest#examineReason} 에 적어준다.
 *
 * @author seunggu.lee
 */
@Data
public class ExamineStoreRequest {

    /**
     * 상점 식별자
     */
    private String storeId;

    /**
     * 상점 상태
     * 승인 혹은 거절만 가능하다.
     */
    private StoreStatus storeStatus;

    /**
     * <p>심사 내용</p>
     * 승인이더라도 참고해야 할 내용이나 거절했다면 거절에 대한 사유를 작성한다.
     */
    private String examineReason;

    public ExamineStoreCommand mapToCommand() {
        ExamineStoreCommand command = new ExamineStoreCommand();
        copyProperties(this, command);
        return command;
    }

}
