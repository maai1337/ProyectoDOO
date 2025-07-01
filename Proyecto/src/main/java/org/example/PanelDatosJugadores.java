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

    private JTextField campoIngreso;

    public PanelDatosJugadores(frameTipo inicial){
        this.setLayout(null);
        this.frameaux = inicial;
        this.estadoActual = EstadoPanelDatosJugadores.nombre;

        this.mensaje1 = new JLabel("nombre jugador 1");
        this.mensaje1.setBounds(10, 10, 160, 20);
        this.mensaje1.setHorizontalAlignment(SwingConstants.CENTER);
        // Importante: Debes añadir los componentes al panel para que sean visibles
        this.add(mensaje1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
