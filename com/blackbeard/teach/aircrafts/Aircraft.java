package com.blackbeard.teach.aircrafts;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    /**
     * This constructor assigns the specific name and coordinates to the aircraft.
     * @param name - name of aircraft(i.e name-B1)
     * @param coordinates- aircraft coordinates(i.e coordinates-Lat:10-Long:12-Height:21)
     */
    protected Aircraft (String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        id = nextId();
    }

    /**
     * This generates a unique ID that will be assigned to the flight
     * @return - idCounter incremented.
     */
    private long nextId()
    {
        return idCounter++;
    }

}
