package com.hyuns.server.domain.user

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

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
    var birth: String = "",

    @Column(name = "socialType")
    var socialType: String = "",

    // createdAt 와 updatedAt 은 전에 공부했던, BaseTimeEntity 같은 클래스를 제작해서 상속받게 해야하는것인가
    // 일단, 코틀린이니까 상속을 어떻게 하는지도 알아봐야겠다.
)
