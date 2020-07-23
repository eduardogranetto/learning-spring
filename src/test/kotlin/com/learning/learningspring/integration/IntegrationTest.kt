package com.learning.learningspring.integration

import io.restassured.RestAssured.port
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class IntegrationTest {
	
	@Value("\${local.server.port}")
	var localPort: Int = 0
	
	@BeforeEach
	fun beforeEach(){
		port = localPort
	}

}