package com.hyuns.server.controller

import com.hyuns.server.domain.user.UserRepository
import com.hyuns.server.domain.user.User
import com.hyuns.server.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(description = "유저 관리 API")
@RestController
@RequestMapping("/api/user")
class UserController (
    private val userService: UserService
){


    @ApiOperation("유저 전체 조회 API")
    @ApiResponses(
        ApiResponse(code = 200, message = "조회완료"),
        ApiResponse(code = 400, message = "요청 똑바로 해라"),
        ApiResponse(code = 500, message = "서버가 맛탱이 갔음")
    )
    @GetMapping()
    fun getAllUsersInfo(): ResponseEntity<*> {
        val users = userService.getAllUsers()

        return if (users.isEmpty()) ResponseEntity<String>("조회된 결과가 없습니다.", HttpStatus.NO_CONTENT)
        else ResponseEntity.ok(users)
    }


    @ApiOperation("유저 1명 조회 API")
    @ApiResponses(
        ApiResponse(code = 200, message = "조회완료"),
        ApiResponse(code = 400, message = "요청 똑바로 해라"),
        ApiResponse(code = 500, message = "서버가 맛탱이 갔음")
    )
    @GetMapping("/{pk}")
    fun getUserInfoByPk(@PathVariable pk: Int): ResponseEntity<*> {
        val user = userService.getUserByPk(pk)

        return if (user == null) ResponseEntity<String>("조회된 결과가 없습니다.", HttpStatus.NO_CONTENT)
        else ResponseEntity.ok(user)
    }


    @ApiOperation("유저 추가 API")
    @ApiResponses(
        ApiResponse(code = 200, message = "추가완료"),
        ApiResponse(code = 400, message = "요청 똑바로 해라"),
        ApiResponse(code = 500, message = "서버가 맛탱이 갔음")
    )
    @PostMapping()
    fun addUser(@RequestBody user: User): ResponseEntity<*> {
        val res = userService.save(user)

        return ResponseEntity.ok(res)
    }
}