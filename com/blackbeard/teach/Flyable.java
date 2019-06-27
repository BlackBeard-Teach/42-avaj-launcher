package com.blackbeard.teach;

public interface Flyable {

    /**
     * Interface methods that will be implemented by classes
     */
    void updateConditions();
    void registerTower(WeatherTower weatherTower);

}
