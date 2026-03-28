package com.harsh.journal.controller

import com.harsh.journal.models.dto.JournalItemDto
import com.harsh.journal.service.JournalService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/journal")
class JournalController(
    private val journalService: JournalService
) {

    @GetMapping("/get-all")
    fun getAllJournalItems(): ResponseEntity<List<JournalItemDto>> {
        return try {
            ResponseEntity.ok(
                journalService.getAll()
            )
        } catch (_: Exception) {
            ResponseEntity.internalServerError().build()
        }
    }

    @GetMapping("/get-journal/{id}")
    fun getJournalItem(@PathVariable("id") id: Int): ResponseEntity<JournalItemDto> {
        return try {
            ResponseEntity.ok(
                journalService.get(id)
            )
        } catch (_ : Exception){
            ResponseEntity.internalServerError().build()
        }
    }

    @PostMapping("/add-journal")
    fun addJournal(@RequestBody journalItem: JournalItemDto): ResponseEntity<Boolean>{
        return try {
            ResponseEntity.ok(
                journalService.save(journalItem)
            )
        } catch (_ : Exception){
            ResponseEntity.internalServerError().build()
        }
    }
}
