package com.fatec.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest
import java.net.URI
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

@RestController
class PostController {
    @Autowired
    lateinit var postService: PostServiceImpl

    @GetMapping("/posts")
    fun findAllPosts(): MappingJacksonValue {
        return postService.findAll();
    }

    @PostMapping("/posts")
    fun createPost(@Valid @RequestBody body: Post): ResponseEntity<Post> {
        return postService.createPost(body)
    }

    @GetMapping("/posts/{id}")
    fun findById(@PathVariable  id: Long): Post {
        return postService.findById(id)
    }
}