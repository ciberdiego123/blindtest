package com.example.blindtest

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<BlindTestAppApplication>().with(TestcontainersConfiguration::class).run(*args)
}
