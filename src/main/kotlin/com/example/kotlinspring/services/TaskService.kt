package com.example.kotlinspring.services

import com.example.kotlinspring.models.Task
import com.example.kotlinspring.repositories.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class TaskService @Autowired constructor(private val taskRepository: TaskRepository) {
    fun findAll(): List<Task?> {
        return taskRepository.findAll()
    }

    fun findOne(id: Int): Task? {
        val foundPerson: Optional<Task?> = taskRepository.findById(id)
        return foundPerson.orElse(null)
    }
}