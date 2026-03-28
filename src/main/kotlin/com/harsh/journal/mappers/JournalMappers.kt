package com.harsh.journal.mappers

import com.harsh.journal.models.dto.JournalItemDto
import com.harsh.journal.models.entity.JournalEntryEntity

fun JournalEntryEntity.toDto(): JournalItemDto =
    JournalItemDto(
        id = id,
        title = title,
        content = content
    )