package io.spring.aop.tutorial;

import io.spring.aop.tutorial.service.AnimeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorialApplication implements CommandLineRunner {

	private AnimeService animeService;

	public TutorialApplication(AnimeService animeService) {
		this.animeService = animeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		animeService.createAnime("naruto", 10);
		animeService.animeException();
	}
}
