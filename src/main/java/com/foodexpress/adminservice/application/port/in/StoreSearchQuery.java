package com.foodexpress.adminservice.application.port.in;

import com.foodexpress.adminservice.adapter.out.service.StoreSearchCondition;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class StoreSearchQuery {

    private String storeName;

    private String bizNo;

    private boolean use;

    public StoreSearchCondition convertCondition() {
        StoreSearchCondition condition = new StoreSearchCondition();
        copyProperties(condition, this);
        return condition;
    }

}
