package com.insurance.app.Insurance.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {

    @GetMapping("insurance")
    public String forward() {
        return "/";
    }
}
