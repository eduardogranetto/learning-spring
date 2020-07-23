package com.learning.learningspring.integration.getmultidata

import com.learning.learningspring.service.MovieService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/movies")
class MoviesController(private val movieService: MovieService) {
	
	@GetMapping
	fun all() = ResponseEntity.ok(movieService.all())

}