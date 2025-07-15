package com.mavconnect.MyAnimeVault.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GenreApiDTO(
        @JsonAlias("genres")
        String name
) {
}
