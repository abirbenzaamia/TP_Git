package com.telly.controllers;

import com.telly.dao.FormValidationGroup;
import com.telly.dao.Reserve;
import com.telly.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

public class UserController {
    @Autowired
    ReserveService reserveService;
    @RequestMapping(value = "/reservebook", method = RequestMethod.POST)
    public String createReserveBook(@Validated(FormValidationGroup.class) Reserve reserve, BindingResult result, Principal principal) {

        if (result.hasErrors()) {
            return "reservebus";
        }

        String username = principal.getName();
        reserve.getUser().setUsername(username);

        reserveService.reserve(reserve);


        return "home";

    }
}
