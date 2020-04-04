package com.ssm.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/4 21:48
 * @description:
 */
@RestController
@RequestMapping(value = "/page")
public class PageController {


    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }
}
