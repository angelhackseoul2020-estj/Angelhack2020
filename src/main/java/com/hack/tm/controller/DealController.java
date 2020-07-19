package com.hack.tm.controller;


import com.hack.tm.domain.HotDeal;
import com.hack.tm.domain.Product;
import com.hack.tm.domain.Store;
import com.hack.tm.service.DealService;
import com.hack.tm.vo.DealStoreResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(value = "/deal", produces = "application/json; charset=UTF8")
public class DealController {

    private final DealService dealService;


    @GetMapping
    public ResponseEntity<Object> findDealList(@RequestParam("hname") String hname)
        throws Exception { //동 기준 매핑

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        Date now = new Date(System.currentTimeMillis());
//        String dateTime = sdf.format(now);

        List<Store> stores = dealService.findTargetStore(hname);

        List<DealStoreResponse> list = new ArrayList<DealStoreResponse>();

        stores.forEach(store -> {
            List<Product> products = store.getProducts().stream()
                .filter(product -> !product.getHotDeals().isEmpty()) // 핫딜 목록이 있는녀석들만 조회
//                .filter(product -> (product.getHotDeals().stream()
//                    .filter(hotDeal -> hotDeal.getGoalDt().isAfter(LocalDateTime.now())).count()
//                    > 1))
                .collect(Collectors.toList());


            products.forEach(product ->  {
                list.add(DealStoreResponse.builder()
                    .id(product.getId())
                    .storeName(store.getName())
                    .storeImage(store.getImageUrl())
                    .productImage(product.getImage_url())
                    .limitTime(product.getHotDeals().get(0).getGoalDt())
                    .price(product.getPrice())
                    .discountRate(product.getHotDeals().get(0).getDiscountRate())
                    .nowPeopleCnt(product.getHotDeals().get(0).getNowPeopleCnt())
                    .limitPeopleCnt(product.getHotDeals().get(0).getLimitPeopleCnt())
                    .build());

            });

        });

        HashMap<String, Object> map = new HashMap<>();

        map.put("list", list);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
