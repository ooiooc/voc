package com.project.voc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerRedirector {

    @GetMapping("/api/usage")
    public String api() { return "redirect:/swagger-ui/index.html"; }

}
