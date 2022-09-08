package com.github.gabaghul.findlyricsapplication.model.http;

import lombok.Data;

@Data
public class SearchSongResponse {
    private Meta meta;
    private SongList response;
}
