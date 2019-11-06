package com.yao.jqr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ShiroController {

    @GetMapping("/to_login")
    public Map toLogin() {
        Map data = new HashMap();
        data.put("success", "false");
        data.put("code", 401);
        data.put("msg", "请登录!");
        return data;
    }

}
