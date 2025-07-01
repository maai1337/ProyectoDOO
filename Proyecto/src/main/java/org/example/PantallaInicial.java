package org.example;
import javax.swing.*;
import java.awt.*;

public class PantallaInicial extends JPanel {

    //paneles donde se configura
    private PanelAsistentes panelAistentes; //cambiar nombres
    private PanelTipoFase panelTipoFase;
    private PanelDatos panelDatos;
    private PanelDistribucion panelDistribucion;
    private PanelNombre panelNombre;
    private PanelGenerador panelGenerador;

    //estados que habilitaran los paneles
    private enum EstadoPantalla {
        NOMBRE,
        ASISTENTES,
        DATOS,
        FASE,
        DISTRIBUCION,
        GENERADOR,
        COMPLETADO
    }

    private EstadoPantalla estadoActual;


    public PantallaInicial() {
        GridLayout Inicio = new GridLayout(2, 3);
        setLayout(Inicio);

        panelAistentes = new PanelAsistentes(this);
        panelDatos = new PanelDatos();
        panelTipoFase = new PanelTipoFase(this);
        panelDistribucion = new PanelDistribucion();
        panelNombre = new PanelNombre(this);
        panelGenerador = new PanelGenerador();

        add(panelNombre);
        add(panelAistentes);
        add(panelDatos);
        add(panelTipoFase);
        add(panelDistribucion);
        add(panelGenerador);

        cambiarEstadoActual(1);///
    }

    public void cambiarEstadoActual(int a) {

        setPanelEnabled(panelNombre,false);
        setPanelEnabled(panelAistentes,false);
        setPanelEnabled(panelDatos,false);
        setPanelEnabled(panelTipoFase,false);
        setPanelEnabled(panelDistribucion,false);
        setPanelEnabled(panelGenerador,false);

        //activamos el estado en que nos encontremos
        switch (a) {
            case 1:
                setPanelEnabled(panelNombre,true);

                break;
            case 3:
                setPanelEnabled(panelAistentes,true);

                break;
            case 4:
                setPanelEnabled(panelDatos,true);

                break;
            case 2:
                setPanelEnabled(panelTipoFase,true);

                break;
            case 5:
                setPanelEnabled(panelDistribucion,true);

                break;
            case 6:
                setPanelEnabled(panelGenerador,true);

                break;

            case 7:
                JOptionPane.showMessageDialog(null, "ver luego como crear el segundo frame");
                break;
        }
        repaint();
        revalidate();



    }
    //esto desactiva el panel y lo que contenga
    public void setPanelEnabled(JPanel panel, boolean interruptor) {
        panel.setEnabled(interruptor);
        for (Component comp : panel.getComponents()) {
            comp.setEnabled(interruptor);

        }
    }
    // se encargue de mover info de un panel a otro
    public void intel(){
        int min = panelTipoFase.getMinimo();
        int max = panelTipoFase.getMaximo();

        panelAistentes.setrestriccion(min,max);

    }



}
