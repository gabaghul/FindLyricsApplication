package com.github.gabaghul.findlyricsapplication.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Song {
    private Integer id;
    // Could be a class Artist here, but I will use just the name of the artist
    private String artist; 
    private String title;
    private String lyrics;
}
