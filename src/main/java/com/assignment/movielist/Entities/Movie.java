package com.assignment.movielist.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="movie")
public class Movie {

    @Id
    @Column(name = "id")
    private Long id;

    //private List<String> cast;

    @Column(name = "name")
    private String name;

    @Column(name = "directed_by")
    private String directedBy;

    @Column(name = "produced_by")
    private String producedBy;

    @Column(name = "production_house")
    private String productionHouse;

    @Column(name = "music_composer")
    private String musicComposer;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "language")
    private String language;

    @Column(name = "budget")
    private Long budget;

    @Column(name = "box_off_collection")
    private Long boxOffCollection;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
