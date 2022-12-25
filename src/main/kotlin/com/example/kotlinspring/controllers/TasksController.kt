package com.example.kotlinspring.controllers

import com.example.kotlinspring.models.Task
import com.example.kotlinspring.services.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController//@Controller + @ResponseBody
@RequestMapping("/tasks")
class TasksController @Autowired constructor(private val taskService: TaskService) {

    @GetMapping
    fun getPeople(): List<Task?>? {
        return taskService.findAll() // Jackson конвертирует эти объекты в JSON
    }

    @GetMapping("/sayHello")
    fun sayHello(): String{
        return "Hello world"
    }
}