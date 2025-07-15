package com.mavconnect.MyAnimeVault.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AnimeApiDataDTO(
        @JsonAlias("title")
        String title,
        @JsonAlias("type")
        String type,
        @JsonAlias("airing")
        Boolean airing,
        @JsonAlias("episodes")
        Integer episodes,
        @JsonAlias("score")
        String score,
        @JsonAlias("synopsis")
        String synopsis,
        @JsonAlias("year")
        String releaseYear,
        @JsonAlias("genres")
        List<GenreApiDTO> genres



) {
}
