package com.hyuns.server.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.service.MediaTypes

@Api(description = "유저 관리 API")
@RestController
@RequestMapping("/api/user")
class UserController {

    @ApiOperation("유저 조회 API")
    @ApiResponses(
        ApiResponse(code = 201, message = "조회완료"),
        ApiResponse(code = 400, message = "요청 똑바로 해라"),
        ApiResponse(code = 500, message = "서버가 맛탱이 갔음")
    )
    @GetMapping("", "/all")
    fun getAllUser() : List<User> = listOf(
        User("Youngwoo", 26),
        User("Yeonjin", 24),
    )
}

data class User(val name: String?, val age: Int?)