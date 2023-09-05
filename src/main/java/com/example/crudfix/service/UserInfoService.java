package com.example.crudfix.service;

import com.example.crudfix.domain.dto.LoginDto;
import com.example.crudfix.domain.entity.UserInfo;
import com.example.crudfix.repository.UserInfoRepository;
import com.example.crudfix.util.Crypto;
import com.example.crudfix.util.NullChk;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserInfoService {

    private final UserInfoRepository repository;
    private String emptyPassword;

    public UserInfoService(UserInfoRepository repository, @Value("${empty_password}") String emptyPassword) {
        this.repository = repository;
        this.emptyPassword = emptyPassword;
    }

    public String UserRegLogic(UserInfo userInfo) {
        try {
            if(!ChkDuplicateId(userInfo.getId())) {
                if((NullChk.isEmpty(userInfo.getId())) || (NullChk.isEmpty(userInfo.getNickname())) || (userInfo.getPassword().equals(emptyPassword))) {
                    if (NullChk.isEmpty(userInfo.getId())) {
                        return "아이디를 입력해 주세요";
                    } else if (NullChk.isEmpty(userInfo.getNickname())){
                        return "닉네임을 입력해 주세요";
                    } else {
                        System.out.println("a");
                        if(userInfo.getPassword().equals(emptyPassword)) {
                            return "비밀번호를 입력해 주세요";
                        } else {
                            return "성공";
                        }
                    }
                } else {
                    return "성공";
                }
            } else {
                return "아이디 중복";
            }
        } catch (Exception e) {
            return "서버오류";
        }
    }

    public UserInfo RegResult(UserInfo userInfo) {
        return repository.save(userInfo);
    }

    public boolean ChkDuplicateId(String id) {
        try {
            return repository.existsById(id);
        } catch (Exception e) {
            return false;
        }
    }

    public String LoginLogic(LoginDto loginDto) {

        Optional<UserInfo> result = repository.findById(loginDto.getId());

        if(result.isPresent()) {
            boolean ChkPassword = Crypto.PasswordMatch(loginDto.getPassword(), result.get().getPassword());

            if(ChkPassword) {
                return "성공";
            } else {
                return "비밀번호를 잘못 입력하셨습니다";
            }
        } else {
            return "아이디를 잘못 입력하셨습니다";
        }
    }

}