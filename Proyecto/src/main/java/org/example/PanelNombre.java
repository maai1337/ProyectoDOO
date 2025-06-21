package org.example;
import javax.swing.*;
public class PanelNombre extends JPanel {

    //estado del panel
    private enum Estado{
        Ingreso_nombre,
        Ingreso_tipo,
        Completo
    }
    private Estado estadoActual;


    //Mensajes del sistema
    private JLabel mensaje;


    //ingreso de string
    private JTextField campoIngreso;


    //boton para cambio de fase
    private JButton guardar;
    private JButton siguiente;
    private JButton cancelar;

    //datos para creacion del organizador
    private String nombre_event;
    private String tipo_torneo_event;

    public PanelNombre() {
        this.setLayout(null);
        this.estadoActual = Estado.Ingreso_nombre;
        this.mensaje = new JLabel("Ingrese nombre del torneo");
        this.mensaje.setBounds(10, 10, 160, 20);
        this.mensaje.setHorizontalAlignment(SwingConstants.CENTER);



        this.campoIngreso = new JTextField();
        this.campoIngreso.setBounds(40, 40, 100, 20);
        this.campoIngreso.setHorizontalAlignment(SwingConstants.CENTER);


        this.guardar = new JButton("Guardar");
        this.guardar.setBounds(200, 200, 100, 20);
        guardar.addActionListener(e -> avanzar());


        this.siguiente = new JButton("Siguiente");
        this.siguiente.setBounds(350, 350, 100, 20);

        this.cancelar = new JButton("Cancelar");
        this.cancelar.setBounds(20, 200, 100, 20);
        cancelar.addActionListener(e -> retroseder());

        add(mensaje);
        add(campoIngreso);

        add(guardar);
        add(siguiente);
        add(cancelar);


    }

    private void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
        switch (estadoActual) {
            case Ingreso_nombre:
                mensaje.setText("Ingreso el nombre del torneo");
                campoIngreso.setText("");
                break;

            case Ingreso_tipo:
                this.nombre_event = campoIngreso.getText();
                mensaje.setText("Ingreso el tipo del torneo");
                campoIngreso.setText("");
                break;
            case Completo:
                this.tipo_torneo_event = campoIngreso.getText();
                mensaje.setText("Se han guardado los datos");
                campoIngreso.setEditable(false);
                guardar.setEnabled(false);
                break;

        }
        repaint();
        revalidate();
    }

    //avanza el estado
    public void avanzar() {
        switch (estadoActual) {
            case Ingreso_nombre:
                if(!campoIngreso.getText().isEmpty()) {
                    setEstadoActual(Estado.Ingreso_tipo);
                }else {
                    //esto muestra un cuadro mostrando este mensaje
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre del torneo");
                }
                break;
            case Ingreso_tipo:
                if(!campoIngreso.getText().isEmpty()) {
                    setEstadoActual(Estado.Completo);
                }else {
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre del torneo");
                }
                break;
        }

    }

    //retoseder estado
    public void retroseder() {
        switch (estadoActual) {
            case Ingreso_tipo:
                setEstadoActual(Estado.Ingreso_nombre);
                break;
            case Completo:
                setEstadoActual(Estado.Ingreso_tipo);
                campoIngreso.setEditable(true);
                guardar.setEnabled(true);
                break;
            case Ingreso_nombre:
                campoIngreso.setText("");
                break;
        }
        repaint();
        revalidate();
    }

    public String getNombre_event() {
        return nombre_event;
    }
    public String getTipo_torneo_event() {
        return tipo_torneo_event;
    }


}
