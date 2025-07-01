package org.example.Paneles;
import javax.swing.*;
import java.awt.*;

public class PanelTipoFase extends JPanel {

    //referencia a la clase principal
    private PantallaInicial pantallaInicial;

    // botones de solo una eleccion
    private JRadioButton opcion1;
    private JRadioButton opcion2;
    private JRadioButton opcion3;

    //mensajes
    private JLabel mensaje1;
    private JLabel mensaje2;
    private JLabel mensaje3;

    //botones
    private JButton confirmar;
    private JButton siguiente;
    private JButton anterior;

    //buffer de opcion
    private int minimo;
    private int maximo;

    //estados
    private enum Estado{
        Opcion,
        confirmar_opcion,
        Completo
    }
    private Estado estadoActual;


    public PanelTipoFase(PantallaInicial pantallaInicial) {
        setBackground(Color.ORANGE );
        setLayout(null);
        this.pantallaInicial=pantallaInicial;
        this.estadoActual = Estado.Opcion;

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

        this.siguiente = new JButton("Siguiente");
        siguiente.setFont(new Font("Arial", Font.BOLD, 12));
        siguiente.setBounds(350,180,100,30);
        siguiente.addActionListener(e -> {seCompleto(estadoActual);});

        this.anterior = new JButton("Anterior");
        anterior.setFont(new Font("Arial", Font.BOLD, 12));
        anterior.setBounds(350,280,100,30);
        anterior.addActionListener(e -> {PanelPasado();});

        this.confirmar = new JButton("guardar");
        confirmar.setFont(new Font("Arial", Font.BOLD, 12));
        confirmar.setBounds(350,80,100,30);
        confirmar.addActionListener(e -> {seleccionarOpcion();});

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
        add(anterior);
        add(siguiente);

    }

    public void seCompleto(Estado estadoActual) {
        if(estadoActual == Estado.Completo) {
            pantallaInicial.cambiarEstadoActual(3);
        }else{
            JOptionPane.showMessageDialog(null, "Termine de completar la informacion");

        }
    }

    public void PanelPasado(){
        estadoActual = Estado.Opcion;
        pantallaInicial.cambiarEstadoActual(1);

    }

    public void seleccionarOpcion(){
        if (opcion1.isSelected()) {
            minimo = 9;
            maximo = 50;
            estadoActual = Estado.Completo;

        } else if (opcion2.isSelected()) {
            minimo = 4;
            maximo = 8;
            estadoActual = Estado.Completo;
        } else if (opcion3.isSelected()) {
            minimo = 9;
            maximo = 25;
            estadoActual = Estado.Completo;
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una opción antes de continuar");
        }
    }

    public int getMinimo() {
        return minimo;
    }
    public int getMaximo() {
        return maximo;
    }

}
