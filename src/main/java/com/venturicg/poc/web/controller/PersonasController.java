package com.venturicg.poc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonasController {

    @GetMapping("/personas")
    public String getPersonasView() {
        return "personas";
    }
}
