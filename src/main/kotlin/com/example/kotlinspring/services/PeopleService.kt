package com.example.kotlinspring.services

import com.example.kotlinspring.models.Person

import com.example.kotlinspring.repositories.PeopleRepository
import com.example.kotlinspring.util.PersonErrorResponse
import com.example.kotlinspring.util.PersonNotCreatedException
import com.example.kotlinspring.util.PersonNotFoundException

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*


@Service
@Transactional(readOnly = true)
class PeopleService @Autowired constructor(private val peopleRepository: PeopleRepository) {
    fun findAll(): List<Person?> {
        return peopleRepository.findAll()
    }

    fun findOne(id: Int): Person? {
        val foundPerson: Optional<Person?> = peopleRepository.findById(id)
        return foundPerson.orElseThrow(::PersonNotFoundException)
    }

    @Transactional
    fun save(person: Person){
        peopleRepository.save(person)
    }

    @ExceptionHandler
    private fun handleException(e: PersonNotFoundException): ResponseEntity<PersonErrorResponse>{
        val response = PersonErrorResponse(
            "Person with this id wasn't found!",
            System.currentTimeMillis()
        )
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    private fun handleException(e: PersonNotCreatedException): ResponseEntity<PersonErrorResponse>{
        val response = PersonErrorResponse(
            e.message!!,
            System.currentTimeMillis()
        )
        return ResponseEntity(response, HttpStatus.BAD_REQUEST )
    }
}