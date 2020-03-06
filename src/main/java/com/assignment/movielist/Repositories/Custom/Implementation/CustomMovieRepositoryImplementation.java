package com.assignment.movielist.Repositories.Custom.Implementation;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Repositories.Custom.CustomMovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

public class CustomMovieRepositoryImplementation implements CustomMovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // TODO complete the dynamic query 
    @Override
    public List<Movie> getMoviesByFilter(String name, Date releaseBefore, Date releaseAfter) {
        return null;
    }
}
