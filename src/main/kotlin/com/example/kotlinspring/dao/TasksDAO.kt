package com.example.kotlinspring.dao

import com.example.kotlinspring.models.Person
import com.example.kotlinspring.models.Task
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException

@Component
class TasksDAO constructor(
    @Autowired
    private val jdbcTemplate: JdbcTemplate
) {

    fun index(): List<Person> {//getAllTasks

        return jdbcTemplate.query("SELECT * FROM person", PersonMapper())
    }

    fun save(person: Person) {
        jdbcTemplate.update(
            "INSERT INTO person VALUES(1, ?, ?, ?)",
            person.name,
            person.age,
            person.email
        )
    }

    fun update(id: Int, updatePerson: Person) {
        jdbcTemplate.update(
            "UPDATE person SET name=?, age=?, email=? WHERE id=?",
            updatePerson.name,
            updatePerson.age,
            updatePerson.email,
            id
        )
    }

    fun delete(id: Int){
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id)
    }
}