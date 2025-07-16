package com.mavconnect.MyAnimeVault;

import com.mavconnect.MyAnimeVault.principal.Principal;
import com.mavconnect.MyAnimeVault.repository.AnimeRepository;
import com.mavconnect.MyAnimeVault.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyAnimeVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAnimeVaultApplication.class, args);
	}

}
