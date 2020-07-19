package com.hack.tm.domain;


import com.hack.tm.dto.EnumYn;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Table(name = "hot_deal")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class HotDeal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float discountRate;
    private int nowPeopleCnt;
    private int limitPeopleCnt;

    private LocalDateTime goalDt; //목표 시간

    @Enumerated(value = EnumType.STRING)
    private EnumYn is_finish;



    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;



}
