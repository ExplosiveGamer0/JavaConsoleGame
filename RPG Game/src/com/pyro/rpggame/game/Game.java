package com.pyro.rpggame.game;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    private GameProperties properties;
    Gson gson = new Gson();

    Scanner in = new Scanner(System.in);

    public void run() throws IOException {
        System.out.println("8 888888888o.   8 8888888888   b.             8 8 8888888888       ,o888888o.          .8.          8 888888888o.      8 888888888888 \n" +
                "8 8888    `88.  8 8888         888o.          8 8 8888            8888     `88.       .888.         8 8888    `^888.   8 8888         \n" +
                "8 8888     `88  8 8888         Y88888o.       8 8 8888         ,8 8888       `8.     :88888.        8 8888        `88. 8 8888         \n" +
                "8 8888     ,88  8 8888         .`Y888888o.    8 8 8888         88 8888              . `88888.       8 8888         `88 8 8888         \n" +
                "8 8888.   ,88'  8 888888888888 8o. `Y888888o. 8 8 888888888888 88 8888             .8. `88888.      8 8888          88 8 888888888888 \n" +
                "8 888888888P'   8 8888         8`Y8o. `Y88888o8 8 8888         88 8888            .8`8. `88888.     8 8888          88 8 8888         \n" +
                "8 8888`8b       8 8888         8   `Y8o. `Y8888 8 8888         88 8888   8888888 .8' `8. `88888.    8 8888         ,88 8 8888         \n" +
                "8 8888 `8b.     8 8888         8      `Y8o. `Y8 8 8888         `8 8888       .8'.8'   `8. `88888.   8 8888        ,88' 8 8888         \n" +
                "8 8888   `8b.   8 8888         8         `Y8o.` 8 8888            8888     ,88'.888888888. `88888.  8 8888    ,o88P'   8 8888         \n" +
                "8 8888     `88. 8 888888888888 8            `Yo 8 888888888888     `8888888P' .8'       `8. `88888. 8 888888888P'      8 888888888888 \n");

        System.out.println("\n");
        System.out.println("What would you like to do?" +
                "\nNew game" +
                "\nLoad game" +
                "\nExit game");

        String userInput = in.nextLine();

        switch(userInput)
        {
            case "New":
            case "new":
                newGame();
                break;
            case "Load":
            case "load":
                loadGame();
                break;
            case "Exit":
            case "exit":
                exitGame();
                break;
        }

    }

    public void newGame() {
        for (int i = 0; i < 80; i++) {
            System.out.println();
        }
        System.out.println("What do you choose your name to be?");
        properties.setName(in.nextLine());
        //properties.setName(playerName);

        saveGame();
    }

    public void saveGame() {

        GameProperties gameProperties = new GameProperties();
        gameProperties.setName("Paco");
        gameProperties.setHealth(150);
        gameProperties.setHealthMax(400);
        gameProperties.setWeapon("Dagger");
        gameProperties.setPotions(100);

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

        startGame();

        /**
        Path path = Paths.get("Character.json");
        String json = gson.toJson(properties, GameProperties.class);
        Files.write(path, Arrays.asList(json));
         **/
    }

    public void loadGame(){
        /**
        String json = "Character.json";
        properties = gson.fromJson(json, GameProperties.class);
        Gson gson = new Gson();
         **/

        try {

            System.out.println("Reading JSON from a file");
            System.out.println("----------------------------");

            BufferedReader br = new BufferedReader(
                    new FileReader("Character.json"));

            //convert the json string back to object
            GameProperties gameProperties = gson.fromJson(br, GameProperties.class);

            System.out.println("Name: "+properties.getName());


            System.out.println("Weapon: "+properties.getWeapon());

            System.out.println("Health: "+properties.getHealth()+" / "+properties.getHealthMax());

            System.out.println("Potions: "+properties.getPotions());

            /**
            System.out.println("Inventory:");

            List listOfStates = countryObj.getListOfStates();
            for (int i = 0; i < listOfStates.size(); i++) {
                System.out.println(listOfStates.get(i));
            }
             **/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exitGame(){

    }

    public void startGame(){
        for (int i = 0; i < 80; i++) {
            System.out.println();
        }
        System.out.println("You come out of the dungeon.");
        in.nextLine();

    }

}
