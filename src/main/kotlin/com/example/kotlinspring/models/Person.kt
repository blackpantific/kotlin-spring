package com.example.kotlinspring.models

import javax.persistence.*

@Entity
@Table(name = "person1")
class Person() {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Int = 0

    @Column(name = "name")
    private lateinit var name: String

    @Column(name = "age")
    private var age: Int = 0

    constructor(name: String, age: Int) : this() {
        this.name = name
        this.age = age
    }
}