package com.harsh.journal.models.dto

data class JournalItemResponseDto(
    val id: Int,
    val title: String,
    val content: String?,
)
