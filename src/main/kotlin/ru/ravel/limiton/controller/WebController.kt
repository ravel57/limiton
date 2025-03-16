package ru.ravel.limiton.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID

@Controller("")
class WebController {

	@GetMapping("/")
	fun main(): String {
		return "index"
	}

	@GetMapping("/r/{uuid}")
	fun mainWithUuid(
		@PathVariable uuid: UUID
	): String {
		return "index"
	}

}