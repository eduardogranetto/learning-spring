package com.learning.learningspring.repository

import com.learning.learningspring.model.Movie
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class MovieRepository(
	private val movies: Map<UUID, Movie>
){
	
	fun findAll() = movies.values
	
}