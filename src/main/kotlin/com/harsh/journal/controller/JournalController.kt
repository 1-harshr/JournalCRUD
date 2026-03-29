package com.harsh.journal.controller

import com.harsh.journal.models.dto.JournalItemRequestDto
import com.harsh.journal.models.dto.JournalItemResponseDto
import com.harsh.journal.service.JournalService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/journal")
class JournalController(
    private val journalService: JournalService
) {

    @GetMapping("/get-all")
    fun getAllJournalItems(): ResponseEntity<List<JournalItemResponseDto>> {
        return try {
            ResponseEntity.ok(
                journalService.getAll()
            )
        } catch (_: Exception) {
            ResponseEntity.internalServerError().build()
        }
    }

    @GetMapping("/get-journal/{id}")
    fun getJournalItem(@PathVariable("id") id: Int): ResponseEntity<JournalItemResponseDto> {
        return try {
            val res = journalService.get(id) ?: return ResponseEntity.notFound().build()
            return ResponseEntity.ok(res)
        } catch (_ : Exception){
            ResponseEntity.internalServerError().build()
        }
    }

    @PostMapping("/add-journal")
    fun addJournal(@RequestBody journalItem: JournalItemRequestDto): ResponseEntity<Boolean>{
        return try {
            ResponseEntity.ok(
                journalService.save(journalItem)
            )
        } catch (_ : Exception){
            ResponseEntity.internalServerError().build()
        }
    }

    @PutMapping("/update-journal/{id}")
    fun updateJournal(
        @PathVariable("id") id: Int,
        @RequestBody dto: JournalItemRequestDto
    ) : ResponseEntity<Boolean>{
        return ResponseEntity.ok(journalService.update(id, dto))
    }

    @DeleteMapping("/delete-journal/{id}")
    fun deleteJournal(
        @PathVariable("id") id: Int
    ) : ResponseEntity<Boolean> {
        return ResponseEntity.ok(journalService.delete(id))
    }
}
