package com.mavconnect.MyAnimeVault.repository;

import com.mavconnect.MyAnimeVault.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
