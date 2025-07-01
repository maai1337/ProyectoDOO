package org.example.Logica;
import java.util.ArrayList;

public interface TorneoStrategy {
    ArrayList<Partido> generarPartidos(ArrayList<Participante> participantes);
    void actualizarResultados(Partido partido, ArrayList<Participante> participantes, ArrayList<Partido> partidos);
    boolean esFinalizado(ArrayList<Participante> participantes, ArrayList<Partido> partidos);
}
