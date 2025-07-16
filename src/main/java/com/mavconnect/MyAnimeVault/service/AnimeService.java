package com.mavconnect.MyAnimeVault.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mavconnect.MyAnimeVault.model.Anime;
import com.mavconnect.MyAnimeVault.model.Genre;
import com.mavconnect.MyAnimeVault.model.GenreEnum;
import com.mavconnect.MyAnimeVault.model.dto.AnimeApiDataDTO;
import com.mavconnect.MyAnimeVault.model.dto.AnimeDTO;
import com.mavconnect.MyAnimeVault.model.dto.GenreApiDTO;
import com.mavconnect.MyAnimeVault.repository.AnimeRepository;
import com.mavconnect.MyAnimeVault.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimeService {
    @Autowired
    AnimeRepository animeRepository;
    @Autowired
    GenreRepository genreRepository;

    public Anime findAnimeInApi(String title){
        AnimeApiDataDTO animeData = JikanApiService.getData(title);
        String genreName = animeData.genres().get(0).name();
        GenreEnum genreEnum = GenreEnum.fromString(genreName);
        Genre genre = genreRepository
                .findByName(genreEnum)
                .orElseGet(() -> genreRepository.save(new Genre(genreEnum)));
        Anime anime = new Anime(animeData);
        anime.setGenre(genre);
        return anime;
    }

    public void saveAnime(Anime anime){
        Optional<Anime> existingAnime = animeRepository.findByTitle(anime.getTitle());
        if(existingAnime.isEmpty()){
            animeRepository.save(anime);
        }
    }

    public List<AnimeDTO> listAll() {
        List<Anime> anime = animeRepository.findAll();
        List<AnimeDTO> animeDto = anime.stream()
                .map(AnimeDTO::new)
                .toList();
        return animeDto;
    }
}
