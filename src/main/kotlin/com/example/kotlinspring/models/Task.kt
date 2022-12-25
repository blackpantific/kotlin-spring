package com.example.kotlinspring.models

import jakarta.persistence.*

@Entity
@Table(name = "Tasks")
class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    @Column(name = "title")
    var title: String? = null

    @Column(name = "description")
    var description: String? = null

    constructor() {}
    constructor(title: String?, description: String?) {
        this.title = title
        this.description = description
    }
}
