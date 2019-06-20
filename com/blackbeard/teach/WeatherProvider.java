package com.blackbeard.teach;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String weather[];

    private WeatherProvider() {}

    public static WeatherProvider getProvider()
    {
        if (weatherProvider == null)
        {
            weatherProvider = new WeatherProvider();
        }
        //Todo add proper implementation
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        //Todo add proper implementation
        return weather.toString();
    }

}
