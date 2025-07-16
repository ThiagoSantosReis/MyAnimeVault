package com.mavconnect.MyAnimeVault.controller;

import com.mavconnect.MyAnimeVault.model.Anime;
import com.mavconnect.MyAnimeVault.model.dto.AnimeDTO;
import com.mavconnect.MyAnimeVault.model.dto.AnimeSearchRequest;
import com.mavconnect.MyAnimeVault.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anime")
public class AnimeController {

    @Autowired
    AnimeService animeService;

    @GetMapping
    public List<AnimeDTO> listAllAnime(){
        return animeService.listAll();
    }

    @PostMapping("/import")
    public void importAnime(@RequestBody AnimeSearchRequest request){
        Anime anime = animeService.findAnimeInApi(request.title());
        animeService.saveAnime(anime);
    }

}
