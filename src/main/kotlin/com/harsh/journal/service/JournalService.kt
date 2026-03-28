package com.harsh.journal.service


import com.harsh.journal.mappers.toDto
import com.harsh.journal.models.dto.JournalItemRequestDto
import com.harsh.journal.models.dto.JournalItemResponseDto
import com.harsh.journal.models.entity.JournalEntryEntity
import com.harsh.journal.repository.JournalRepository
import org.springframework.stereotype.Service

interface JournalService {
    fun getAll(): List<JournalItemResponseDto>

    fun get(id: Int): JournalItemResponseDto?

    fun save(journalItemRequestDto: JournalItemRequestDto): Boolean
}

@Service
class JournalServiceImpl constructor(
    private val journalRepository: JournalRepository
): JournalService {

    override fun getAll(): List<JournalItemResponseDto> {
        return journalRepository.findAll().map {
            it.toDto()
        }
    }

    override fun get(id: Int): JournalItemResponseDto? {
        return journalRepository.findById(id).orElse(null)?.toDto()
    }

    override fun save(journalItemRequestDto: JournalItemRequestDto): Boolean {
        try {
            journalRepository.save(
                JournalEntryEntity(
                    title = journalItemRequestDto.title,
                    content = journalItemRequestDto.content,
                )
            )
            return true
        }
        catch (_: Exception) {
            return false
        }
    }


}