package com.github.gabaghul.findlyricsapplication.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.gabaghul.findlyricsapplication.configuration.Configuration;
import com.github.gabaghul.findlyricsapplication.model.Song;
import com.github.gabaghul.findlyricsapplication.model.http.SearchSongResponse;

import lombok.Getter;

@Service
@Getter
public class FindLyricsService {

    private Configuration config;

    private static final Logger LOGGER = LogManager.getLogger();

    private RestTemplate httpClient;

    public FindLyricsService(Configuration config) {
        this.httpClient = new RestTemplate();
        this.config = config;
    }

    public SearchSongResponse getSong(Song song) {
        LOGGER.info("calling song search api for artist: {} title: {}", song.getArtist(), song.getTitle());

        HttpMethod method = HttpMethod.valueOf(this.getConfig().getGetSongMethod());
        String url = UriComponentsBuilder
            .fromHttpUrl(this.getConfig().getGetSongUri())
            .queryParam("q", song.getArtist().concat(" - ").concat(song.getTitle()))
            .encode().toUriString();

        RequestEntity<Void> request = RequestEntity
            .method(method, url)
            .header("X-RapidAPI-Host", this.getConfig().getGeniusHost())
            .header("X-RapidAPI-Key", this.getConfig().getGeniusApiKey())
            .build();

        ResponseEntity<SearchSongResponse> response = ResponseEntity.noContent().build();
        try {
            response = this.getHttpClient().exchange(request, SearchSongResponse.class);
        } catch(RestClientException e)  {
            LOGGER.error("error when called search song api", e);
            throw e;
        }
        return response.getBody();
    }
}
