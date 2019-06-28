package com.blackbeard.teach.aircrafts;

import com.blackbeard.teach.weather.WeatherTower;

public interface Flyable {

    /**
     * Interface methods that will be implemented by classes
     */
    void updateConditions();
    void registerTower(WeatherTower weatherTower);

}
