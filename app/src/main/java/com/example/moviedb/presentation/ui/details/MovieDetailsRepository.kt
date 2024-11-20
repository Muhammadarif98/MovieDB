package com.example.moviedb.presentation.ui.details

import com.example.moviedb.data.model.moviedetails.MovieDetails
import com.example.moviedb.data.remote.MovieInterface
import com.example.moviedb.presentation.utils.Constants
import com.example.moviedb.presentation.utils.Result
import com.example.moviedb.presentation.utils.Status

class MovieDetailsRepository(private val movieInterface: MovieInterface) {

    suspend fun getMovieDetails(imdbID: String): Result<MovieDetails> {
        return try {
            val response = movieInterface.getMoviesDetails(imdbID, Constants.API_KEY)

            if (response.isSuccessful) {
                return Result(Status.SUCCESS,response.body(), null)
            } else {
                Result(Status.ERROR,null, null)
            }

        } catch (e: Exception) {
            Result(Status.ERROR,null, null)
        }
    }
}

