package com.example.crudfix.controller;

import com.example.crudfix.config.JwtConfiguration;
import com.example.crudfix.domain.dto.LoginDto;
import com.example.crudfix.service.UserInfoService;
import com.example.crudfix.util.JwtBuilder;
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
    private JwtConfiguration jwtConfig;

    public LoginController(UserInfoService userInfoService, JwtConfiguration jwtConfig) {
        this.userInfoService = userInfoService;
        this.jwtConfig = jwtConfig;
    }

    @GetMapping(value = "/login")
    public String loginView() {
        return "loginView";
    }

    @PostMapping(value = "/login")
    public String loginLogic(@ModelAttribute LoginDto loginDto) {
        JwtBuilder jwtBuilder = new JwtBuilder(jwtConfig);
        String LoginChk = userInfoService.LoginLogic(loginDto);

        if(LoginChk == "성공") {
            System.out.println(jwtBuilder.Build(loginDto.getId()));
            return "../static/index";
        } else {
            LOGGER.error("{}", LoginChk);
            return "loginView";
        }
    }
}
