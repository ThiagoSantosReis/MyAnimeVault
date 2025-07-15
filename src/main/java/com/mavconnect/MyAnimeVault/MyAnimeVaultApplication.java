package com.mavconnect.MyAnimeVault;

import com.mavconnect.MyAnimeVault.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyAnimeVaultApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyAnimeVaultApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.showData();
	}
}
