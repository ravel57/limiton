package ru.ravel.limiton.model

import java.util.UUID


data class Room (
	val id: UUID = UUID.randomUUID(),
	val timers: MutableList<Timer> = emptyList<Timer>().toMutableList(),
)