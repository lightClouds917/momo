package com.java4all.momo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author IT云清
 */
@RestController
public class TestController {


    @GetMapping(value = "test")
    public String test(String name){
        return name;
    }
}
