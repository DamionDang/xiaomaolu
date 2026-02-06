package com.xiaoheizi.controller

import com.xiaoheizi.dto.ContactFormDto
import com.xiaoheizi.model.ContactForm
import com.xiaoheizi.repository.ContactFormRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = ["http://localhost:3000"])
class ContactController(
    @Autowired private val contactFormRepository: ContactFormRepository
) {

    @PostMapping
    fun submitContact(@Valid @RequestBody contactFormDto: ContactFormDto): ResponseEntity<Any> {
        try {
            val contactForm = ContactForm(
                name = contactFormDto.name,
                game = contactFormDto.game,
                contact = contactFormDto.contact,
                message = contactFormDto.message
            )
            
            val savedContact = contactFormRepository.save(contactForm)
            
            return ResponseEntity.ok(mapOf(
                "success" to true,
                "message" to "留言提交成功！",
                "data" to mapOf(
                    "id" to savedContact.id,
                    "submittedAt" to savedContact.createdAt
                )
            ))
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(mapOf(
                    "success" to false,
                    "message" to "提交失败，请稍后重试"
                ))
        }
    }

    @GetMapping
    fun getAllContacts(): ResponseEntity<List<ContactForm>> {
        val contacts = contactFormRepository.findAll()
        return ResponseEntity.ok(contacts)
    }
}