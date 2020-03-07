package com.assignment.movielist.Repositories;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Repositories.Custom.CustomMovieRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, CustomMovieRepository {
}
