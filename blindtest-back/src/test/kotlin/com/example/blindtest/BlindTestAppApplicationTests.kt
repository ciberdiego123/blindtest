package com.example.blindtest

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(TestcontainersConfiguration::class)
@SpringBootTest
class BlindTestAppApplicationTests {

	@Test
	fun contextLoads() {
	}

}
