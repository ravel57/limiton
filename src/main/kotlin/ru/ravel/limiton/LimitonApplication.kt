package ru.ravel.limiton

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LimitonApplication

fun main(args: Array<String>) {
	runApplication<LimitonApplication>(*args)
}
