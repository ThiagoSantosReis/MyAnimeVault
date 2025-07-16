package com.mavconnect.MyAnimeVault.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AnimeApiDataDTO(
        @JsonAlias("title")
        @NotBlank
        String title,
        @JsonAlias("type")
        @NotBlank
        String type,
        @JsonAlias("airing")
        @NotNull
        Boolean airing,
        @JsonAlias("episodes")
        @NotNull
        Integer episodes,
        @JsonAlias("score")
        @NotNull
        String score,
        @JsonAlias("synopsis")
        @NotBlank
        String synopsis,
        @JsonAlias("year")
        @NotBlank
        String releaseYear,
        @JsonAlias("genres")
        List<GenreApiDTO> genres



) {
}
