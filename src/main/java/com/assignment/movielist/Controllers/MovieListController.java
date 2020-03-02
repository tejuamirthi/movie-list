package com.assignment.movielist.Controllers;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Models.ResponseParse;
import com.assignment.movielist.Services.MovieListService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.List;

@RestController
public class MovieListController {


    @Autowired
    private MovieListService movieListService;

    @GetMapping(path = "/get-list")
    public List<Movie> getMovieList() throws Throwable {
        return movieListService.getListMovies();
    }

    @GetMapping(path = "/clean-db")
    public void deleteData() {
        movieListService.deleteData();
    }

    @GetMapping(path = "/scrape-db")
    public void scrapeMoviesAgain() {
        movieListService.deleteData(); //implement scraping logic
    }

    @GetMapping(path = "/get-list-db")
    public List<Movie> getMovieListFromDB() throws Throwable {
        return movieListService.getListMovies();
    }
}
