package com.harsh.journal.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/health-check")
class HealthCheckController {

    @GetMapping
    fun healthCheck() : ResponseEntity<Boolean> {
        return ResponseEntity.ok(true)
    }
}