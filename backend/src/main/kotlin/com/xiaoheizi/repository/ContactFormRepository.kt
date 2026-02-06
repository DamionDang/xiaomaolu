package com.xiaoheizi.repository

import com.xiaoheizi.model.ContactForm
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactFormRepository : JpaRepository<ContactForm, Long> {
    // 可以添加自定义查询方法
}