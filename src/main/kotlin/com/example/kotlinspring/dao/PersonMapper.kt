package com.example.kotlinspring.dao

import com.example.kotlinspring.models.Person
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class PersonMapper : RowMapper<Person> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Person? {
        return Person(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("age"),
            rs.getString("email")
        )
    }
}