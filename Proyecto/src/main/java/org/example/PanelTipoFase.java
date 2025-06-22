package org.example;
import javax.swing.*;
import java.awt.*;

public class PanelTipoFase extends JPanel {

    // botones de solo una eleccion
    private JRadioButton opcion1;
    private JRadioButton opcion2;
    private JRadioButton opcion3;

    //mensajes
    private JLabel mensaje1;
    private JLabel mensaje2;
    private JLabel mensaje3;

    //boton confirmacion
    private JButton confirmar;


    public PanelTipoFase() {
        setBackground(Color.ORANGE );
        setLayout(null);

        this.opcion1 = new JRadioButton("Fase de grupos");
        opcion1.setFont(new Font("Arial", Font.BOLD, 20));
        opcion1.setBackground(Color.orange );
        opcion1.setBounds(20,40,800,40);

        this.mensaje1 = new JLabel("El limite de participates es de 50 y el minimo es de 9");
        mensaje1.setFont(new Font("Arial",Font.BOLD,12));
        mensaje1.setBounds(20,60,800,60);

        this.opcion2 = new JRadioButton("Fase de eliminatoria");
        opcion2.setFont(new Font("Arial", Font.BOLD, 20));
        opcion2.setBackground(Color.orange );
        opcion2.setBounds(20,130,800,40);

        this.mensaje2 = new JLabel("El limite de participates es de 8 y el minimo es de 4");
        mensaje2.setFont(new Font("Arial",Font.BOLD,12));
        mensaje2.setBounds(20,150,800,60);

        this.opcion3 = new JRadioButton("Fase de puntos");
        opcion3.setFont(new Font("Arial", Font.BOLD, 20));
        // tabla de clasificacion  ej: los de la formula 1
        opcion3.setBackground(Color.orange );
        opcion3.setBounds(20,220,800,40);

        this.mensaje3 = new JLabel("El limite de puntos es de 25 y el minimo es de 9");
        mensaje3.setFont(new Font("Arial",Font.BOLD,12));
        mensaje3.setBounds(20,240,800,60);

        this.confirmar = new JButton("Confirmar");
        confirmar.setFont(new Font("Arial", Font.BOLD, 12));
        confirmar.setBounds(350,300,100,30);

        //agrupar botones
        ButtonGroup opciones = new ButtonGroup();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        add(opcion1);
        add(opcion2);
        add(opcion3);

        add(mensaje1);
        add(mensaje2);
        add(mensaje3);

        add(confirmar);
    }



}
