package com.fatec.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import org.springframework.http.converter.json.MappingJacksonValue


@Service("postService")
class PostServiceImpl : PostService {
    @Autowired
    lateinit var postRepository: PostRepository

    override fun findById(id: Long): Post {
        val post = postRepository.findById(id)

        if (post.isPresent) {
            return post.get()
        } else {
            throw PostNotFoundException("id-$id")
        }
    }

    override fun findAll(): MappingJacksonValue {
        val posts = postRepository.findAll()
        val filter = SimpleBeanPropertyFilter.filterOutAllExcept("title", "rate")
        val filters = SimpleFilterProvider().addFilter("SomeBeanFilter", filter)
        val mapping = MappingJacksonValue(posts)
        mapping.filters = filters
        return mapping
    }

    override fun createPost(post: Post): ResponseEntity<Post> {
        val savedPost = postRepository.save(post)

        val location = ServletUriComponentsBuilder.fromCurrentRequest().path("/${savedPost.id}").buildAndExpand(savedPost.id).toUri()

        return ResponseEntity.created(location).build<Post>()
    }
}