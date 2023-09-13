package com.example.crudfix.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Getter
@AllArgsConstructor
public class AlertDto {

    private String message;                // 유저에게 전달할 메세지
    private String redirectUri;            // 리다이렉트 URI
    private RequestMethod method;          // Http Method
    private Map<String, Object> data;      // View로 전달할 Data

}