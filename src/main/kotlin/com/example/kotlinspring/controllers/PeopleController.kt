package com.example.kotlinspring.controllers

import com.example.kotlinspring.models.Person
import com.example.kotlinspring.services.PeopleService
import com.example.kotlinspring.util.PersonNotCreatedException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.StringBuilder

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

    @PostMapping
    fun create(@RequestBody person: Person, bindingResult: BindingResult): ResponseEntity<HttpStatus> {
        if (bindingResult.hasErrors()) {
            val errorMsg = StringBuilder()
            val list = bindingResult.getFieldErrors()
            for (error in list) {
                errorMsg
                    .append(error.field)
                    .append(" - ")
                    .append(error.defaultMessage)
                    .append(";")
            }

            throw PersonNotCreatedException(errorMsg.toString() )
        }

        peopleService.save(person)
        return ResponseEntity.ok(HttpStatus.OK)
    }
}