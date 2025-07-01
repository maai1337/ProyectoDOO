package org.example.Logica;
import java.util.ArrayList;

public class LigaStrategy implements TorneoStrategy {
    @Override
    public ArrayList<Partido> generarPartidos(ArrayList<Participante> participantes) {
        ArrayList<Partido> partidos = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < participantes.size(); i++) {
            for (int j = i + 1; j < participantes.size(); j++) {
                partidos.add(new Partido(id++, participantes.get(i), participantes.get(j)));
            }
        }
        return partidos;
    }

    @Override
    public void actualizarResultados(Partido partido, ArrayList<Participante> participantes, ArrayList<Partido> partidos) {
        // aqui se sumaran los puntos o se actualizara la informacion de los participantes 
    }

    @Override
    public boolean esFinalizado(ArrayList<Participante> participantes, ArrayList<Partido> partidos) {
        for (Partido p : partidos) {
            if (!p.estaJugado()) {
                return false;
            }
        }
        return true;
    }
}
