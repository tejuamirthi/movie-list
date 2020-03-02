package com.assignment.movielist.Services;

import com.assignment.movielist.Entities.Movie;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface MovieListService {
    List<Movie> getListMovies();
    void deleteData();
    void scrapeData() throws UnsupportedEncodingException;
}
