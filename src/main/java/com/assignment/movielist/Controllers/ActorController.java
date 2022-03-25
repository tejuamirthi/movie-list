package com.assignment.movielist.Controllers;

import com.assignment.movielist.Exceptions.ActorNotFound;
import com.assignment.movielist.Models.ActorModel;
import com.assignment.movielist.Models.MovieModel;
import com.assignment.movielist.Services.actor.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping(path = "/actor")
    public ActorModel getActor(@RequestParam(name = "name") String name) throws ActorNotFound {
        return actorService.getActor(name);
    }

    @GetMapping(path = "/actor-movies")
    public Set<MovieModel> getMoviesByActor(@RequestParam(name = "name") String name) throws ActorNotFound {
        return actorService.getActor(name).getMovies();
    }

    @PostMapping(path = "/actor", consumes = "application/json")
    public ActorModel createActor(@RequestBody ActorModel actorModel){
        try {
            return actorService.createActor(actorModel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping(path = "/actor", consumes = "application/json")
    public ActorModel deleteActor(@RequestBody ActorModel actorModel) throws ActorNotFound {
        try {
            return actorService.deleteActor(actorModel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
