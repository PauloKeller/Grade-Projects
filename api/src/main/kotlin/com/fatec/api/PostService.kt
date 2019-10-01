package com.fatec.api

import org.springframework.http.ResponseEntity
import org.springframework.http.converter.json.MappingJacksonValue
import java.util.*

interface PostService {
    fun findById(id: Long): Post
    fun findAll(): MappingJacksonValue
    fun createPost(post: Post): ResponseEntity<Post>
}