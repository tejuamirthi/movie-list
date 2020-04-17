package com.assignment.movielist.controllersTests;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Models.MovieModel;
import com.assignment.movielist.Repositories.MovieRepository;
import com.assignment.movielist.Services.MovieListService;
import com.assignment.movielist.Services.MovieListServiceImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MovieListTests {
    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieListService movieListService = new MovieListServiceImplementation();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenAllList_ReturnAll() {
        returnFindAllMovieRepository();
        List<MovieModel> movieList = movieListService.getListMovies();
        Mockito.verify(movieRepository).findAll();
        Assert.assertEquals("Test movielist Size should be 1 ", 1, movieList.size());
    }

    private void returnFindAllMovieRepository() {
        Movie movie = new Movie();
        movie.setName("Test Movie");
        ArrayList<Movie> list = new ArrayList<>();
        list.add(movie);
        Mockito.when(movieRepository.findAll()).thenReturn(list);
    }
}
