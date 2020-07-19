package com.hack.tm.controller;


import com.hack.tm.domain.Store;
import com.hack.tm.service.DealService;
import com.hack.tm.vo.DealStoreResponse;
import java.util.List;
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
    public ResponseEntity<DealStoreResponse> findDealList(@RequestParam("hname") String hname)
        throws Exception { //동 기준 매핑

        List<Store> stores = dealService.findTargetStore(hname);
/*
        List<DealStoreResponse> responses = stores.stream()
            .filter(store ->
                !store.getProducts().stream()
                    .filter(product -> !product.getHotDeals().isEmpty())
                    .map(product -> DealStoreResponse.builder()
                        .storeName(store.getName())
                        .price(product.getPrice())
//                        .discountRate(product.¬
                        .build())
                    .iterator().hasNext())

            )
    }*/
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
