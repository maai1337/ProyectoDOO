package org.example.Logica;

import java.util.ArrayList;

public abstract class TorneoObservable implements TorneoStrategy {
    protected ArrayList<TorneoObserver> observers = new ArrayList<>();

    public void addObserver(TorneoObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TorneoObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        for (TorneoObserver observer : observers) {
            observer.torneoActualizado(this);
        }
    }
}