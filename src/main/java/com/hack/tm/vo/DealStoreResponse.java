package com.hack.tm.vo;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DealStoreResponse {
    private Long id;
    private String storeName;
    private String storeImage;
    private String productImage;
    private LocalDateTime limitTime;

    private int price; //원가
    private Float discountRate; //

    private int nowPeopleCnt;
    private int limitPeopleCnt;


}
