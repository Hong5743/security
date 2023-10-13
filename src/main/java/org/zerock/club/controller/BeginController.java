package org.zerock.club.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BeginController {

    @GetMapping("/")
    public String getMain(){
        return "redirect:/sample/all";
    }
}
