package com.assignment.movielist.Services;

import com.assignment.movielist.Entities.Movie;

import java.util.List;

public interface MovieListService {
    List<Movie> getListMovies();
    Movie createMovie(Movie movie);
    Movie updateMovie(Movie movie);
    Movie findMovieByName(String movieName);
}
