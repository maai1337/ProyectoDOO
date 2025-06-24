package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDatosJugadores extends JFrame implements ActionListener {
    JButton sgte;
    private static int n;
    public PanelDatosJugadores(int n) {
        setTitle("Equipo" + n);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.sgte = new JButton("siguiente");
        setVisible(true);
        sgte.setBackground(Color.white);
        sgte.setBounds(350,250,100,30) ;
        sgte.addActionListener(this);
        add(sgte);
        n = 0;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}