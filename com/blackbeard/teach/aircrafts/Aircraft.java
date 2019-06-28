package com.blackbeard.teach.aircrafts;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

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
