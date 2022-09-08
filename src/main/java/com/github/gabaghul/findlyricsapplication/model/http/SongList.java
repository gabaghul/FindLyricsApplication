package com.github.gabaghul.findlyricsapplication.model.http;

import java.util.List;

import lombok.Data;

@Data
public class SongList {
    private List<Hit> hits;
}
