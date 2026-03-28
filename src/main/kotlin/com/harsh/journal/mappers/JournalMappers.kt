package com.harsh.journal.mappers

import com.harsh.journal.models.dto.JournalItemRequestDto
import com.harsh.journal.models.dto.JournalItemResponseDto
import com.harsh.journal.models.entity.JournalEntryEntity

fun JournalEntryEntity.toDto(): JournalItemResponseDto =
    JournalItemResponseDto(
        id = id,
        title = title,
        content = content
    )