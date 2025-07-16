package com.mavconnect.MyAnimeVault.repository;

import com.mavconnect.MyAnimeVault.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
    Optional<Anime> findByTitle(String title);
}
