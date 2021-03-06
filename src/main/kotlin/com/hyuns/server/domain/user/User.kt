package com.hyuns.server.domain.user

import com.hyuns.server.dto.ReadUserDTO
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "User")
data class User(
    @Id
    @Column(name="pk")
    var pk: Int = 0,

    @Column(name="name")
    var name: String = "",

    @Column(name = "id")
    var id: String = "",

    @Column(name = "password")
    var password: String = "",

    @Column(name = "gender")
    var gender: Char = ' ',

    @Column(name = "birth")
    var birth: LocalDate? = null,

    @Column(name = "socialType")
    var socialType: String = "",

    @Column(name = "token")
    var token: String,

    @Column(name = "createdAt")
    var createdAt: LocalDateTime? = null,

    @Column(name = "updatedAt")
    var updatedAt: LocalDateTime? = null,

    // createdAt 와 updatedAt 은 전에 공부했던, BaseTimeEntity 같은 클래스를 제작해서 상속받게 해야하는것인가
    // 일단, 코틀린이니까 상속을 어떻게 하는지도 알아봐야겠다.
) {
    fun toReadUserDto(): ReadUserDTO {
        return ReadUserDTO(
            pk = pk,
            name = name,
            id = id,
            gender = gender,
            birth = birth,
            socialType = socialType,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }
}
