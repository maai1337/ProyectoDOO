package org.example.Logica;

import java.util.ArrayList;

// Interfaz genérica para observadores de torneo
public interface TorneoObserver {
    void torneoActualizado(TorneoStrategy estrategia);
}