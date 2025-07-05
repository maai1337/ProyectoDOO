package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelDatosJugadores extends JPanel implements ActionListener {
    JButton siguiente;

    // Define los estados específicos de este panel
    private enum EstadoPanelDatosJugadores {
        nombre,
        completo,
        Rut,
        numero,
    }

    // Aquí es donde almacenarás la referencia a tu ventana principal
    private frameTipo frameaux; // Corregido: Esto coincide con el nombre del campo

    // Esta variable contendrá el estado actual del panel
    private EstadoPanelDatosJugadores estadoActual; // Corregido: Declara este campo

    private JLabel mensaje1;
    private JLabel mensaje2;
    private JLabel mensaje0;

    private JButton sgte;

    private JTextField campoIngreso;
    private JTextField campoIngresoR;

    ArrayList<JTextField> cajaTextoNombre;
    ArrayList<JTextField> cajaTextoRut;

    ArrayList<String> nEquipos;
    ArrayList<String> gName;
    ArrayList<String> gRut;

    public PanelDatosJugadores(frameTipo inicial, int numJu){
        this.setLayout(null);
        this.frameaux = inicial;
        this.estadoActual = EstadoPanelDatosJugadores.nombre;

        cajaTextoNombre = new ArrayList<JTextField>();
        cajaTextoRut = new ArrayList<JTextField>();
        gName = new ArrayList<String>();
        gRut = new ArrayList<String>();


        int a = 0;
        for(int i=1; i<=numJu; i++) {
            this.mensaje1 = new JLabel("nombre jugador" + i + ": ");
            this.mensaje1.setBounds(10, 15+a, 160, 20);
            this.mensaje1.setHorizontalAlignment(SwingConstants.CENTER);
            // Importante: Debes añadir los componentes al panel para que sean visibles
            this.campoIngreso = new JTextField();
            this.campoIngreso.setBounds(10, 35+a, 160, 20);
            this.campoIngreso.setHorizontalAlignment(SwingConstants.CENTER);

            this.mensaje2 = new JLabel("RUT jugador" + i + ": ");
            this.mensaje2.setBounds(300, 15+a, 160, 20);
            this.mensaje2.setHorizontalAlignment(SwingConstants.CENTER);
            // Importante: Debes añadir los componentes al panel para que sean visibles
            this.campoIngresoR = new JTextField();
            this.campoIngresoR.setBounds(300, 35+a, 160, 20);
            this.campoIngresoR.setHorizontalAlignment(SwingConstants.CENTER);


            cajaTextoNombre.add(campoIngreso);
            cajaTextoRut.add(campoIngresoR);

            add(mensaje1);
            add(campoIngreso);
            add(mensaje2);
            add(campoIngresoR);
            a+=50;
        }

        this.sgte = new JButton("Guardar");
        this.sgte.setBounds(500, 500, 100, 20);
        sgte.addActionListener(e -> otroEquipo(numJu));
        add(sgte);
    }
    public void otroEquipo(int numJu){
        String Nomjugador = campoIngreso.getText();
        String RutJugador = campoIngresoR.getText();
        System.out.println("datos guardado: " + Nomjugador); //solo borra el ultimo, supondre que es por que esta hecho con un ciclo
        for(int i=0; i<numJu; i++){
            JTextField n = (JTextField) cajaTextoNombre.get(i);
            gName.add(n.getText());
            JTextField r = (JTextField) cajaTextoRut.get(i);
            gRut.add(r.getText());
            n.setText("");
            r.setText("");
        }
        repaint();
        revalidate();
    }
    //falta agregar ingreso para los otras datos, que seran ingresados horizontalmente
    //comentario nada que ver, Bohemian Rhapsody, canción más buena

    //esto deberia servir para añadir los nombres de los x equipos, pero ahora que lo analizo, deberia ser un jpanel
    //distinto, donde se pueda ingresar los x nombres de todos los equipos
    public void nameEquipo(){
        this.mensaje0 = new JLabel("Nombre del equipo");
        this.mensaje0.setBounds(10, 10, 160, 20);
        this.mensaje0.setHorizontalAlignment(SwingConstants.CENTER);
        // Importante: Debes añadir los componentes al panel para que sean visibles
        this.campoIngreso = new JTextField();
        this.campoIngreso.setBounds(10, 30, 160, 20);
        this.campoIngreso.setHorizontalAlignment(SwingConstants.CENTER);
        this.mensaje1.setHorizontalAlignment(SwingConstants.CENTER);
        add(mensaje0);
        add(campoIngreso);
        }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
