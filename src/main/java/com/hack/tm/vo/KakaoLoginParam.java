package com.hack.tm.vo;

import lombok.Getter;

@Getter
public class KakaoLoginParam {

    private long id;
    private String connected_at;

    private Properties properties;
    private KakaoAccount kakao_account;


    @Getter
    public class Properties {
        private String nickname;
        private String profile_image;
        private String thumbnail_image;
    }

    @Getter
    public class KakaoAccount {
        private boolean has_email;
        private String email;

        private boolean has_phone_number;
        private String phone_number;

    }
}
