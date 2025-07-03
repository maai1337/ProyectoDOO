package org.example.Logica;
import java.util.ArrayList;
import java.util.HashMap;

public class LigaStrategy implements TorneoStrategy {

    private HashMap<Participante, Integer> tablaPuntos = new HashMap<>();
    private ArrayList<Partido> todosLosPartidos = new ArrayList<>();


    @Override
    public ArrayList<Partido> generarPartidos(ArrayList<Participante> participantes) {
        // Inicializa los putnos de cada participante
        for (Participante p : participantes) {
            if (!tablaPuntos.containsKey(p)) {
                tablaPuntos.put(p, 0);
            }
        }

        //Genera los partidos
        ArrayList<Partido> nuevosPartidos = new ArrayList<>();
        int id = todosLosPartidos.size() + 1;
        for (int i = 0; i < participantes.size(); i++) {
            for (int j = i + 1; j < participantes.size(); j++) {
                Partido partido = new Partido(id++, participantes.get(i), participantes.get(j));
                nuevosPartidos.add(partido);
            }
        }

        todosLosPartidos.addAll(nuevosPartidos);

        return nuevosPartidos;
    }

    @Override
    public void actualizarResultados(Partido partido, ArrayList<Participante> participantes, ArrayList<Partido> partidos) {
        // Sumar puntos al ganador
        Participante ganador = partido.getGanador();
        if (ganador != null) {
            tablaPuntos.put(ganador, tablaPuntos.getOrDefault(ganador, 0) + 3);
        }
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

    public int getPuntosParticipante(Participante p) {
        return tablaPuntos.getOrDefault(p, 0);
    }

}