package edu.fatec.ipp002.obersever;

import edu.fatec.ipp002.observer.model.WeatherStation;
import edu.fatec.ipp002.observer.display.*;

public class Main
{
    public static void main(String[] args)
    {
        // Create the subject
        WeatherStation weatherStation = new WeatherStation();

        // Create observers
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        MobileAppDisplay mobileDisplay = new MobileAppDisplay();

        // Register observers with the subject
        weatherStation.registerObserver(currentDisplay);
        weatherStation.registerObserver(statisticsDisplay);
        weatherStation.registerObserver(mobileDisplay);

        // Simulate new weather data
        weatherStation.setMeasurements(25.5f, 65f, 1013.1f);
        weatherStation.setMeasurements(27.2f, 60f, 1012.8f);
        weatherStation.setMeasurements(24.8f, 70f, 1014.0f);
    }
}