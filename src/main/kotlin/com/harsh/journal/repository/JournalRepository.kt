package com.harsh.journal.repository

import com.harsh.journal.models.entity.JournalEntryEntity
import org.springframework.data.jpa.repository.JpaRepository



interface JournalRepository : JpaRepository<JournalEntryEntity, Int> {

}