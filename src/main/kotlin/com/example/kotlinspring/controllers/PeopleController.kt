package com.example.kotlinspring.controllers

import com.example.kotlinspring.models.Person
import com.example.kotlinspring.services.PeopleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController // @Controller + @ResponseBody
@RequestMapping("/people")
class PeopleController @Autowired constructor(private val peopleService: PeopleService) {

    @GetMapping
    fun getPeople(): List<Person?>? {
        return peopleService.findAll() // Jackson конвертирует эти объекты в JSON
    }

    @GetMapping("/{id}")
    fun getPerson(@PathVariable("id") id: Int): Person? {
        return peopleService.findOne(id) // Jackson конвертирует в JSON
    }
}