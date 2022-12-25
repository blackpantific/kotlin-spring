package com.example.kotlinspring.repositories

import com.example.kotlinspring.models.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PeopleRepository : JpaRepository<Person?, Int?>