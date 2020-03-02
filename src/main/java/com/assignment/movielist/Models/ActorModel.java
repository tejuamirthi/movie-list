package com.assignment.movielist.Models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class ActorModel {

    private String name;
    private Set<MovieModel> movies = new HashSet<MovieModel>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieModel> movies) {
        this.movies = movies;
    }
}
