package com.mavconnect.MyAnimeVault.principal;

import com.mavconnect.MyAnimeVault.model.dto.AnimeApiDataDTO;
import com.mavconnect.MyAnimeVault.model.dto.JikanResponseDTO;
import com.mavconnect.MyAnimeVault.service.AnimeConverter;
import com.mavconnect.MyAnimeVault.service.JikanApiService;

import java.util.Scanner;

public class Principal {
    
    private AnimeConverter converter = new AnimeConverter();
    private final String BASE_URL = "https://api.jikan.moe/v4/anime?q=";
    Scanner reader = new Scanner(System.in);
    public void showData(){

        getAnimeData();
    }

    public void getAnimeData(){
        System.out.println("Enter anime name: ");
        String name = reader.nextLine().toLowerCase();
        name = name.contains(" ") ? name.replaceAll(" ", "+") : name;
        String json = JikanApiService.getData(BASE_URL+name);
        JikanResponseDTO data = converter.getData(json, JikanResponseDTO.class);
        selectAnime(data);
    }

    private void selectAnime(JikanResponseDTO data){
        for(int i = 0; i<data.animes().size(); i++){
            System.out.println((i+1)+" - "+data.animes().get(i).title());
        }
        System.out.println("Enter index to select: ");
        int index = Integer.parseInt(reader.nextLine());
        AnimeApiDataDTO animeData = data.animes().get(index-1);
        System.out.println(animeData);

    }

}
