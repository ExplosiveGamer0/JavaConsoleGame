package com.pyro.rpggame.game;

public class GameProperties {
    private String name;
    private String weapon;
    private int health;
    private int healthMax;
    private int potions;

    //Constructor, getters, setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getWeapon(){
        return weapon;
    }

    public void setWeapon(String weapon){
        this.weapon = weapon;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealthMax(){
        return healthMax;
    }

    public void setHealthMax(int healthMax){
        this.healthMax = healthMax;
    }

    public int getPotions(){
        return potions;
    }

    public void setPotions(int potions){
        this.potions = potions;
    }
}
