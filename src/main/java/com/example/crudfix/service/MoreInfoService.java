package com.example.crudfix.service;

import com.example.crudfix.domain.entity.MoreInfo;
import com.example.crudfix.repository.MoreInfoRepository;
import com.example.crudfix.util.NullChk;
import org.springframework.stereotype.Service;

@Service
public class MoreInfoService {

    private MoreInfoRepository repository;

    public MoreInfoService(MoreInfoRepository repository) {
        this.repository = repository;
    }

    public String UserRegLogic(MoreInfo moreInfo) {
        try {
            if(NullChk.isEmpty(moreInfo.getPhone_number())) {
                return "성공";
            } else {
                boolean regex = moreInfo.getPhone_number().matches("\\d{2,3}\\d{3,4}\\d{4}$");
                if(regex) {
                    String replace_Phone_num = moreInfo.getPhone_number().replaceAll("(\\d{2,3})(\\d{3,4})(\\d{4})", "$1-$2-$3");
                    moreInfo.setPhone_number(replace_Phone_num);
                    return "성공";
                } else {
                    return "전화번호 형식을 맞춰주세요";
                }
            }
        } catch (Exception e) {
            return e.toString();
        }
    }

    public MoreInfo RegResult(MoreInfo moreInfo) {
        return repository.save(moreInfo);
    }


}
