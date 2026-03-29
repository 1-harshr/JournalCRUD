package com.harsh.journal.models.dto

data class ErrorResponse(
    val message: String,
    val status: Int,
    val timestamp: String
)
