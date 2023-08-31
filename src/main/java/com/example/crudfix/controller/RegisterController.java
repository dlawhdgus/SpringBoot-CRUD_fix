package com.example.crudfix.controller;

import com.example.crudfix.domain.entity.UserInfo;
import com.example.crudfix.service.UserInfoService;
import com.example.crudfix.util.Crypto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class RegisterController {

    Date date = new Date();

    private Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "reg")
    public String regView() {
        return "registerView";
    }

    @PostMapping(value = "reg")
    public String regLogic(@RequestParam String id, String nickname, String password) {

        UserInfo userInfo = new UserInfo();

        userInfo.setId(id);
        userInfo.setNickname(nickname);
        userInfo.setPassword(Crypto.encode(password));
        userInfo.setReg_date(date.toString());
        userInfo.setFlag('u');

        String signUp = userInfoService.UserRegLogic(userInfo);

        if (signUp == "성공") {
            return "loginView";
        } else {
            LOGGER.error("{}", signUp);
            return "registerView";
        }
    }

}
