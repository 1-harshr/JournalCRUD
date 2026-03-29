package com.harsh.journal.models.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class JournalItemRequestDto(
    @field:NotBlank(message = "Title must not be blank")
    @field:Size(max = 100, message = "Title must be at most 100 characters")
    val title: String,

    @field:Size(max = 5000, message = "Content must be at most 5000 characters")
    val content: String?
)
