package com.blackbeard.teach.weather;

import com.blackbeard.teach.aircrafts.Flyable;

import java.util.ArrayList;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable)
    {
        if (observers.contains(flyable))
            return;
        observers.add(flyable);
    }

    /**
     * UnRegisters the flyable if it exists
     * @param flyable - Is the flyable that will be unregistered from the weather tower
     */
    public void unregister(Flyable flyable)
    {
        observers.remove(flyable);
    }

    protected void conditionsChanged()
    {
        for (int i = 0; i < observers.size(); i++)
        {
            observers.get(i).updateConditions();
        }
    }

}
