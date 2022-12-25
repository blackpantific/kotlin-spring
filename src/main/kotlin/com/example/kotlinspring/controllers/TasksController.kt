package com.example.kotlinspring.controllers

import com.example.kotlinspring.models.Task
import com.example.kotlinspring.services.TaskService
import com.example.kotlinspring.util.TaskNotCreatedException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.lang.StringBuilder

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

    @PostMapping
    fun create(@RequestBody task: Task, bindingResult: BindingResult): ResponseEntity<HttpStatus> {
        if (bindingResult.hasErrors()) {
            val errorMsg = StringBuilder()
            val list = bindingResult.fieldErrors
            for (error in list) {
                errorMsg
                    .append(error.field)
                    .append(" - ")
                    .append(error.defaultMessage)
                    .append(";")
            }

            throw TaskNotCreatedException(errorMsg.toString() )
        }

        taskService.save(task)
        return ResponseEntity.ok(HttpStatus.OK)
    }
}