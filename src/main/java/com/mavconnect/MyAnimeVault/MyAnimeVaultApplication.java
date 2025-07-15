package com.mavconnect.MyAnimeVault;

import com.mavconnect.MyAnimeVault.principal.Principal;
import com.mavconnect.MyAnimeVault.repository.AnimeRepository;
import com.mavconnect.MyAnimeVault.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyAnimeVaultApplication implements CommandLineRunner {

	@Autowired
	private AnimeRepository animeRepository;
	@Autowired
	private GenreRepository genreRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyAnimeVaultApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(animeRepository, genreRepository);
		principal.showData();
	}
}
