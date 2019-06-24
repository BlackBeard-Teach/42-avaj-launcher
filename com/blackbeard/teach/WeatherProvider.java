package com.blackbeard.teach;

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
     * object can be created
     * @return
     */
    public static WeatherProvider getProvider()
    {
        //Possible implementation change
        if (weatherProvider == null)
        {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    /**
     * The random weather generator
     * Checks weather the height will remain in the range 0-100;
     * @param coordinates
     * @return
     */

    public String getCurrentWeather(Coordinates coordinates)
    {
        //Todo add proper implementation
        int weatherTypes = coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight();
        return weather[weatherTypes % 4];
    }

}
