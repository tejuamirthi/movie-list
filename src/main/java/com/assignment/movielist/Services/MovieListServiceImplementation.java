package com.assignment.movielist.Services;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Models.MovieModel;
import com.assignment.movielist.Models.ResponseParse;
import com.assignment.movielist.Repositories.MovieRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovieListServiceImplementation implements MovieListService {

    @Autowired
    private MovieRepository movieRepository;

    @Value("${url.wikipedia}")
    private String url;


    private List<String> movieNames = new ArrayList<>();

    @Override
    public List<MovieModel> getListMovies() {
        List<Movie> movieList = movieRepository.findAll();
        List<MovieModel> movieModelList = new ArrayList<>();
        for(Movie movie: movieList) {
            MovieModel movieModel = new MovieModel();
            BeanUtils.copyProperties(movie, movieModel);
            movieModelList.add(movieModel);
        }
        return movieModelList;
    }

    @Transactional
    @Override
    public void deleteData() {
        movieRepository.deleteAll();
    }

    @Transactional
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

            Movie movie = getMovieClass(rows, movieName);


            movieRepository.save(movie);
        }
    }

    private void assignMovieNames() {
        movieNames.clear();
        movieNames.add("The Matrix");
        // add new Movie names
    }

    private Movie getMovieClass(Elements rows, String movieName) {
        Movie movie = new Movie();
        movie.setName(movieName);


        Element directedByEle = rows.get(2).select("td").get(0);
        String dirName = directedByEle.getElementsByTag("a").get(0).text();
        movie.setDirectedBy(dirName);

        Element producedByEle = rows.get(3).select("td").get(0);
        String proName = producedByEle.getElementsByTag("a").get(0).text();
        movie.setProducedBy(proName);

        Element writtenByEle = rows.get(4).select("td").get(0);
        String writerName = writtenByEle.getElementsByTag("a").get(0).text();
        movie.setProducedBy(writerName);




        return movie;
    }

    public List<MovieModel> getMoviesByFilter(String title, Date releasedAfter, Date releasedBefore, String orderBy, boolean desc) {

        List<Movie> movieList;

        movieList = movieRepository.getMoviesByFilter(title, releasedBefore, releasedAfter, orderBy, desc);

        List<MovieModel> movieModelList = new ArrayList<>();
        for(Movie movie: movieList) {
            MovieModel movieModel = new MovieModel();
            BeanUtils.copyProperties(movie,movieModel);
            movieModelList.add(movieModel);
        }
        return movieModelList;
    }

}
