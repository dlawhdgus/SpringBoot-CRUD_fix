package com.example.crudfix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "index")
    public String IndexView() {
        return "../static/index";
    }

    @GetMapping(value = "/")
    public String IndexView2() {
        return "../static/index";
    }
}
