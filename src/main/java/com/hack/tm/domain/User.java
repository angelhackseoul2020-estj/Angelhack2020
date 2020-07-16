package com.hack.tm.domain;

import com.hack.tm.dto.Authority;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "USER_ID")
    private Long id; // kakao

    private String name; // nickname;
    private String profileImage; // 640 * 640
    private String thumbnailImage; // 110 * 110
    private String phoneNumber; //


    @Enumerated(value = EnumType.STRING)
    private Authority authority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDR_ID")
    private Address addr;

    public void updateAddr(Address addr) {
        this.addr = addr;
    }
}

/*
{
   "id":1406673406,
   "connected_at":"2020-07-14T15:00:38Z",
   "properties":{
      "nickname":"기연",
      "profile_image":"http://k.kakaocdn.net/dn/0h1yX/btqEwLKwSZ6/PiveHCIMYldYiD2f8a6kI1/img_640x640.jpg",
      "thumbnail_image":"http://k.kakaocdn.net/dn/0h1yX/btqEwLKwSZ6/PiveHCIMYldYiD2f8a6kI1/img_110x110.jpg"
   },
   "kakao_account":{
      "profile_needs_agreement":false,
      "profile":{
         "nickname":"기연",
         "thumbnail_image_url":"http://k.kakaocdn.net/dn/0h1yX/btqEwLKwSZ6/PiveHCIMYldYiD2f8a6kI1/img_110x110.jpg",
         "profile_image_url":"http://k.kakaocdn.net/dn/0h1yX/btqEwLKwSZ6/PiveHCIMYldYiD2f8a6kI1/img_640x640.jpg"
      },
      "has_email":true,
      "email_needs_agreement":false,
      "is_email_valid":true,
      "is_email_verified":true,
      "email":"clean.code@kakao.com",
      "has_phone_number":true,
      "phone_number_needs_agreement":false,
      "phone_number":"+82 10-9434-7521",
      "has_birthday":true,
      "birthday_needs_agreement":true,
      "has_gender":true,
      "gender_needs_agreement":false,
      "gender":"male",
      "is_kakaotalk_user":true
   }
}
 */