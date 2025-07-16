package com.mavconnect.MyAnimeVault.repository;

import com.mavconnect.MyAnimeVault.model.Anime;
import com.mavconnect.MyAnimeVault.model.dto.AnimeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
    Optional<Anime> findByTitle(String title);


    List<Anime> findTop5ByOrderByScoreDesc();
}
