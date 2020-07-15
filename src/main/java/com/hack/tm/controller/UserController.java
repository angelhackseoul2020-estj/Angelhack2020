package com.hack.tm.controller;

import com.hack.tm.domain.User;
import com.hack.tm.dto.CustomerInfo;
import com.hack.tm.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "로그인", tags = "loginTest")
    public ResponseEntity<User> loginTest(@PathVariable long id) throws Exception {
        User user = userService.retrieveUserInfo(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
