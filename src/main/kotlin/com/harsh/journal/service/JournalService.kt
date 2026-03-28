package com.harsh.journal.service


import com.harsh.journal.mappers.toDto
import com.harsh.journal.models.dto.JournalItemDto
import com.harsh.journal.models.entity.JournalEntryEntity
import com.harsh.journal.repository.JournalRepository
import org.springframework.stereotype.Service

interface JournalService {
    fun getAll(): List<JournalItemDto>

    fun get(id: Int): JournalItemDto?

    fun save(journalItemDto: JournalItemDto): Boolean
}

@Service
class JournalServiceImpl constructor(
    private val journalRepository: JournalRepository
): JournalService {

    override fun getAll(): List<JournalItemDto> {
        return journalRepository.findAll().map {
            it.toDto()
        }
    }

    override fun get(id: Int): JournalItemDto? {
        return journalRepository.findById(id).orElse(null)?.toDto()
    }

    override fun save(journalItemDto: JournalItemDto): Boolean {
        try {
            journalRepository.save(
                JournalEntryEntity(
                    title = journalItemDto.title,
                    content = journalItemDto.content,
                )
            )
            return true
        }
        catch (_: Exception) {
            return false
        }
    }


}