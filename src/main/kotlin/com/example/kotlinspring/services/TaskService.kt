package com.example.kotlinspring.services

import com.example.kotlinspring.models.Task
import com.example.kotlinspring.repositories.TaskRepository
import com.example.kotlinspring.util.TaskErrorResponse
import com.example.kotlinspring.util.TaskNotCreatedException
import com.example.kotlinspring.util.TaskNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.ExceptionHandler
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

    @Transactional
    fun save(task: Task): Task {
        return taskRepository.save(task)
    }

    @Transactional
    fun update(taskId: Int, task: Task){
        task.id = taskId
        taskRepository.save(task)
    }

    @Transactional
    fun delete(taskId: Int){
        taskRepository.deleteById(taskId)
    }

    @ExceptionHandler
    private fun handleException(e: TaskNotFoundException): ResponseEntity<TaskErrorResponse> {
        val response = TaskErrorResponse(
            "Task with this id wasn't found!",
            System.currentTimeMillis()
        )
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    private fun handleException(e: TaskNotCreatedException): ResponseEntity<TaskErrorResponse> {
        val response = TaskErrorResponse(
            e.message!!,
            System.currentTimeMillis()
        )
        return ResponseEntity(response, HttpStatus.BAD_REQUEST )
    }
}