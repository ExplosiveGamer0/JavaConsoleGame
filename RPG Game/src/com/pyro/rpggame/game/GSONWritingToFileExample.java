package com.pyro.rpggame.game;

import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

public class GSONWritingToFileExample {

    public static void test(){

        GameProperties gameProperties = new GameProperties();
        gameProperties.setName("Pyro");
        gameProperties.setHealth(100);
        gameProperties.setHealthMax(200);
        gameProperties.setWeapon("Sword");
        gameProperties.setPotions(60);

        Gson gson = new Gson();

        // Convert java object to JSON format,
        // and returned as JSON formatted string
        String json = gson.toJson(gameProperties);

        try {
            //write converted json data to a file named "Character.json"
            FileWriter writer = new FileWriter("Character.json");
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(json);
    }

}
