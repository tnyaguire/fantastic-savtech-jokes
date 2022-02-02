package com.nyagwaya.chucknorrisjokes.service;


import com.nyagwaya.chucknorrisjokes.data.CategoryInfo;
import com.nyagwaya.chucknorrisjokes.data.Joke;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JokeServiceImpl implements JokeService {

    private String categoriesUrl = "https://api.chucknorris.io/jokes/categories";

    private String randomJokeUrl = "https://api.chucknorris.io/jokes/random?category={category}";

    private final RestTemplate restTemplate;

    @Override
    @Cacheable(cacheNames = {"categories"})
    public CategoryInfo getCategories() {
        log.info("fetching categories");
        final CategoryInfo categoryInfo = new CategoryInfo();
        restTemplate.exchange(
                categoriesUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<String>>() {
                }).getBody()
                .stream()
                .forEach(categoryInfo::add);
        return categoryInfo;
    }

    public Joke findRandomJokeForCategory(final String categories){
        return restTemplate.exchange(
                randomJokeUrl, HttpMethod.GET, null,Joke.class, categories).getBody();
    }
}
