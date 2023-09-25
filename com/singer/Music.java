package com.singer;

import java.util.Objects;

public class Music {
    private String title;
    private String duration;
    private String genre;
    private Date releaseDate;
    private Singer singer;

    // Constructor
    public Music(String title, String duration, String genre, Date releaseDate, Singer singer) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.singer = singer;
    }

    // setter


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    // Getters


    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Singer getSinger() {
        return singer;
    }

    //to String function
    @Override
    public String toString() {

        return String.format("Song title : %s\nMusic Duration : %s\nGenre : %s\nRelease Date : %s\n\nSinger Information\n %s" , title,duration,genre , releaseDate , singer);
    }

    public boolean equalss(Music m1){
        return this.title.equals(m1.title);
    }

    @Override
    public boolean equals(Object o) {
        Music music = (Music) o;
        return Objects.equals(title, music.title);
    }





}

