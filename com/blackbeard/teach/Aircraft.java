package com.blackbeard.teach;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    //Default constructor
    //public Aircraft() {}
    protected Aircraft (String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        id = nextId();
    }

    /**
     * This generates a unique ID that will be assigned to the flight
     * @return
     */
    private long nextId()
    {
        return idCounter++;
    }

//    public void getWeatherConditions(String weather)
//    {
//        if (weather.equals("SUN"))
//        {
//            this.coordinates = new Coordinates()
//        }
//    }
}
