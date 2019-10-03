package com.stackroute.movieservices.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@ApiModel(description = "All details about the Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(value = "id")
    @ApiModelProperty(value = "Movie Id")
    private int id;

    @JsonProperty(value = "title")
    @ApiModelProperty(value = "Movie Title")
    private String title;

    @JsonProperty(value = "vote_average")
    @Column(name = "vote_average")
    @ApiModelProperty(value = "Movie average voted rating")
    private float voteAverage;

    @JsonProperty(value = "release_date")
    @Column(name = "release_date")
    @ApiModelProperty(value = "Movie release date")
    private String releaseDate;

    @JsonProperty(value = "adult")
    @ApiModelProperty(value = "Movie rating adult or not")
    private Boolean adult;

    @JsonProperty(value = "overview")
    @ApiModelProperty(value = "Movie Overview")
    private String overview;

    public Movie() {
    }
    public Movie(int id, String title, float voteAverage, String releaseDate, Boolean adult, String overview) {
        this.id = id;
        this.title = title;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
        this.adult = adult;
        this.overview = overview;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
        System.out.println("Title " + title);
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Boolean getAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", voteAverage=" + voteAverage +
                ", releaseDate='" + releaseDate + '\'' +
                ", adult=" + adult +
                ", overview='" + overview + '\'' +
                '}';
    }
}
