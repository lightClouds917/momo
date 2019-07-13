package com.java4all;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangzhongxiang
 * @date 2019年07月13日 17:12:39
 */
@RestController
public class TestController {


    @GetMapping(value = "test")
    public String test(String name){
        return name;
    }
}
