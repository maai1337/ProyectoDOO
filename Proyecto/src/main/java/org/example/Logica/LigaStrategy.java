package org.example.Logica;
import java.util.ArrayList;
import java.util.HashMap;

public class LigaStrategy extends TorneoObservable implements TorneoStrategy {

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
        notifyObservers(); // Notificar después de generar partidos

        return nuevosPartidos;
    }

    @Override
    public void actualizarResultados(Partido partido, ArrayList<Participante> participantes, ArrayList<Partido> partidos) {
        if (partido.estaJugado()) {
            Participante ganador = partido.getGanador();

            if (ganador != null) {
                // Victoria: 3 puntos al ganador
                tablaPuntos.put(ganador, tablaPuntos.getOrDefault(ganador, 0) + 3);
            } else { // ganador = null si el partido terminó en empate
                // Empate: 1 punto a cada participante
                Participante participanteA = partido.getParticipanteA();
                Participante participanteB = partido.getParticipanteB();

                tablaPuntos.put(participanteA, tablaPuntos.getOrDefault(participanteA, 0) + 1);
                tablaPuntos.put(participanteB, tablaPuntos.getOrDefault(participanteB, 0) + 1);
            }

            notifyObservers(); // Notificar después de actualizar resultados
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

    // Método para que los observadores puedan acceder a la tabla de puntos
    public HashMap<Participante, Integer> getTablaPuntos() {
        return tablaPuntos;
    }

    // Método para que los observadores puedan acceder a todos los partidos
    public ArrayList<Partido> getTodosLosPartidos() {
        return todosLosPartidos;
    }
}