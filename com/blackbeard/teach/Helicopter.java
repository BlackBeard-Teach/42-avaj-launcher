package com.blackbeard.teach;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        weatherTower.getWeather(coordinates);
        if (coordinates.getHeight() == 0)
        {
            //Need to log the msg
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower)
    {
        //Will need to log the msg
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

}
