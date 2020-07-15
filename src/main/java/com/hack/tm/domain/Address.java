package com.hack.tm.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    @Id
    @Column(name = "ADDR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String zonecode;
    private String addressEnglish;
    private String bname;
    private String sido;
    private String sigungu;
    private String sigungucode;
    private String buildName;
    private String hname;
    private String roadName;
    private String jibunAddress;
    private String detailAddress;
}
