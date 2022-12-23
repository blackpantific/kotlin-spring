package com.example.kotlinspring.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {

    @GetMapping("/helloitmo")
    fun hello(): String{
        return "hello"
    }
}