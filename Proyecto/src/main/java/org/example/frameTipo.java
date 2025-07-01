package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frameTipo extends JFrame{
    private PanelDatosJugadores panelDatosJugadores;
    private static int n;
    public frameTipo() {
        panelDatosJugadores = new PanelDatosJugadores(this);
        setTitle("Datos equipos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        add(panelDatosJugadores);
    }
}