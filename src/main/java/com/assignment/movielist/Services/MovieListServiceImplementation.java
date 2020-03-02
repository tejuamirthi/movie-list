package com.assignment.movielist.Services;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Models.ResponseParse;
import com.assignment.movielist.Repositories.MovieRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieListServiceImplementation implements MovieListService {

    @Autowired
    private MovieRepository movieRepository;

    @Value("${url.wikipedia}")
    private String url;


    private List<String> movieNames = new ArrayList<>();

    @Override
    public List<Movie> getListMovies() {
        return movieRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteData() {
        movieRepository.deleteAll();
    }

    @Override
    public void scrapeData() throws UnsupportedEncodingException {
        assignMovieNames();

        for (String movieName:
             movieNames) {

            String url = this.url + URLEncoder.encode(movieName, "UTF-8");
            RestTemplate restTemplate = new RestTemplate();
            ResponseParse response = restTemplate.getForObject(url, ResponseParse.class);
            System.out.println(response.getParse().getText());

            Document htmlResponse = Jsoup.parse(response.getParse().getText().get("*"));
            Element table = htmlResponse.select("table").get(0);
            Elements rows = table.select("tr");

            Element directedByEle = rows.get(2).select("td").get(0);


            directedByEle.getElementsByTag("a").get(0).text();
        }
    }

    private void assignMovieNames() {
        movieNames.clear();
        movieNames.add("The Matrix");

    }

}
