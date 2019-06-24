package com.blackbeard.teach;
import java.util.Scanner;
import java.io.File;

public class TextReader {
   // private String type;
//    private String name;
//    private int longitude;
//    private int latitude;
//    private int height;

    public void main(String[] args) throws Exception
    {
        WeatherTower weatherTower = new WeatherTower();
        //A try catch would work wonders here
        //need to refactor messy oode
        //Create a file instance
        File file = new File("sources.txt");
        //Create a scanner for the file
        Scanner input = new Scanner(file);
        int noOfSims = input.nextInt();

        Flyable flyable;
        while (input.hasNext())
        {
//            int noOfSims = input.nextInt();
            String type = input.next();
            String name = input.next();
            int longitude = input.nextInt();
            int latitude = input.nextInt();
            int height = input.nextInt();
            AircraftFactory aircraftFactory = new AircraftFactory();
            flyable = aircraftFactory.newAircraft(type, name, longitude, latitude, height);
            flyable.registerTower(weatherTower);
        }

        for (int i = 0; i <= noOfSims; i++)
        {
            weatherTower.changeWeather();
        }
        input.close();
    }
}
