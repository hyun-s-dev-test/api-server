package com.hyuns.server.controller

import com.hyuns.server.domain.user.UserRepository
import com.hyuns.server.domain.user.User
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import springfox.documentation.service.MediaTypes

@Api(description = "유저 관리 API")
@RestController
@RequestMapping("/api/user")
class UserController (
    val userRepository: UserRepository
){

    @ApiOperation("유저 조회 API")
    @ApiResponses(
        ApiResponse(code = 201, message = "조회완료"),
        ApiResponse(code = 400, message = "요청 똑바로 해라"),
        ApiResponse(code = 500, message = "서버가 맛탱이 갔음")
    )
    @GetMapping()
    fun getUsers(): ResponseEntity<*> {
        val users = userRepository.findAll()

        return ResponseEntity.ok(users)
    }

    @ApiOperation("유저 추가 API")
    @ApiResponses(
        ApiResponse(code = 201, message = "조회완료"),
        ApiResponse(code = 400, message = "요청 똑바로 해라"),
        ApiResponse(code = 500, message = "서버가 맛탱이 갔음")
    )
    @PostMapping()
    fun setUser(@RequestBody user: User): ResponseEntity<*> {
        val res = userRepository.save(user)

        return ResponseEntity.ok(res)
    }
}