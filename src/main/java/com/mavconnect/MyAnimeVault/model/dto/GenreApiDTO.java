package com.mavconnect.MyAnimeVault.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GenreApiDTO(
        @JsonAlias("genres")
        @NotBlank
        String name
) {
}
