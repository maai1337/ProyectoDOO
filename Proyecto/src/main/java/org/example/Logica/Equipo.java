package org.example.Logica;
import java.util.ArrayList;

public class Equipo<Jugador> extends Participante{
    private ArrayList<Jugador> jugadores;

    /**
     * cada equipo contendra un acantidad de participantes
     * aunque estos tendran menos informacion que los jugadores como tal
     * y se tiene que rellenar en un jframe aparte como lo explicamos en los la idea
     *
     * */

    public Equipo(String nombre) {
        super();
        this.jugadores = new ArrayList<>();
        this.nombre = nombre;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
