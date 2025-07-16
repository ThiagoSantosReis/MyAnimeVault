package com.mavconnect.MyAnimeVault.model.dto;

import com.mavconnect.MyAnimeVault.model.Anime;

public record AnimeDTO(
        Long id,
        String title,
        Boolean airing,
        Integer episodes,
        Double score
) {
    public AnimeDTO(Anime anime){
        this(anime.getId(), anime.getTitle(), anime.getAiring(), anime.getEpisodes(), anime.getScore());
    }
}
