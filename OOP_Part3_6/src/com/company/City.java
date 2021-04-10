package com.company;

public class City{
    private String name;
    private long population;

    public City(){
        name = " ";
        population = 0;
    }

    public City(String s, long p){
        name = s;
        population = p;
    }

    public void setName(String s){
        name = s;
    }
    public String getName(){
        return name;
    }

    public void setPopulation(long p){
        population = p;
    }

    public long getPopulation(){ return population; }

}