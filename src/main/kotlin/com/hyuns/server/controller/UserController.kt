package com.hyuns.server.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class ApiController {

    @GetMapping("", "/all")
    fun getAllUser() : List<User> = listOf(
        User("Youngwoo", 26),
        User("Yeonjin", 24),
    )

}

data class User(val name: String?, val age: Int?)