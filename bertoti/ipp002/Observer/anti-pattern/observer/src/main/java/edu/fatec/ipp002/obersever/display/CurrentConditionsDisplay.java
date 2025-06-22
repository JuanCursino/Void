package edu.fatec.ipp002.observer.display;

import edu.fatec.ipp002.observer.observer.Observer;

public class CurrentConditionsDisplay implements Observer
{
    public void update(float temp, float humidity, float pressure)
    {
        System.out.println("CurrentConditionsDisplay::update | Current temp: " + temp + "°C");
    }
}
