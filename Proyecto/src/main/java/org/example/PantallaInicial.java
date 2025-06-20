package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaInicial extends JPanel {
    private PanelAsistentes panelAistentes; //cambiar nombres
    private PanelTipoFase panelTipoFase;
    private PanelDatos panelDatos;
    private PanelDistribucion panelDistribucion;
    private PanelNombre panelNombre;
    private PanelGenerador panelGenerador;


    public PantallaInicial(){
        GridLayout Inicio = new GridLayout(2,3);
        setLayout(Inicio);
        panelAistentes=new PanelAsistentes();
        panelDatos=new PanelDatos();
        panelTipoFase=new PanelTipoFase();
        panelDistribucion =new PanelDistribucion();
        panelNombre = new PanelNombre();
        panelGenerador = new PanelGenerador();

        add(panelAistentes);
        add(panelDatos);

        add(panelDistribucion);
        add(panelTipoFase);
        add(panelNombre);
        add(panelGenerador);

    }




}
