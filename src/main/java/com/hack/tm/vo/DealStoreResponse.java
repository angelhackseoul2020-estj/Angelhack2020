package com.hack.tm.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DealStoreResponse {
    private String storeName;
    private String storeImage;
    private String limitTime;

    private int price; //원가
    private int discountRate; //

    private int nowPeopleCnt;
    private int limitPeopleCnt;


}
