package org.example;
import javax.swing.*;
import java.awt.*;

public class PanelTipoFase extends JPanel {

    // botones de solo una eleccion
    private JRadioButton opcion1;
    private JRadioButton opcion2;
    private JRadioButton opcion3;


    public PanelTipoFase() {
        setBackground(Color.ORANGE );
        setLayout(null);

        this.opcion1 = new JRadioButton("Fase de grupos");
        opcion1.setBackground(Color.orange );
        opcion1.setBounds(20,40,800,40);
        this.opcion2 = new JRadioButton("Fase de eliminatoria");
        opcion2.setBackground(Color.orange );
        opcion2.setBounds(20,70,800,40);
        this.opcion3 = new JRadioButton("Fase de puntos");
        // tabla de clasificacion  ej: los de la formula 1
        opcion3.setBackground(Color.orange );
        opcion3.setBounds(20,100,800,40);

        //agrupar botones
        ButtonGroup opciones = new ButtonGroup();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        add(opcion1);
        add(opcion2);
        add(opcion3);
    }
}
