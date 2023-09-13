package com.example.crudfix.controller;

import com.example.crudfix.domain.dto.AlertDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ErrorController {

    @PostMapping
    private String ErrorMessage(final AlertDto params, Model model) {
        model.addAttribute("params", params);
        return "ErrorMessage/messageRedirect";
    }


}