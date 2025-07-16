package com.mavconnect.MyAnimeVault.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mavconnect.MyAnimeVault.model.dto.AnimeApiDataDTO;
import com.mavconnect.MyAnimeVault.model.dto.JikanResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JikanApiService {
    private static final RestTemplate restTemplate = new RestTemplate();
    private static  AnimeConverter converter = new AnimeConverter();

    public static AnimeApiDataDTO getData(String title){
        String url = "https://api.jikan.moe/v4/anime?q="+title.toLowerCase();

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            JikanResponseDTO responseDTO = converter.getData(response.getBody(), JikanResponseDTO.class);

            return responseDTO.animes().get(0);
        }catch (Exception e){
            throw new RuntimeException("Error: query has failed", e);

        }
    }
}
