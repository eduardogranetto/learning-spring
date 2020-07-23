package com.learning.learningspring.integration.fixtures

import com.learning.learningspring.model.Movie
import java.util.*

fun Movie.Companion.fixture(
	id: UUID = UUID.randomUUID(),
	name: String = "The Godfather"
) = Movie(id, name)


val fixtureMovies = listOf(
	Movie.fixture(),
	Movie.fixture(name = "The Godfather II"),
	Movie.fixture(name = "Mission Impossible"),
	Movie.fixture(name = "The Purge")
)