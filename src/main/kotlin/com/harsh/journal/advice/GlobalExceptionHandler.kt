package com.harsh.journal.advice

import com.harsh.journal.exception.JournalNotFoundException
import com.harsh.journal.models.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
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

    @OptIn(ExperimentalTime::class)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val message = ex.bindingResult.fieldErrors.firstOrNull()?.defaultMessage
            ?: "Invalid request"

        return ResponseEntity.badRequest().body(
            ErrorResponse(
                message = message,
                status = 400,
                timestamp = Clock.System.now().toString()
            )
        )
    }
}