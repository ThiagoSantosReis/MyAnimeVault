package com.mavconnect.MyAnimeVault.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JikanResponseDTO(
        @JsonAlias("data")
        List<AnimeApiDataDTO> animes
) {
}
