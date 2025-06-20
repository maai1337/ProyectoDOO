package org.example;

import javax.swing.*;
import java.awt.*;

public class PanelAsistentes extends JPanel {

   //recordar luego cambiar a frabric
   //spinner para ingresar numero de parti
   private JSpinner cantidad_participantes;

   //texto informativo
   private JLabel cantidad;
   private JLabel restriccion;

   // boton que ocnfirme para pasar el estado a siguiente pregunta
   private JButton aceptar;


   public PanelAsistentes() {
        setBackground(Color.gray);
        setLayout(null);

       this.cantidad=new JLabel("Cantidad");
       cantidad.setFont(new Font("Serif", Font.PLAIN, 26));
       cantidad.setBounds(100,80,2000,50);
       cantidad.setForeground(Color.white);
       SpinnerNumberModel model = new SpinnerNumberModel(4,2,50,1);
       this.cantidad_participantes = new JSpinner(model);
       cantidad_participantes.setBounds(150,140,100,30);
        // en teoria esto es apra accceder al editor del texto del spin
       JComponent jcomp = cantidad_participantes.getEditor();
       JFormattedTextField ftfAsistente = ((JSpinner.DefaultEditor) jcomp).getTextField();
       jcomp.setBackground(Color.white);
       ftfAsistente.setFont(new Font("Serif", Font.PLAIN, 20)) ;
       this.restriccion  = new JLabel("Minimo 2 y maximo 50 participantes");

      restriccion.setBounds(100,180,2000,50);

       this.aceptar = new JButton("Confirmar");
      aceptar.setBackground(Color.white);
      aceptar.setBounds(350,250,100,30) ;


       add(aceptar);
       add(restriccion);
       add(cantidad);
       add(cantidad_participantes);
    }

}
