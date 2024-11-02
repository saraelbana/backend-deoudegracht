package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.services.EmployeeService;
import com.deoudegracht.deoudegracht.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
}
