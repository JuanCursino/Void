package edu.fatec.ipp002.observer.display;

import edu.fatec.ipp002.observer.observer.Observer;

public class MobileAppDisplay implements Observer
{
    public void update(float temp, float humidity, float pressure)
    {
        System.out.println("MobileAppDisplay::update | Current temp: " + temp + "°C");
    }
}
