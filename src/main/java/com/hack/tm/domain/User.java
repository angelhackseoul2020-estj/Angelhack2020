package com.hack.tm.domain;

import com.hack.tm.dto.Authority;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "CUSTOMER_ID")
    private Long id; // kakao
    private String name; // nickname;
    private String profileImage; // 640 * 640
    private String thumbnailImage; // 110 * 110
    private String phoneNumber; //


    @Enumerated(value = EnumType.STRING)
    private Authority authority;

}
