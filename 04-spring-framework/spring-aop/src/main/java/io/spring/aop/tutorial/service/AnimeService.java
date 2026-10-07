package io.spring.aop.tutorial.service;

import io.spring.aop.tutorial.model.AnimeDto;
import org.springframework.stereotype.Service;

@Service
public class AnimeService {

    public AnimeDto createAnime(String name, int rating){

        //System.out.println("inside create anime");
        AnimeDto animeDto = new AnimeDto();

        //System.out.println("setting animedto values");
        animeDto.setAnime(name);
        animeDto.setRating(rating);

        //System.out.println("returning the anime");
        return animeDto;
    }

    public void animeException(){
        throw new RuntimeException();
    }
}
