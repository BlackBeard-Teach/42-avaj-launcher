package com.blackbeard.teach;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class WeatherTower extends Tower
{
    /**
     * This will request the current weather
     * @param coordinates - Gets the current weather 
     * @return - returns the current weather.
     */
    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    /**
     * This notifies the weather tower that the weather conditions have changed
     */
    void changeWeather()
    {
        this.conditionsChanged();
    }

}
