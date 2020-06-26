package com.marcuschiu.utilsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/my-ip-address-and-port")
    public String myIpAddressAndPort() {
        return "my-ip-address-and-port";
    }

    @GetMapping("/request")
    public String request() {
        return "request";
    }
}