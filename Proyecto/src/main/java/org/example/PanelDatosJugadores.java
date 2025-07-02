package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JLabel mensaje3;

    private JButton sgte;

    private JTextField campoIngreso;

    public PanelDatosJugadores(frameTipo inicial, int numJu){
        this.setLayout(null);
        this.frameaux = inicial;
        this.estadoActual = EstadoPanelDatosJugadores.nombre;

        int a = 0;
        for(int i=1; i<=numJu; i++) {
            this.mensaje1 = new JLabel("nombre jugador" + i + ": ");
            this.mensaje1.setBounds(10, 10+a, 160, 20);
            this.mensaje1.setHorizontalAlignment(SwingConstants.CENTER);
            // Importante: Debes añadir los componentes al panel para que sean visibles
            this.campoIngreso = new JTextField();
            this.campoIngreso.setBounds(10, 30+a, 160, 20);
            this.campoIngreso.setHorizontalAlignment(SwingConstants.CENTER);

            add(mensaje1);
            add(campoIngreso);
            a+=50;
        }

        this.sgte = new JButton("Guardar");
        this.sgte.setBounds(500, 500, 100, 20);
        sgte.addActionListener(e -> otroEquipo());
        add(sgte);
    }
    public void otroEquipo(){
        String textoIngresado = campoIngreso.getText();
        System.out.println("datos guardado: " + textoIngresado); //solo borra el ultimo, supondre que es por que esta hecho con un ciclo
        campoIngreso.setText("");
        repaint();
        revalidate();
    }
    //falta agregar ingreso para los otras datos, que seran ingresados horizontalmente
    //comentario nada que ver, Bohemian Rhapsody, canción más buena
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
