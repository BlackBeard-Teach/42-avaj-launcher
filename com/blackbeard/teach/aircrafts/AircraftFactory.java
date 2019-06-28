package com.blackbeard.teach.aircrafts;

public abstract class AircraftFactory {
    /**
     * Aircraft Factory creates an aircraft instance based on what is passed to it and throws a custom exception if invali.
     * @param type - Type of aircraft to be created.
     * @param name - Name of aircraft to be created.
     * @param longitude - The longitude of the aircraft.
     * @param latitude - The latitude of the aircraft.
     * @param height - The height of the aircraft
     * @return - returns an instance of the aircraft if valid parameters are passed.
     */
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        if (longitude < 0 || latitude < 0 )
        {
            throw new IllegalArgumentException("Wrong Aircraft parameters");
        }
        Flyable newOne;
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
            throw new IllegalArgumentException("Aircraft type does not exist");
        }
        return newOne;
    }
}
