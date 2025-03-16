package ru.ravel.limiton.model


data class Timer(
	val id: Int = 1,
	var name: String = "",
	var minutes: Int = 10,
	val progress: Int = 0,
	val isRunning: Boolean = false,
	val remainingSeconds: Int = minutes,
)