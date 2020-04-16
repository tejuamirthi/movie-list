package com.assignment.movielist.controllersTests;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Models.MovieModel;
import com.assignment.movielist.Services.MovieListService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(locations = "classpath*:/spring/applicationContext*.xml")
public class MovieListTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MovieListService movieListService;


    @Test
    public void whenAllList_ReturnAll() {
        Movie movie = new Movie();
        movie.setName("NewTestUser");
        entityManager.persist(movie);
        entityManager.flush();

        List<MovieModel> list = movieListService.getMoviesByFilter("NewTestUser",null, null,null, false);
        assertThat(list.size()).isEqualTo(1);
    }
}
