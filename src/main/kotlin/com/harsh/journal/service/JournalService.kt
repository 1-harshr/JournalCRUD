package com.harsh.journal.service


import com.harsh.journal.exception.JournalNotFoundException
import com.harsh.journal.mappers.toDto
import com.harsh.journal.models.dto.JournalItemRequestDto
import com.harsh.journal.models.dto.JournalItemResponseDto
import com.harsh.journal.models.entity.JournalEntryEntity
import com.harsh.journal.repository.JournalRepository
import org.springframework.stereotype.Service

interface JournalService {
    fun getAll(): List<JournalItemResponseDto>

    fun get(id: Int): JournalItemResponseDto

    fun save(journalItemRequestDto: JournalItemRequestDto): JournalItemResponseDto

    fun delete(id: Int)

    fun update(id: Int, dto: JournalItemRequestDto): JournalItemResponseDto
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

    override fun get(id: Int): JournalItemResponseDto {
        return journalRepository.findById(id).orElseThrow {
            JournalNotFoundException("Journal with id $id not found.")
        }.toDto()
    }

    override fun save(journalItemRequestDto: JournalItemRequestDto): JournalItemResponseDto {
        val savedJournal = journalRepository.save(
            JournalEntryEntity(
                title = journalItemRequestDto.title,
                content = journalItemRequestDto.content,
            )
        )

        return savedJournal.toDto()
    }

    override fun delete(id: Int) {
        val journalEntry = journalRepository.findById(id).orElseThrow{
            JournalNotFoundException("Journal with id $id not found.")
        }
        journalRepository.delete(journalEntry)
    }

    override fun update(id: Int, dto: JournalItemRequestDto): JournalItemResponseDto {
        val entity = journalRepository.findById(id).orElseThrow {
            JournalNotFoundException("Journal with id $id not found.")
        }

        entity.title = dto.title
        entity.content = dto.content
        val updatedEntity = journalRepository.save(entity)

        return updatedEntity.toDto()

    }


}