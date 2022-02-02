package com.nyagwaya.chucknorrisjokes.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Joke {

    @JsonProperty("categories")
    private List<String> categories = new ArrayList<>();

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("icon_url")
    private String iconUrl;

    @JsonProperty("id")
    private String id;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("url")
    private String url;

    @JsonProperty("value")
    private String value;
}
