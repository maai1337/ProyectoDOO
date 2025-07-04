package org.example.Logica;

import java.util.ArrayList;

public class EliminacionSimpleStrategy extends TorneoObservable implements TorneoStrategy {
    // Para organizar los partidos por rondas
    private ArrayList<ArrayList<Partido>> rondas;

    public EliminacionSimpleStrategy() {
        this.rondas = new ArrayList<>();
    }

    @Override
    public ArrayList<Partido> generarPartidos(ArrayList<Participante> participantes) {
        ArrayList<Partido> todosPartidos = new ArrayList<>();
        int cantParticipantes = participantes.size();

        // Asumiendo que cantParticipantes es potencia de 2
        int numRondas = (int) (Math.log(cantParticipantes) / Math.log(2));

        // Limpiar rondas existentes
        rondas.clear();

        // Primera ronda con los participantes iniciales
        ArrayList<Partido> primeraRonda = new ArrayList<>();
        int idPartido = 1;

        for (int i = 0; i < cantParticipantes; i += 2) {
            Partido partido = new Partido(idPartido++, participantes.get(i), participantes.get(i + 1));
            primeraRonda.add(partido);
            todosPartidos.add(partido);
        }

        rondas.add(primeraRonda);

        // Generar rondas siguientes (corregido)
        int partidosPorRonda = cantParticipantes / 2;
        for (int r = 1; r < numRondas; r++) {
            ArrayList<Partido> rondaActual = new ArrayList<>();
            partidosPorRonda = partidosPorRonda / 2;

            for (int i = 0; i < partidosPorRonda; i++) {
                Partido partido = new Partido(idPartido++, null, null);
                rondaActual.add(partido);
                todosPartidos.add(partido);
            }

            rondas.add(rondaActual);
        }

        // Conectar partidos entre rondas
        for (int r = 0; r < numRondas - 1; r++) {
            ArrayList<Partido> rondaActual = rondas.get(r);
            ArrayList<Partido> siguienteRonda = rondas.get(r + 1);

            for (int i = 0; i < rondaActual.size(); i++) {
                Partido actual = rondaActual.get(i);
                Partido siguiente = siguienteRonda.get(i / 2);
                actual.setSiguientePartidoGanador(siguiente);
            }
        }

        notifyObservers();
        return todosPartidos;
    }

    @Override
    public void actualizarResultados(Partido partido, ArrayList<Participante> participantes, ArrayList<Partido> partidos) {
        if (!partido.estaJugado() || partido.getGanador() == null) {
            return;
        }

        Participante ganador = partido.getGanador();
        Partido siguientePartido = partido.getSiguientePartidoGanador();

        if (siguientePartido != null) {
            // Colocar al ganador en el siguiente partido
            if (siguientePartido.getParticipanteA() == null) {
                siguientePartido.setParticipanteA(ganador);
            } else {
                siguientePartido.setParticipanteB(ganador);
            }
        }

        notifyObservers();
    }

    @Override
    public boolean esFinalizado(ArrayList<Participante> participantes, ArrayList<Partido> partidos) {
        // El torneo finaliza cuando el partido final está jugado
        if (!rondas.isEmpty()) {
            ArrayList<Partido> ultimaRonda = rondas.get(rondas.size() - 1);
            if (ultimaRonda.size() == 1) {
                return ultimaRonda.get(0).estaJugado();
            }
        }
        return false;
    }

    // Métodos adicionales para facilitar la visualización
    public ArrayList<ArrayList<Partido>> getRondas() {
        return rondas;
    }

    public int getNumeroRondas() {
        return rondas.size();
    }

    public ArrayList<Partido> getPartidosRonda(int numRonda) {
        if (numRonda >= 0 && numRonda < rondas.size()) {
            return rondas.get(numRonda);
        }
        return new ArrayList<>();
    }
}