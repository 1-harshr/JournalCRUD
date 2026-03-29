package com.harsh.journal.exception

class JournalNotFoundException(
    override val message: String,
) : RuntimeException(message)