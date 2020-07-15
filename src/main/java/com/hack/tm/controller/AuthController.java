package com.hack.tm.controller;

import com.hack.tm.domain.User;
import com.hack.tm.service.AuthService;
import com.hack.tm.vo.KakaoLoginParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth", produces = "application/json; charset=UTF8")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    private final AuthService authService;

    @PostMapping("/local")
    @ApiOperation(value = "Kakao Login", tags = "login")
    public ResponseEntity<User> loginTest(@RequestBody KakaoLoginParam kakaoLoginParam) throws Exception {
        User user = authService.updateUserInfo(kakaoLoginParam);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
