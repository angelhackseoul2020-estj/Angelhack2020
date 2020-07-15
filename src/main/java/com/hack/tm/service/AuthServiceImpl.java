package com.hack.tm.service;

import com.hack.tm.domain.User;
import com.hack.tm.dto.Authority;
import com.hack.tm.repository.UserRepository;
import com.hack.tm.vo.KakaoLoginParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;


    @Override
    public User updateUserInfo(KakaoLoginParam kakaoLoginParam) {
        long id = kakaoLoginParam.getId();
        return userRepository.findById(id).orElseGet(() -> userRepository.save(createNewUserAndSave(kakaoLoginParam)));

    }


    private User createNewUserAndSave(KakaoLoginParam param) {
        return User.builder().id(param.getId())
                .authority(Authority.CUSTOMER)
                .name(param.getProperties().getNickname())
                .phoneNumber(param.getKakao_account().getPhone_number())
                .profileImage(param.getProperties().getProfile_image())
                .thumbnailImage(param.getProperties().getThumbnail_image())
                .build();
    }
}
