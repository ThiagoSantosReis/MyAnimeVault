package com.mavconnect.MyAnimeVault.principal;

import com.mavconnect.MyAnimeVault.model.Anime;
import com.mavconnect.MyAnimeVault.model.Genre;
import com.mavconnect.MyAnimeVault.model.GenreEnum;
import com.mavconnect.MyAnimeVault.model.dto.AnimeApiDataDTO;
import com.mavconnect.MyAnimeVault.model.dto.JikanResponseDTO;
import com.mavconnect.MyAnimeVault.repository.AnimeRepository;
import com.mavconnect.MyAnimeVault.repository.GenreRepository;
import com.mavconnect.MyAnimeVault.service.AnimeConverter;
import com.mavconnect.MyAnimeVault.service.JikanApiService;

import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private AnimeRepository animeRepository;
    private GenreRepository genreRepository;

    private AnimeConverter converter = new AnimeConverter();
    private final String BASE_URL = "https://api.jikan.moe/v4/anime?q=";
    Scanner reader = new Scanner(System.in);

    public Principal(AnimeRepository animeRepository, GenreRepository genreRepository){
        this.animeRepository = animeRepository;
        this.genreRepository = genreRepository;
    }

    public void showData(){

        getAnimeData();
    }

    public void getAnimeData(){
        System.out.println("Enter anime name: ");
        String name = reader.nextLine().toLowerCase();
        name = name.contains(" ") ? name.replaceAll(" ", "+") : name;
        String json = JikanApiService.getData(BASE_URL+name);
        JikanResponseDTO data = converter.getData(json, JikanResponseDTO.class);
        Anime anime = selectAnime(data);


    }

    private Anime selectAnime(JikanResponseDTO data){
        for(int i = 0; i<data.animes().size(); i++){
            System.out.println((i+1)+" - "+data.animes().get(i).title());
        }
        System.out.println("Enter index to select: ");
        int index = Integer.parseInt(reader.nextLine());
        index = index < 0 || index > data.animes().size() ? 0 : index-1;
        AnimeApiDataDTO animeData = data.animes().get(index);
        String genreName = animeData.genres().get(0).name();
        GenreEnum genreEnum = GenreEnum.fromString(genreName);

        Genre genre = genreRepository
                .findByName(genreEnum)
                .orElseGet(() -> genreRepository.save(new Genre(genreEnum)));

        Anime anime = new Anime(animeData);
        anime.setGenre(genre);

        return anime;
    }

}
