package com.blackbeard.teach.aircrafts;

import com.blackbeard.teach.utils.WeatherLogMsg;
import com.blackbeard.teach.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    /**
     * JetPlane constructor with arguments from the base class Aircraft
     * @param name - Gets the name passed onto it from the super class
     * @param coordinates - Gets coordinates from the super class(i.e Height, Latitude, Longitude)
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
        WeatherLogMsg weatherLogMsg = new WeatherLogMsg();
        if (weatherTower.getWeather(coordinates).equals("SUN"))
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, weatherLogMsg.getQuote(weatherTower.getWeather(coordinates))));
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
        }
        if (weatherTower.getWeather(coordinates).equals("RAIN"))
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, weatherLogMsg.getQuote(weatherTower.getWeather(coordinates))));
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
        }
        if (weatherTower.getWeather(coordinates).equals("FOG"))
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, weatherLogMsg.getQuote(weatherTower.getWeather(coordinates))));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());

        }
        if (weatherTower.getWeather(coordinates).equals("SNOW"))
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, weatherLogMsg.getQuote(weatherTower.getWeather(coordinates))));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
        }

        if (coordinates.getHeight() <= 0)
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, "is crash landing brace yourself! MAYDAY!MAYDAY! Unregistered from tower"+" Longitude: " +coordinates.getLongitude()+" Latitude: " + coordinates.getLatitude() +"Height: "+ coordinates.getHeight()));
            weatherTower.unregister(this);
        }

    }

    /**
     * This with register this flyable(JetPlane) to the weather tower and log the message to a log file
     * @param weatherTower - registers this flyable(JetPlane) to the weather tower
     */
    public void registerTower(WeatherTower weatherTower)
    {
        LogMessage.addString(LogMessage.formatStringTowerJetPlane(this, "registered to weather."));
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
