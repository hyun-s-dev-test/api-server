package com.hyuns.server.dto

import java.time.LocalDate
import java.time.LocalDateTime

data class ReadUserDTO (
    val pk: Int,
    val name: String,
    val id: String,
    val birth: LocalDate?,
    val gender: Char,
    val socialType: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
)