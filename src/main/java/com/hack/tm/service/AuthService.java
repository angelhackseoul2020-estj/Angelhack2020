package com.hack.tm.service;

import com.hack.tm.domain.User;
import com.hack.tm.vo.KakaoLoginParam;

public interface AuthService {
    User updateUserInfo(KakaoLoginParam kakaoLoginParam);
}
