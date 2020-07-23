package com.learning.learningspring.integration.getmultidata

import com.learning.learningspring.integration.IntegrationTest
import com.learning.learningspring.integration.fixtures.fixtureMovies
import com.learning.learningspring.integration.getmultidata.RestMultiDataTest.RepositoryConfiguration
import io.restassured.RestAssured.`when`
import io.restassured.http.ContentType.JSON
import org.hamcrest.Matchers.hasItems
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [RepositoryConfiguration::class])
class RestMultiDataTest : IntegrationTest() {
	
	@Configuration
	inner class RepositoryConfiguration{
		
		@Bean
		fun movies() = fixtureMovies.map { it.id to it }
		
	}
	
	@Test
	fun `Should return all with success`() {
		`when`()
			.get("/v1/movies")
		.then()
			.statusCode(200)
		.and()
			.contentType(JSON)
			.and()
			.body("$", hasItems(fixtureMovies))
	}
	
}