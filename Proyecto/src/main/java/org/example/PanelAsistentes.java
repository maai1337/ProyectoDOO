package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAsistentes extends JPanel implements ActionListener{

   //estados
   private enum Estado{
      Numero,
      integrante,
      Completo
   }
   private Estado estadoActual;
   //referencias a otros paneles
   private PantallaInicial pantallaInicial;

   //recordar luego cambiar a frabric
   //spinner para ingresar numero de parti
   private JSpinner cantidad_participantes;

   //casilla de eleccion para equipos
   private JCheckBox equipo;

   //texto informativo
   private JLabel cantidad;
   private JLabel restriccion;

   // boton que ocnfirme para pasar el estado a siguiente pregunta
   private JButton aceptar;
   private JButton guardar;
   private JButton atras;

   //Minimos y maximos
   // ver como solucionar esto ke no funciona
   private int max_participantes;
   private int min_participantes;

   // informacion
   private int cantidad_participante;
   private int tamano_equipo;


   public PanelAsistentes(PantallaInicial pantallaInicial) {
      setBackground(Color.gray);
      setLayout(null);
      this.pantallaInicial = pantallaInicial;
      this.estadoActual = Estado.Numero;


      this.cantidad=new JLabel("Cantidad");
      cantidad.setFont(new Font("Serif", Font.PLAIN, 26));
      cantidad.setBounds(100,80,2000,50);
      cantidad.setForeground(Color.white);

      //esto ve como hacer el spiner y hacer que se limite segun la fase
      SpinnerNumberModel model = new SpinnerNumberModel(4,2,50,1);
      this.cantidad_participantes = new JSpinner(model);
      cantidad_participantes.setBounds(150,140,100,30);
      // en teoria esto es apra accceder al editor del texto del spin
      JComponent jcomp = cantidad_participantes.getEditor();
      JFormattedTextField ftfAsistente = ((JSpinner.DefaultEditor) jcomp).getTextField();
      jcomp.setBackground(Color.white);
      ftfAsistente.setFont(new Font("Serif", Font.PLAIN, 20)) ;

      //jcheckbox
      this.equipo =new JCheckBox();
      equipo.setText("seran equipos");
      equipo.setBounds(150,180,140,30);


      this.restriccion  = new JLabel();
      restriccion.setBounds(100,180,2000,50);

      this.aceptar = new JButton("siguiente");
      aceptar.setBackground(Color.white);
      aceptar.setBounds(350,250,100,30) ;
      aceptar.addActionListener(e ->seCompleto(estadoActual) );

      this.atras=new JButton("atras");
      atras.setBounds(50,250,100,30);
      atras.addActionListener(e ->PanelPasado());

      this.guardar=new JButton("confirmar");
      guardar.setBounds(200,250,100,30);
      guardar.addActionListener(e ->GuardarParti());

      //botones
      add(guardar);
      add(atras);
      add(aceptar);
      add(restriccion);
      add(cantidad);
      add(cantidad_participantes);
      add(equipo);

   }

   //hacer que esto se alique al spiner
   public void setrestriccion(int min, int max) {
      this.min_participantes = min;
      this.max_participantes = max;

      //esto ajusta las restricciones segun lo del panel anterior
      SpinnerNumberModel model = new SpinnerNumberModel(min, min, max, 1);
      cantidad_participantes.setModel(model);

      restriccion.setText("Minimo"+min+"y maximo"+max+"participantes");
      repaint();
      revalidate();
   }

   public void seCompleto(Estado estadoActual) {
      if(estadoActual == Estado.Completo) {
         pantallaInicial.cambiarEstadoActual(4);
      }else{
         JOptionPane.showMessageDialog(null, "Termine de completar la informacion");

      }
   }
   //retrocede el estado

   public void PanelPasado(){
      switch (estadoActual) {
         case Numero:
            pantallaInicial.cambiarEstadoActual(2);
            break;
         case integrante:
            cantidad.setText("ingrese cantidad de aprticipantes");
            estadoActual=Estado.Numero;
            break;
         case Completo:
            if(equipo.isSelected()) {
               estadoActual=Estado.integrante;
            }else {

               estadoActual=Estado.Numero;
            }
      }
      repaint();
      revalidate();
   }


   //cambia los estados segun se a seleccionado
   public void GuardarParti(){
      switch (estadoActual) {
         case Numero:
            cantidad_participante = (int) cantidad_participantes.getValue();
            JOptionPane.showMessageDialog(null, "cantidad de participantyes: " + cantidad_participante);
            if (!equipo.isSelected()){
               estadoActual=Estado.Completo;
            }else{
               cantidad.setText("ingese tamaño de equipos");
               estadoActual=Estado.integrante;
            }
            break;
         case integrante:
            //crea frame donde introducir los datos de los participantes
            frameTipo nuevaVentana = new frameTipo();
            nuevaVentana.setVisible(true);

            tamano_equipo=(int)cantidad_participantes.getValue();
            JOptionPane.showMessageDialog(null,"tamaño de los equipos: "+tamano_equipo);
            estadoActual=Estado.Completo;

      }
      repaint();
      revalidate();
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        int nParticipantes = (int) cantidad_participantes.getValue();
        System.out.println(nParticipantes);
        //aqui se crearar un jframe donde se ingresaran los datos de los participantes de cada equipo

    }

   public int getTamano_equipo(){
      return tamano_equipo;
   }




}
