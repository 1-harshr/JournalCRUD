package com.harsh.journal.advice

import com.harsh.journal.exception.JournalNotFoundException
import com.harsh.journal.models.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import kotlin.time.Clock
import kotlin.time.ExperimentalTime


@RestControllerAdvice
class GlobalExceptionHandler {

    @OptIn(ExperimentalTime::class)
    @ExceptionHandler(JournalNotFoundException::class)
    fun handleJournalNotFound(ex: JournalNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorResponse(
                status = HttpStatus.NOT_FOUND.value(),
                message = ex.message,
                timestamp = Clock.System.now().toString()
            )
        )
    }
}