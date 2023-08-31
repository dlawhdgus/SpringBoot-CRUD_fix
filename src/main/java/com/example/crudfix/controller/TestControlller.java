package com.example.crudfix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestControlller {


    @ResponseBody
    @PostMapping(value = "/join")
    public String Join(@RequestParam String id, @RequestParam String pw) {

        Map result = new HashMap<String, Object>();
        result.put("id", id);
        result.put("pw", pw);

        String userId = result.get("id").toString();
        System.out.println(userId);
        System.out.println(result.get("pw"));
        return result.toString();
    }
}
