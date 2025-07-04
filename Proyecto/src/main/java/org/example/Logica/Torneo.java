package org.example.Logica;

import java.util.ArrayList;

public class Torneo {
    private String nombre;
    private ArrayList<Participante> participantes;
    private ArrayList<Partido> partidos;
    private TorneoStrategy estrategia;

    public Torneo(String nombre, TorneoStrategy estrategia) {
        this.nombre = nombre;
        this.estrategia = estrategia;
        this.participantes = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public void agregarParticipante(Participante p) {
        participantes.add(p);
    }

    public void iniciarTorneo() {
        partidos = estrategia.generarPartidos(participantes);
    }

    public void registrarResultado(Partido partido, String resultado, Participante ganador) {
        partido.setResultado(resultado, ganador);
        estrategia.actualizarResultados(partido, participantes, partidos);
    }

    public boolean torneoFinalizado() {
        return estrategia.esFinalizado(participantes, partidos);
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }
}
