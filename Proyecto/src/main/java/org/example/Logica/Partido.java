package org.example.Logica;
import java.time.LocalDateTime;

public class Partido {
    private int id;
    private Participante participanteA;
    private Participante participanteB;
    private String resultado;
    private boolean jugado;
    private LocalDateTime fechaHora;

    public Partido(int id, Participante a, Participante b) {
        this.id = id;
        this.participanteA = a;
        this.participanteB = b;
        this.jugado = false;
        this.fechaHora = LocalDateTime.now();
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
        this.jugado = true;
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

    public boolean isJugado() {
        return jugado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
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
