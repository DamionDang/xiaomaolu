package com.xiaoheizi.dto

import jakarta.validation.constraints.NotBlank

data class ContactFormDto(
    @field:NotBlank(message = "姓名不能为空")
    val name: String,

    val game: String? = null,

    @field:NotBlank(message = "联系方式不能为空")
    val contact: String,

    val message: String? = null
)