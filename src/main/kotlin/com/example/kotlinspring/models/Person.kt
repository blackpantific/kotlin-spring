package com.example.kotlinspring.models

import javax.persistence.*

@Entity
@Table(name = "person1")
class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    @Column(name = "name")
    var name: String? = null

    @Column(name = "age")
    var age = 0

    constructor() {}
    constructor(name: String?, age: Int) {
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}'
    }
}