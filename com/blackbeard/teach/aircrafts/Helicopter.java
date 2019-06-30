package com.blackbeard.teach.aircrafts;

import com.blackbeard.teach.utils.WeatherLogMsg;
import com.blackbeard.teach.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    /**
     * This method will update the weather conditions of the sim.
     */
    public void updateConditions()
    {
        WeatherLogMsg weatherLogMsg = new WeatherLogMsg();

        if (weatherTower.getWeather(coordinates).equals("SUN"))
        {
            LogMessage.addString(LogMessage.formatStringHelicopter(this, weatherLogMsg.getQuote(weatherTower.getWeather(coordinates))));
            coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
        }
        if (weatherTower.getWeather(coordinates).equals("RAIN"))
        {
            LogMessage.addString(LogMessage.formatStringHelicopter(this, weatherLogMsg.getQuote(weatherTower.getWeather(coordinates))));
            coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
        }
        if (weatherTower.getWeather(coordinates).equals("FOG"))
        {
            LogMessage.addString(LogMessage.formatStringHelicopter(this, weatherLogMsg.getQuote(weatherTower.getWeather(coordinates))));
            coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
        }
        if (weatherTower.getWeather(coordinates).equals("SNOW"))
        {
            LogMessage.addString(LogMessage.formatStringHelicopter(this, weatherLogMsg.getQuote(weatherTower.getWeather(coordinates))));
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
        }
        if (coordinates.getHeight() <= 0)
        {
            LogMessage.addString(LogMessage.formatStringTowerHelicopter(this, "OH unregistered from weather tower." +" Longitude: " +coordinates.getLongitude()+" Latitude: " + coordinates.getLatitude() +"Height: "+ coordinates.getHeight()));
            weatherTower.unregister(this);
        }
    }

    /**
     * This method will register a flyable to the weather to
     * @param weatherTower - flyable(Helicopter) to the weather tower
     */
    public void registerTower(WeatherTower weatherTower)
    {
        LogMessage.addString(LogMessage.formatStringTowerHelicopter(this, "registered to weather tower."));
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

}
