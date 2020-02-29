package com.assignment.movielist.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Actor {
    @Id
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "movie_cast",
            joinColumns = { @JoinColumn(name = "actor_id", referencedColumnName = "name") },
            inverseJoinColumns = { @JoinColumn(name = "movie_id", referencedColumnName = "id") })
    private Set<Movie> movies = new HashSet<Movie>();

    public void addMovie(Movie movie) {
        movies.add(movie);
        movie.addActor(this);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
        movie.removeActor(this);
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
