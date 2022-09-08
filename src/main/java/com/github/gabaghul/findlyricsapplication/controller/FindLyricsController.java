package com.github.gabaghul.findlyricsapplication.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gabaghul.findlyricsapplication.model.Song;
import com.github.gabaghul.findlyricsapplication.model.http.SearchSongResponse;
import com.github.gabaghul.findlyricsapplication.service.FindLyricsService;

import lombok.Getter;

@RestController
@RequestMapping("find-lyrics")
@Getter
public class FindLyricsController {
    private FindLyricsService service;

    public FindLyricsController(FindLyricsService service) {
        this.service = service;
    }

    @PostMapping(
        path = "/song", 
        consumes = MediaType.APPLICATION_JSON_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SearchSongResponse getSong(@RequestBody Song song) {
        return this.getService().getSong(song);
    }
}
