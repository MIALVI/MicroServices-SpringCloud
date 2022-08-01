package com.example.pandaapp.controller;

import com.example.pandaapp.service.PandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/panda-service")
public class PandaController {
    @Autowired
    private PandaService pandaService;

    @GetMapping(value = "/test")
    private String testingHelloWorld(){
        return "Panda Service World";
    }

}
