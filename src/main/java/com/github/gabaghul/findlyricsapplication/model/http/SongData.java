package com.github.gabaghul.findlyricsapplication.model.http;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class SongData {
    @JsonAlias("artist_name")
    private String artistName;
    private String title;
    private Integer id;
}
