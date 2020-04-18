package com.assignment.movielist.Controllers;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Models.MovieModel;
import com.assignment.movielist.Repositories.MovieRepository;
import com.assignment.movielist.Services.MovieListService;
import com.assignment.movielist.Services.MovieListServiceImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MovieListTests {
    @Mock
    @Autowired
    private MovieListService movieListService;

    @InjectMocks
    private MovieListController movieListController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenAllList_ReturnAll() {
        returnFindAllMovieRepository();
        List<MovieModel> movieList = movieListController.getMovieList();
        Mockito.verify(movieListService).getListMovies();
        Assert.assertEquals("Test movie list Size should be 1 ", 1, movieList.size());
    }

    private void returnFindAllMovieRepository() {
        MovieModel movie = new MovieModel();
        movie.setName("Test Movie");
        List<MovieModel> list = new ArrayList<>();
        list.add(movie);
        Mockito.when(movieListService.getListMovies()).thenReturn(list);
    }
}
