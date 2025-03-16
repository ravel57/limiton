package ru.ravel.limiton.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.ravel.limiton.dto.NewTimerData
import ru.ravel.limiton.model.Timer
import ru.ravel.limiton.service.RoomService
import java.util.*


@RestController
@RequestMapping("/api/v1")
class ApiController(
	val roomService: RoomService
) {

	@PostMapping("/room")
	fun newRoom(): ResponseEntity<Any> {
		return ResponseEntity.ok().body(roomService.newRoom())
	}


	@GetMapping("/timers/{roomId}")
	fun getTimersByRoomId(
		@PathVariable roomId: UUID,
	): ResponseEntity<Any> {
		return ResponseEntity.ok().body(roomService.getTimersByRoomId(roomId))
	}


	@PostMapping("/timers/{roomId}")
	fun addTimerToRoom(
		@PathVariable roomId: UUID,
		@RequestBody timer: Timer,
	): ResponseEntity<Any> {
		return ResponseEntity.ok().body(roomService.addTimerToRoom(roomId, timer))
	}


	@DeleteMapping("/timers/{roomId}/{timerId}")
	fun removeTimerFromRoom(
		@PathVariable roomId: UUID,
		@PathVariable timerId: Int,
	): ResponseEntity<Any> {
		return ResponseEntity.ok().body(roomService.removeTimerFromRoom(roomId, timerId))
	}


	@PostMapping("/timers/{roomId}/{timerId}")
	fun updateTimerMinuets(
		@PathVariable roomId: UUID,
		@PathVariable timerId: Int,
		@RequestBody newMinuets: NewTimerData,
	): ResponseEntity<Any> {
		return ResponseEntity.ok().body(roomService.updateTimerData(roomId, timerId, newMinuets))
	}

}