package com.github.gabaghul.findlyricsapplication.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class Configuration {
    @Value("${RAPIDAPI_GENIUS_APIKEY}")
    private String geniusApiKey;
    @Value("${RAPIDAPI_GENIUS_HOST}")
    private String geniusHost;
    @Value("${GENIUS_GETSONG_METHOD}")
    private String getSongMethod;
    @Value("${GENIUS_GETSONG_URI}")
    private String getSongUri;
}
