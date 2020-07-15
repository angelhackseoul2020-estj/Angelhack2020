package com.hack.tm.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainController {


    @GetMapping(path = "/hello")
    @ApiOperation(value = "Test sample", tags = "sample")
    public ResponseEntity serviceCheck(@RequestParam("id") String id) throws Exception {
        return ResponseEntity.ok(id);
    }



}
