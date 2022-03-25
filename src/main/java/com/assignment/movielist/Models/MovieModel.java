package com.assignment.movielist.Models;

import com.assignment.movielist.Entities.Actor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MovieModel {

    private String name;

    private String directedBy;

    private String producedBy;

    private String productionHouse;

    private String musicComposer;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date releaseDate;

    private Long duration;

    private String language;

    private Long budget;

    private Long boxOffCollection;

    private Set<ActorModel> actors = new HashSet<>();

    public void addActor(ActorModel actor) {
        actors.add(actor);
    }

    public void removeActor(ActorModel actor) {
        actors.remove(actor);
    }

    public Set<ActorModel> getActors() {
        return actors;
    }

    public void setActors(Set<ActorModel> actors) {
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducedBy() {
        return producedBy;
    }

    public void setProducedBy(String producedBy) {
        this.producedBy = producedBy;
    }

    public String getDirectedBy() {
        return directedBy;
    }

    public void setDirectedBy(String directedBy) {
        this.directedBy = directedBy;
    }

    public String getProductionHouse() {
        return productionHouse;
    }

    public void setProductionHouse(String productionHouse) {
        this.productionHouse = productionHouse;
    }

    public String getMusicComposer() {
        return musicComposer;
    }

    public void setMusicComposer(String musicComposer) {
        this.musicComposer = musicComposer;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Long getBoxOffCollection() {
        return boxOffCollection;
    }

    public void setBoxOffCollection(Long boxOffCollection) {
        this.boxOffCollection = boxOffCollection;
    }
}
