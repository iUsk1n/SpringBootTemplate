package com.market.sapphires.sbt.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.market.sapphires.sbt.util.MessageUtil;

@Controller
@RequestMapping(value = "/portal")
public class PortalController {

    @Autowired
    MessageSource messageSource;

    @PostConstruct
    public void init() {
        MessageUtil.setMessageSource(this.messageSource);
    }

    @GetMapping(value = { "", "/" })
    public String index(Model model) {
        return "portal";
    }

}
