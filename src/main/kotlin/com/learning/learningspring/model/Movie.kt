package com.learning.learningspring.model

import java.util.*

data class Movie(
	val id: UUID = UUID.randomUUID(),
	val name: String
){
	companion object
}