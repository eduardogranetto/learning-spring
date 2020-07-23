package com.learning.learningspring.service

import com.learning.learningspring.repository.MovieRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class MovieService(private val movieRepository: MovieRepository) {
	
	fun all() = ResponseEntity.ok(movieRepository.findAll())
	
}