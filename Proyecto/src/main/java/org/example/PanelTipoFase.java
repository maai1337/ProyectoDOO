package org.example;
import javax.swing.*;
import java.awt.*;

public class PanelTipoFase extends JPanel {
    public PanelTipoFase() {
        setBackground(Color.ORANGE );
        setLayout(null);

        JRadioButton opcion1 = new JRadioButton("Fase de grupos");
        opcion1.setBackground(Color.orange );
        opcion1.setBounds(20,40,800,40);
        JRadioButton opcion2 = new JRadioButton("Fase de eliminatoria");
        opcion2.setBackground(Color.orange );
        opcion2.setBounds(20,70,800,40);

        add(opcion1);
        add(opcion2);
    }
}
