package com.example.crudfix.controller;

import com.example.crudfix.domain.entity.MoreInfo;
import com.example.crudfix.domain.entity.UserInfo;
import com.example.crudfix.service.MoreInfoService;
import com.example.crudfix.service.UserInfoService;
import com.example.crudfix.util.Crypto;
import com.example.crudfix.util.NullChk;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class RegisterController {

    Date date = new Date();

    private Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

    private final UserInfoService userInfoService;
    private final MoreInfoService moreInfoService;

    public RegisterController(UserInfoService userInfoService, MoreInfoService moreInfoService) {
        this.userInfoService = userInfoService;
        this.moreInfoService = moreInfoService;
    }


    @GetMapping(value = "reg")
    public String regView() {
        return "registerView";
    }

    @PostMapping(value = "reg")
    public String regLogic(@RequestParam String id, String nickname, String password,
                           String email, String phone_number,
                           String address_number,
                           String roadAddress,
                           String jibunAddress,
                           String detailAddress,
                           String extraAddress) {

        String addressNumber = NullChk.isEmpty(address_number) ? "" : address_number;
        String RoadAddress = NullChk.isEmpty(roadAddress) ? "" : roadAddress;
        String JibunAddress = NullChk.isEmpty(jibunAddress) ? "" : jibunAddress;
        String DetailAddress = NullChk.isEmpty(detailAddress) ? "" : detailAddress;
        String ExtraAddress = NullChk.isEmpty(extraAddress) ? "" : extraAddress;

        String address = addressNumber + RoadAddress + JibunAddress + DetailAddress + ExtraAddress;

        UserInfo userInfo = new UserInfo();
        MoreInfo moreInfo = new MoreInfo();

        userInfo.setId(id);
        userInfo.setNickname(nickname);
        userInfo.setPassword(Crypto.encode(password));
        userInfo.setReg_date(date.toString());
        userInfo.setFlag('u');

        moreInfo.setId(id);
        moreInfo.setEmail(email);
        moreInfo.setPhone_number(phone_number);
        moreInfo.setAddress(address);
        moreInfo.setUpt_date(date.toString());

        String signUp = userInfoService.UserRegLogic(userInfo);
        String MoreInfoSignUp = moreInfoService.UserRegLogic(moreInfo);

        if (signUp == "성공") {
            if (MoreInfoSignUp == "성공") {
                userInfoService.RegResult(userInfo);
                moreInfoService.RegResult(moreInfo);

                return "loginView";
            } else {
                LOGGER.error("{}", MoreInfoSignUp);
                return "registerView";
            }
        } else {
            LOGGER.error("{}", signUp);
            return "registerView";
        }
    }
}
