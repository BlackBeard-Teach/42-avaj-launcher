package com.blackbeard.teach;

public class JetPlane extends Aircraft implements Flyable {
    WeatherTower weatherTower;

    /**
     * JetPlane constructor with aurguments from the base class Aircraft
     * @param name
     * @param coordinates
     */
    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    /**
     * This will request the weather from the weatherTower and based on the
     * conditions, it will modify the coordinates
     * If the height of the flyable is 0 (meaning the flight has landed)
     * it will unregister it from the weatherTower
     */

    public void updateConditions()
    {
        if (weatherTower.getWeather(coordinates).equals("SUN"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
            //Log msg here
        }
        if (weatherTower.getWeather(coordinates).equals("RAIN"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
            //Log msg here
        }
        if (weatherTower.getWeather(coordinates).equals("FOG"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());

        }
        if (weatherTower.getWeather(coordinates).equals("SNOW"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
        }

        //need to log the msg
        if (coordinates.getHeight() == 0)
        {
            weatherTower.unregister(this);
        }

    }

    public void registerTower(WeatherTower weatherTower)
    {
        //Need to log msg
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
