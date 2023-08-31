package com.example.crudfix.service;

import com.example.crudfix.domain.entity.UserInfo;
import com.example.crudfix.repository.UserInfoRepository;
import com.example.crudfix.util.NullChk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository repository;

    public String UserRegLogic(UserInfo userInfo) {
        try {
            if(!ChkDuplicateId(userInfo.getId())) {
                if((NullChk.isEmpty(userInfo.getId())) || (NullChk.isEmpty(userInfo.getNickname())) || (NullChk.isEmpty(userInfo.getPassword()))) {
                    if (NullChk.isEmpty(userInfo.getId())) {
                        return "아이디를 입력해 주세요";
                    } else if (NullChk.isEmpty(userInfo.getNickname())){
                        return "닉네임을 입력해 주세요";
                    } else {
                        return "비밀번호를 입력해 주세요";
                    }
                } else {
                    repository.save(userInfo);
                    return "성공";
                }
            } else {
                return "아이디 중복";
            }
        } catch (Exception e) {
            return "서버오류";
        }
    }

    public boolean ChkDuplicateId(String id) {
        try {
            return repository.existsById(id);
        } catch (Exception e) {
            return false;
        }
    }



}