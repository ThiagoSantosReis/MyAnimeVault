package com.mavconnect.MyAnimeVault.principal;

import com.mavconnect.MyAnimeVault.model.dto.JikanResponseDTO;
import com.mavconnect.MyAnimeVault.service.AnimeConverter;
import com.mavconnect.MyAnimeVault.service.JikanApiService;

import java.util.Scanner;

public class Principal {
    private AnimeConverter converter = new AnimeConverter();
    private final String BASE_URL = "https://api.jikan.moe/v4/anime?q=";
    Scanner reader = new Scanner(System.in);
    public void showData(){
        System.out.println("Enter anime name: ");
        String name = reader.nextLine().toLowerCase();
        name = name.contains(" ") ? name.replaceAll(" ", "+") : name;
        String json = JikanApiService.getData(BASE_URL+name);
        JikanResponseDTO data = converter.getData(json, JikanResponseDTO.class);
        System.out.println(data.animes());
    }
}
