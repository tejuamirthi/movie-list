package com.assignment.movielist.Services;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Models.MovieModel;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

public interface MovieListService {
    List<MovieModel> getListMovies();
    void deleteData();
    void scrapeData() throws UnsupportedEncodingException;
    List<MovieModel> getMoviesByFilter(String title, Date releasedAfter, Date releasedBefore, String orderBy, boolean desc);
}
