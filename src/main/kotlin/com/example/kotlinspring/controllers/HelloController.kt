package com.example.kotlinspring.controllers

import com.example.kotlinspring.dao.TasksDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController constructor(private var tasksDAO: TasksDAO) {

    @GetMapping("/helloitmo")
    fun hello(): String {

        var res = tasksDAO.index()
        return "hello"
    }
}