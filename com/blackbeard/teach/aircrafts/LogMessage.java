package com.blackbeard.teach.aircrafts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LogMessage {

    private static List<String> strings = new ArrayList<>();

    public static String formatStringTowerBaloon(Baloon flyable, String message) {
        return ("Tower says: " + flyable.getClass().getTypeName().substring(31) + "#" + flyable.name + "(" + flyable.id + ") " + message);
    }

    public static String formatStringTowerJetPlane(JetPlane flyable, String message) {
        return ("Tower says: " + flyable.getClass().getTypeName().substring(31) + "#" + flyable.name + "(" + flyable.id + ") " + message);
    }

    public static String formatStringTowerHelicopter(Helicopter flyable, String message) {
        return ("Tower says: " + flyable.getClass().getTypeName().substring(31) + "#" + flyable.name + "(" + flyable.id + ") " + message);
    }

    public static String formatStringBaloon(Baloon flyable, String message) {
        return (flyable.getClass().getTypeName().substring(31) + "#" + flyable.name + "(" + flyable.id + "): " + message);
    }

    public static String formatStringJetPlane(JetPlane flyable, String message) {
        return (flyable.getClass().getTypeName().substring(31) + "#" + flyable.name + "(" + flyable.id + "): " + message);
    }

    public static String formatStringHelicopter(Helicopter flyable, String message) {
        return (flyable.getClass().getTypeName().substring(31)+ "#" + flyable.name + "(" + flyable.id + "): " + message);
    }

    public static void addString(String newString) {
        strings.add(newString);
    }

    public static void printInTxt() {
        try {
            PrintWriter writer = new PrintWriter("simulation.txt", "UTF-8");
            for (int i = 0; i < strings.size(); i++)
                writer.println(strings.get(i));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
