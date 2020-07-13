package com.hack.tm.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class SwaggerController {

    @GetMapping(value = "/sample")
    @ApiOperation(value = "Test sample", tags = "sample")
    public ResponseEntity sample(@RequestParam String param) {
        return ResponseEntity.ok(param);
    }
}
