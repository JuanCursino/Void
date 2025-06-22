package edu.fatec.ipp002.observer.model;

import java.util.ArrayList;
import java.util.List;
import edu.fatec.ipp002.observer.observer.Observer;
import edu.fatec.ipp002.observer.observer.Subject;

public class WeatherStation implements Subject
{
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    public void registerObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    public void setMeasurements(float temp, float humidity, float pressure)
    {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    public void notifyObservers()
    {
        for (Observer o : observers)
        {
            o.update(temperature, humidity, pressure);
        }
    }
}
