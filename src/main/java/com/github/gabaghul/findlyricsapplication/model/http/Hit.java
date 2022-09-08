package com.github.gabaghul.findlyricsapplication.model.http;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonSerialize
public class Hit {
    private String index;
    private String type;
    private SongData result;
}
