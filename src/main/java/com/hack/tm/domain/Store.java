package com.hack.tm.domain;

import java.time.LocalTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Table(name = "store")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 상호명
    private String introducation; //가게 소개
    private String imageUrl; //가게 이미지 url

    private LocalTime openTime; //가게 오픈시간
    private LocalTime closeTime; // 마감시간

    @Column(length = 45)
    private String number;


    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


//    @OneToMany(mappedBy = "store")
//    private List<HotDeal> hotDeal;

    @OneToMany(mappedBy = "store")
    private List<Product> products;


}
