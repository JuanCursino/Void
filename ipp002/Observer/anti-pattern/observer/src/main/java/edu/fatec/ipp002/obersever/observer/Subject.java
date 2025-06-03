package edu.fatec.ipp002.observer.observer;

public interface Subject
{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
