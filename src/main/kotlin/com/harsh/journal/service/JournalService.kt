package com.harsh.journal.service


import com.harsh.journal.models.dto.JournalItemDto
import com.harsh.journal.repository.JournalRepository
import org.springframework.stereotype.Service

interface JournalService {
    fun getAll(): List<JournalItemDto>

    fun get(id: Int): JournalItemDto?

    fun save(journalItemDto: JournalItemDto): Boolean
}

@Service
class JournalServiceImpl constructor(

): JournalService {
    private var all = mutableListOf<JournalItemDto>()

    override fun getAll(): List<JournalItemDto> {
        return all
    }

    override fun get(id: Int): JournalItemDto? {
        return all.find { it.id == id }
    }

    override fun save(journalItemDto: JournalItemDto): Boolean {
        try {
            all.add(journalItemDto)
            return true
        }
        catch (_: Exception) {
            return false
        }
    }


}