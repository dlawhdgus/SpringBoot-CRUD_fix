package com.example.crudfix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String loginView() {
        return "loginView";
    }

    @PostMapping(value = "/login")
    public String loginLogic(@RequestParam String id, String password) {
        Map user_info = new HashMap<String, Objects>();

        user_info.put("id", id);
        user_info.put("password", password);

        return null;
    }
}
