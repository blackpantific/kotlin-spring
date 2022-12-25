package com.example.kotlinspring.repositories

import com.example.kotlinspring.models.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : JpaRepository<Task?, Int?>