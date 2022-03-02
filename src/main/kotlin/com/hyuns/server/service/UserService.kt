package com.hyuns.server.service

import com.hyuns.server.domain.user.User
import com.hyuns.server.domain.user.UserRepository
import com.hyuns.server.dto.ReadUserDTO
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository)  {

    fun getUserByPk(pk: Int): User { // ReadUserDTO? {
        val user = userRepository.findByPk(pk)

//        return user?.toReadUserDto()
        return user
    }

    fun getAllUsers(): List<User> { //ReadUserDTO> {
        val users = userRepository.findAll()

        return users.map {user -> user}// .toReadUserDto()}
    }

    fun save(user: User): User? {
        return userRepository.save(user)
    }
}