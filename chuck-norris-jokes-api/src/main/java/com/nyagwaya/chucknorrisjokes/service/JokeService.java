package com.nyagwaya.chucknorrisjokes.service;


import com.nyagwaya.chucknorrisjokes.data.CategoryInfo;
import com.nyagwaya.chucknorrisjokes.data.Joke;

public interface JokeService {

    CategoryInfo getCategories();

    Joke findRandomJokeForCategory(final String categories);
}
