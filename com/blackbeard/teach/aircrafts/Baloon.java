package com.blackbeard.teach.aircrafts;

import com.blackbeard.teach.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    /**
     * This will request the weather from the weatherTower and based on the
     * conditions, it will modify the coordinates
     * If the height of the flyable is 0 (meaning the flight has landed)
     * it will unregister it from the weatherTower
     */

    public void updateConditions() {
        if (weatherTower.getWeather(coordinates).equals("SUN"))
        {
            LogMessage.addString(LogMessage.formatStringBaloon(this, "This is some nice weather we are having. Nice clear blue skies and nice views all over"));
            this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
        }
        if (weatherTower.getWeather(coordinates).equals("RAIN"))
        {
            LogMessage.addString(LogMessage.formatStringBaloon(this, "Captain Teach here! This weather is taking a turn for the worst!"));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
        }
        if (weatherTower.getWeather(coordinates).equals("FOG"))
        {
            LogMessage.addString(LogMessage.formatStringBaloon(this, "Balloon to WeatherTower, the air looks kinda weird"));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);

        }
        if (weatherTower.getWeather(coordinates).equals("SNOW"))
        {
            LogMessage.addString(LogMessage.formatStringBaloon(this, "Balloon going down at a rapid pace I think I'm going to crash"));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
        }

        if (coordinates.getHeight() <= 0)
        {
            LogMessage.addString(LogMessage.formatStringBaloon(this, "Balloon has exploded and unregistered from tower"));
            weatherTower.unregister(this);
        }

    }

    /**
     * Registers this flyable(i.e Balloon to the weatherTower)
     * @param weatherTower - Registers the flyable to instance of weather tower.
     */
    public void registerTower(WeatherTower weatherTower)
    {
        LogMessage.addString(LogMessage.formatStringTowerBaloon(this, "is registered on weather tower"));
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

}
