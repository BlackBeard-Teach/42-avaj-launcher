package com.blackbeard.teach;

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
        weatherTower.getWeather(coordinates);

        if (coordinates.getHeight() == 0)
        {
            weatherTower.unregister(this);
        }
    }

    /**
     * Registers this flyable(i.e Balloon to the weatherTower
     * @param weatherTower
     */
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

}
