package com.blackbeard.teach;

public class AircraftFactory {
    /**
     * Aircraft Factory creates an aircraft instance based on what is passed to it.
     * @param type
     * @param name
     * @param longitude
     * @param latitude
     * @param height
     * @return
     */
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Flyable newOne = null;
        //possible switch statement implementation.
        if (type.equals("Baloon")){
           newOne = new Baloon(name, new Coordinates(longitude, latitude, height));
        }
        else if (type.equals("Helicopter"))
        {
            newOne = new Helicopter(name, new Coordinates(longitude, latitude, height));
        }
        else if (type.equals("JetPlane"))
        {
            newOne = new JetPlane(name, new Coordinates(longitude, latitude, height));
        }
        else
        {
            System.out.println("Invalid Aircraft type: Allowed types: Helicopter, JetPlane, Balloon");
        }
        return newOne;
    }
}
