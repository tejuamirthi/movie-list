package com.assignment.movielist.Repositories.Custom;

import com.assignment.movielist.Entities.Movie;

import java.util.Date;
import java.util.List;

public interface CustomMovieRepository {

    List<Movie> getMoviesByFilter(String name, Date releaseBefore, Date releaseAfter, String sortBy, boolean desc);

}
