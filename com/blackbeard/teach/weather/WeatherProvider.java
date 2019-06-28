package com.blackbeard.teach.weather;

import com.blackbeard.teach.aircrafts.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"SNOW", "RAIN", "SUN", "FOG"};

    /**
     * Private constructor for preventing object creation from outside the
     * class
     * So this can only be obtained via our public methods
     */
    private WeatherProvider() {}

    /**
     * Create object only when weatherProvider is none, so only one
     * object instance can be created
     * @return - Weather Provider instance
     */
    public static WeatherProvider getProvider()
    {
        if (weatherProvider == null)
        {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    /**
     * The random weather generator
     * Checks weather the height will remain in the range 0-100;
     * @param coordinates - Are the coordinates that are passed to get the current weather
     * @return - returns the selected weather type.
     */

    public String getCurrentWeather(Coordinates coordinates)
    {
        int weatherTypes = coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight();
        return weather[weatherTypes % 4];
    }

}
