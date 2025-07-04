package org.example.Logica;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Partido {
    private int id;
    private Participante participanteA;
    private Participante participanteB;
    private String resultado;
    private boolean jugado;
    private LocalDateTime fechaHora;
    private Participante ganador;

    // Para torneos de eliminación
    private Partido siguientePartidoGanador;
    private Partido siguientePartidoPerdedor;

    public Partido getSiguientePartidoPerdedor() {
        return siguientePartidoPerdedor;
    }

    public void setSiguientePartidoPerdedor(Partido siguientePartidoPerdedor) {
        this.siguientePartidoPerdedor = siguientePartidoPerdedor;
    }

    public Partido getSiguientePartidoGanador() {
        return siguientePartidoGanador;
    }

    public void setSiguientePartidoGanador(Partido siguientePartidoGanador) {
        this.siguientePartidoGanador = siguientePartidoGanador;
    }

    public Partido(int id, Participante a, Participante b) {
        this.id = id;
        this.participanteA = a;
        this.participanteB = b;
        this.jugado = false;
        this.fechaHora = LocalDateTime.now();
    }

    public boolean estaJugado() {
        return jugado;
    }

    public int getId() {
        return id;
    }

    public Participante getParticipanteA() {
        return participanteA;
    }

    public Participante getParticipanteB() {
        return participanteB;
    }

    public String getResultado() {
        return resultado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setResultado(String resultado, Participante ganador) {
        this.resultado = resultado;
        this.ganador = ganador;
        this.jugado = true;
    }

    public Participante getGanador() {
        return ganador;
    }

    public Participante getPerdedor() { // Usar en torneos de eliminación, liga no funciona
        if (!jugado) return null;
        if (ganador == participanteA) return participanteB;
        else return participanteA;
    }

    public void setParticipanteB(Participante participanteB) {
        this.participanteB = participanteB;
    }

    public void setParticipanteA(Participante participanteA) {
        this.participanteA = participanteA;
    }

    public void setId(int id) {
        this.id = id;
    }
}
