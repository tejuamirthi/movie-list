package com.assignment.movielist.Controllers;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Models.ActorModel;
import com.assignment.movielist.Models.MovieModel;
import com.assignment.movielist.Services.actor.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/actor", consumes = "application/json")
    public String createActor(@RequestBody ActorModel actorModel){
        StringBuilder result = new StringBuilder();
        try {
            actorService.createActor(actorModel);
            result.append("Successfully Created a actor");
        } catch (Exception e) {
            result.append("Failed to create the actor");
            e.printStackTrace();
        }
        return result.toString();
    }

    @DeleteMapping(path = "/actor", consumes = "application/json")
    public String deleteActor(@RequestBody ActorModel actorModel){
        StringBuilder result = new StringBuilder();
        try {
            actorService.deleteActor(actorModel);
            result.append("Successfully deleted a actor");
        } catch (Exception e) {
            result.append("Failed to delete the actor");
            e.printStackTrace();
        }
        return result.toString();
    }
}
