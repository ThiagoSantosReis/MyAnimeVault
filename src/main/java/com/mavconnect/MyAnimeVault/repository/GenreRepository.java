package com.mavconnect.MyAnimeVault.repository;

import com.mavconnect.MyAnimeVault.model.Genre;
import com.mavconnect.MyAnimeVault.model.GenreEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByName(GenreEnum name);
}
