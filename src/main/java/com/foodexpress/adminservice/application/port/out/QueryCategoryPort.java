package com.foodexpress.adminservice.application.port.out;

/**
 * 검색용 포트
 *
 * @author seunggu.lees
 */
public interface QueryCategoryPort {

    /**
     * 카테고리 명이 이미 존재하는지 확인
     *
     * @param categoryName 카테고리명
     * @return 존재 여부
     */
    boolean existsByCategoryName(String categoryName);

}
