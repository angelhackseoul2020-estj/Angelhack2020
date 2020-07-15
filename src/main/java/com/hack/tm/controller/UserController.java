package com.hack.tm.controller;

import com.hack.tm.domain.Address;
import com.hack.tm.domain.User;
import com.hack.tm.service.UserService;
import com.hack.tm.vo.DaumMapAddrParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;


    @GetMapping("/{id}/addr")
    @ApiOperation(value = "사용자 주소정보 조회", tags = "users")
    public ResponseEntity<Address> getAddress(@PathVariable long id) throws Exception {

        User user = userService.findByUser(id);
        Address addr = userService.getUserAddress(user);

        return new ResponseEntity<>(addr, HttpStatus.OK);
    }

    @PostMapping("/{id}/addr")
    @ApiOperation(value = "사용자 주소정보 입력", tags = "users")
    public ResponseEntity<Address> insertAddress(@PathVariable long id, @RequestBody DaumMapAddrParam param) throws Exception {


        Address addr = userService.insertUserAddress(id, param);

        return new ResponseEntity<>(addr, HttpStatus.OK);
    }


}
