package com.blackbeard.teach;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    //Default constructor
    public Aircraft() {}
    protected Aircraft (String name, Coordinates coordinates)
    {

    }

    private long nextId()
    {
        //Todo add proper functionality
        int id = 0;
        return id;
    }
}
