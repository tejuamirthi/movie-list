package com.assignment.movielist.Services;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieListServiceImplementation implements MovieListService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getListMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie createMovie(Movie movie) {
        return null;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return null;
    }

    @Override
    public Movie findMovieByName(String movieName) {
        return movieRepository.findMovieByName(movieName);
    }
}
