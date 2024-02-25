package com.foodexpress.adminservice.application.port.in;

import com.foodexpress.adminservice.domain.Store;
import com.foodexpress.adminservice.domain.StoreStatus;
import lombok.Data;

@Data
public class ExamineStoreCommand {

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

    public Store mapToStore() {
        return Store.builder()
            .storeId(storeId)
            .storeStatus(storeStatus)
            .build();
    }

}
