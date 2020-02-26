package com.assignment.movielist;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

@RestController
public class MovieListController {


    @GetMapping(path = "/get-list")
    public Document getMovieList() throws Throwable {
        String url = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page="+ URLEncoder.encode("The Matrix","UTF-8");
        RestTemplate restTemplate = new RestTemplate();
        ResponseParse response = restTemplate.getForObject(url,ResponseParse.class);
        System.out.println(response.getParse().getText());

        Document htmlResponse = Jsoup.parse(response.getParse().getText().get("*"));
//        System.out.println(elements.toString());
        return htmlResponse;
    }

}
