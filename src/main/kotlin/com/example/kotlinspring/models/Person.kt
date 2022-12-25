package com.example.kotlinspring.models

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty

@Entity
@Table(name = "Person1")
class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    var name: String? = null

    @Column(name = "age")
    @Min(value = 0, message = "Age should be greater that zero")
    var age = 0

    @Column(name = "email")
    @Email
    @NotEmpty(message = "Email should be empty")
    var email: String? = null

    constructor() {}
    constructor(name: String?, age: Int) {
        this.name = name
        this.age = age
    }
}