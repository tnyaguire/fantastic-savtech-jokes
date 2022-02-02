package com.nyagwaya.chucknorrisjokes.resource;

import com.nyagwaya.chucknorrisjokes.data.CategoryInfo;
import com.nyagwaya.chucknorrisjokes.data.Joke;
import com.nyagwaya.chucknorrisjokes.service.JokeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jokes")
@Slf4j
public class JokesResource {

    @Autowired
    private JokeService jokesService;

    @GetMapping("/categories")

    public CategoryInfo getCategories (){
       return jokesService.getCategories();
    }

    @GetMapping("/random")
    public Joke getRandomJoke(@RequestParam final String category){
        log.debug("finding random joke for category: {}", category);
        return jokesService.findRandomJokeForCategory(category);
    }
}
