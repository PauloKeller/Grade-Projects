package com.fatec.api

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.*



@Entity
data class Post(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
        @Size(max = 300, message = "Body should has only 300 characters") val body: String,
        @NotNull @Size(min = 3, max = 10, message = "Title should between 4 and 100 characters") val title: String,
        @NotNull @Positive @Max(value = 5) @Min(value = 0) val rate: Double
)