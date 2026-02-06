package com.xiaoheizi.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

@Entity
@Table(name = "contact_forms")
data class ContactForm(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank(message = "姓名不能为空")
    @Column(nullable = false)
    val name: String,

    @Column
    val game: String? = null,

    @field:NotBlank(message = "联系方式不能为空")
    @Column(nullable = false)
    val contact: String,

    @Column(length = 1000)
    val message: String? = null,

    @Column(updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)