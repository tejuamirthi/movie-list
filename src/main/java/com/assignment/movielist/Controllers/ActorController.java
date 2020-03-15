package com.assignment.movielist.Controllers;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Models.ActorModel;
import com.assignment.movielist.Models.MovieModel;
import com.assignment.movielist.Services.actor.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping(path = "/actor")
    public ActorModel getActor(@RequestParam(name = "name") String name) {
        return actorService.getActor(name);
    }

    @GetMapping(path = "/actor-movies")
    public Set<MovieModel> getMoviesByActor(@RequestParam(name = "name") String name) {
        return actorService.getActor(name).getMovies();
    }

}
