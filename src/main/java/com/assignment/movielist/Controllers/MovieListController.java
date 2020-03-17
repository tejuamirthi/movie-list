package com.assignment.movielist.Controllers;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Models.MovieModel;
import com.assignment.movielist.Models.ResponseParse;
import com.assignment.movielist.Services.MovieListService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@RestController
public class MovieListController {


    @Autowired
    private MovieListService movieListService;

    @GetMapping(path = "/get-list")
    public List<MovieModel> getMovieList() {
        return movieListService.getListMovies();
    }

    @GetMapping(path = "/clean-db")
    public void deleteData() {
        movieListService.deleteData();
    }

    @GetMapping(path = "/scrape-db")
    public void scrapeMoviesAgain() throws UnsupportedEncodingException {
        movieListService.scrapeData(); //implement scraping logic
    }

    @GetMapping(path = "/get-list-db")
    public List<MovieModel> getMovieListFromDB() {
        return movieListService.getListMovies();
    }

    // working date patter dd/mm/yyyy
    @GetMapping(path = "/get-filter-list")
    public List<MovieModel> getMoviesByFilter(@RequestParam(value = "title", required = false) String name,
                                              @RequestParam(value = "released-before", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date releasedBefore,
                                              @RequestParam(value = "released-after", required = false) Date releasedAfter,
                                              @RequestParam(value = "sort-by", required = false) String orderBy,
                                              @RequestParam(value = "desc", required = false) boolean desc) {
        return movieListService.getMoviesByFilter(name, releasedAfter, releasedBefore,orderBy, desc);
    }

}
