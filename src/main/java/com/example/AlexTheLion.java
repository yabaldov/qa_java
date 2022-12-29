package com.example;

import java.util.List;

public class AlexTheLion extends Lion {

    public AlexTheLion()  throws Exception  {
        super(new Feline(), "Самец");
    }

    @Override
    public int getKittens() {return 0;}

    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
}
