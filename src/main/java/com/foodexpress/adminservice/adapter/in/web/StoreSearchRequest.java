package com.foodexpress.adminservice.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.foodexpress.adminservice.application.port.in.StoreSearchQuery;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class StoreSearchRequest {

    private String storeName;

    private String bizNo;

    @JsonProperty("isUse")
    private boolean use;

    public StoreSearchQuery convertQuery() {
        StoreSearchQuery storeSearchQuery = new StoreSearchQuery();
        copyProperties(this, storeSearchQuery);
        return storeSearchQuery;
    }

}
