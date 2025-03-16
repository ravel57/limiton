package ru.ravel.limiton.service

import org.springframework.stereotype.Service
import ru.ravel.limiton.dto.NewTimerData
import ru.ravel.limiton.model.Room
import ru.ravel.limiton.model.Timer
import java.util.UUID


@Service
class RoomService(
	val rooms: MutableList<Room>
) {

	fun newRoom(): UUID {
		val roomId = UUID.randomUUID()
		rooms.add(Room(id = roomId))
		return roomId
	}


	fun getTimersByRoomId(roomId: UUID): List<Timer> {
		return rooms.find { it.id == roomId }?.timers ?: emptyList()
	}


	fun addTimerToRoom(roomId: UUID, timer: Timer) {
		rooms.find { it.id == roomId }?.timers?.add(timer)
	}


	fun removeTimerFromRoom(roomId: UUID, timerId: Int) {
		val timers = rooms.find { it.id == roomId }?.timers
		val timer = timers?.find { it.id == timerId }
		timers?.remove(timer)
	}

	fun updateTimerData(roomId: UUID, timerId: Int, newMinuets: NewTimerData) {
		val timers = rooms.find { it.id == roomId }?.timers
		val timer = timers?.find { it.id == timerId }
		if (timer != null) {
			if (newMinuets.minutes != null) {
				timer.minutes = newMinuets.minutes
			} else if (newMinuets.name != null) {
				timer.name = newMinuets.name
			}
		}
	}

}