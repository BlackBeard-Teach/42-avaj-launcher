package com.blackbeard.teach;

public class JetPlane extends Aircraft implements Flyable {
    WeatherTower weatherTower;

    /**
     * JetPlane constructor with aurguments from the base class Aircraft
     * @param name
     * @param coordinates
     */
    JetPlane(String name, Coordinates coordinates){
        //Flyable jet = new JetPlane(name, coordinates); incorrect
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
        weatherTower.getWeather(coordinates);
//        this.weatherTower.changeWeather();
//        this.weatherTower.conditionsChanged();
        //need to log the msg
        if (coordinates.getHeight() == 0)
        {
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
//        Flyable jet = new JetPlane(name, coordinates);
//        if (coordinates.getHeight() > 0)
//        {
//            weatherTower.register(jet);
//        }
//        else if (coordinates.getHeight() == 0)
//        {
//            weatherTower.unregister(jet);
//        }
        //Need to log the message
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
