package com.blackbeard.teach;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Flyable newOne = null;
        if (type.equals("Baloon")){
           newOne = new Baloon(name, new Coordinates(longitude, latitude, height));
        }
        return newOne;
    }
}
