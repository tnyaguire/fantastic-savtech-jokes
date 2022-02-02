package com.nyagwaya.chucknorrisjokes.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class CategoryInfo {
    private List<String> categories= new ArrayList<>();
    public void add(String category){
        categories.add(category);
    }
}
