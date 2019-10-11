package com.market.sapphires.sbt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/portal")
public class PortalController {

    @GetMapping(value = { "", "/" })
    public String index(Model model) {
        return "portal";
    }

}
