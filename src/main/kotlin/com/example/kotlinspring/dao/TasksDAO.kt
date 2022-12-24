package com.example.kotlinspring.dao

import com.example.kotlinspring.models.Task
import org.springframework.stereotype.Component
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException

@Component
class TasksDAO {
    companion object{
        private const val URL: String = "jdbc:postgresql://localhost:5432/postgres"
        private const val USERNAME: String = "postgres"
        private const val PASSWORD: String = "postgres"
        private lateinit var connection: Connection
    }

    init {

        try{
            Class.forName("org.postgresql.Driver")
        }catch (ex: ClassNotFoundException){
            ex.printStackTrace()
        }

        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)
        }
        catch (ex: SQLException){
            ex.printStackTrace()
        }
    }

    fun index(): List<Task>{//getAll

        var statement = connection.createStatement()
        var SQL = "SELECT * FROM Person"
        var resultSet: ResultSet = statement.executeQuery(SQL)
        return emptyList()
    }
}