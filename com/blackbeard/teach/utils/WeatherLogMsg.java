package com.blackbeard.teach.utils;

import java.util.Random;

public class WeatherLogMsg {
    String[] sun = new String[]{
            "We have lift-off.",
            "Let's enjoy the good weather and take some pics.",
            "This is hot.",
            "Air traffic control, it smells like something is burning in here."
    };
    String[] fog = new String[]{
            "Instrument flying is an unnatural act probably punishable by God.",
            "Am I still going in the right direction?.",
            "For years politicians have promised the Moon. I’m the first one to be able to deliver it.",
            "Alright, I will need bigger wipers and a fog remover(or something along those lines)"
    };
    String[] rain = new String[]{
            "Its raining cats and dogs over here.",
            "Damn you rain! Atleast I have a rain coat.",
            "The brakes are not working, the gods are crying!",
            "Now time for a power slide!! Reason I so of like rain."
    };
    String[] snow = new String[]{
            "My rotor is going to freeze!",
            "He who dares wins(Stupid of me to try flying in these conditions).",
            "I shall go down in history, full speed ahead, the faster I go, the less likely I am to freeze",
            "I don't like flying and the sky is freezing. "
    };

    /**
     *
     * This takes weather and returns a random weather quote in a form of string
     * @param weather
     * @return
     */
    public String getQuote(String weather) {
        String quote = null;
        Random indexer = new Random();
        int index = indexer.nextInt(4);
        if (weather.equals("SUN"))
            quote = this.sun[index];
        else if (weather.equals("RAIN"))
            quote = this.rain[index];
        else if (weather.equals("FOG"))
            quote = this.fog[index];
        else if (weather.equals("SNOW"))
            quote = this.snow[index];

        return quote;
    }
}
