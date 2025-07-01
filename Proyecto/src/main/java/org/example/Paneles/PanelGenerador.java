package org.example.Paneles;

import javax.swing.*;
import java.awt.*;

public class PanelGenerador extends JPanel {
    /**
    * presionar el boton generar genera un nuevo jframe que muestre la distribucion del torneo
    * lo que deberia cerrar este jframe pero primero hace la pregunta de si esta seguro de
     * continuar. y tambien aca deberia estar el creador del siguiente frame
    */
    //boton
    private JButton confirmar;

    public PanelGenerador() {
        setLayout(null);
        setBackground(Color.darkGray);

        this.confirmar = new JButton("Generar");
        confirmar.setBackground(Color.green);
        confirmar.setBounds(125, 100, 250, 200);


        add(confirmar);
    }
}
