package com.blackbeard.teach;

import java.io.*;

public class Simulator {
    public static void main(String[] args)
    {
        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory aircraftFactory = new AircraftFactory();

        try
        {
            File file = new File(args[0]);

            BufferedReader input = new BufferedReader(new FileReader(file));

            int simulations = ValidateNumber(input.readLine(), "NoOfSimulations");

            String line;
            String[] splitLine;
            Flyable flyable;

            while ((line = input.readLine()) != null)
            {
                splitLine = line.split(" ");
                flyable = aircraftFactory.newAircraft(splitLine[0], splitLine[1], ValidateNumber(splitLine[2], "Longitude"),ValidateNumber(splitLine[3], "Latitude"), ValidateNumber(splitLine[4], "Height"));
                flyable.registerTower(weatherTower);
            }

            for (int i = 0; i <= simulations; i++)
            {
                weatherTower.changeWeather();
                LogMessage.printInTxt();
            }

            input.close();
        } catch (IllegalNumber | ArrayIndexOutOfBoundsException | IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param line - the line that will be validated if its a valid number
     * @param name - Name of the number
     * @return - Return the number if its a valid number
     * @throws - IllegalNumber
     */
    private static int ValidateNumber(String line, String name) throws IllegalNumber {
        int i;
        try{
            i = Integer.parseInt(line);
            if (i < 0){
                throw new IllegalNumber("Invalid number provided: " + name + " should be a positive number");
            }
        } catch (NumberFormatException e){
            throw new IllegalNumber("Invalid number provided: " + name + " should be a number");
        }
        return i;
    }
}
