package com.example.kotlinspring.models

import jakarta.persistence.*

@Entity
@Table(name = "Person1")
class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    @Column(name = "name")
    var name: String? = null

    @Column(name = "age")
    var age = 0

    @Column(name = "email")
    var email: String? = null

    constructor() {}
    constructor(name: String?, age: Int) {
        this.name = name
        this.age = age
    }
}