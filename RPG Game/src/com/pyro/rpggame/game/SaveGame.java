package com.pyro.rpggame.game;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class SaveGame {

    private GameProperties properties;
    Gson gson = new Gson();
    private String json;


    public void test() throws IOException {
        Path path = Paths.get("Character.json");
        String json = gson.toJson(properties, GameProperties.class);
        Files.write(path, Arrays.asList(json));
    }

    // replace "Arrays.asList(json)" with List.of at home

    public void test2(){
        properties = gson.fromJson(json, GameProperties.class);
    }
}

