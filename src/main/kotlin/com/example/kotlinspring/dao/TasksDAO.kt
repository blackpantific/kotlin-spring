package com.example.kotlinspring.dao

import com.example.kotlinspring.models.Person
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class TasksDAO constructor(
    @Autowired
    private val sessionFactory: SessionFactory
) {

    @Transactional(readOnly = true)
    fun index(): List<Person> {//getAllTasks

        val session: Session = sessionFactory.currentSession

        return session.createQuery("select p from Person p", Person::class.java)
            .resultList
//        return jdbcTemplate.query("SELECT * FROM person", PersonMapper())
    }

    fun save(person: Person) {
//        jdbcTemplate.update(
//            "INSERT INTO person VALUES(1, ?, ?, ?)",
//            person.name,
//            person.age,
//            person.email
//        )
    }

    fun update(id: Int, updatePerson: Person) {
//        jdbcTemplate.update(
//            "UPDATE person SET name=?, age=?, email=? WHERE id=?",
//            updatePerson.name,
//            updatePerson.age,
//            updatePerson.email,
//            id
//        )
    }

    fun delete(id: Int){
//        jdbcTemplate.update("DELETE FROM person WHERE id=?", id)
    }
}