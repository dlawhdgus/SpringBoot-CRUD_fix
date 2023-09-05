package com.example.crudfix.controller;

import com.example.crudfix.domain.dto.LoginDto;
import com.example.crudfix.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private UserInfoService userInfoService;

    public LoginController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping(value = "/login")
    public String loginView() {
        return "loginView";
    }

    @PostMapping(value = "/login")
    public String loginLogic(@ModelAttribute LoginDto loginDto) {
        String LoginChk = userInfoService.LoginLogic(loginDto);

        if(LoginChk == "성공") {
            return "../static/index";
        } else {
            LOGGER.error("{}", LoginChk);
            return "loginView";
        }
    }
}
