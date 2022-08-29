package com.lck_manager.api.lck_manger_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test.do")
    public String[] test() {

        return new String[]{"test", "spring boot test"};
    }

}
