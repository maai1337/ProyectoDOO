package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAsistentes extends JPanel implements ActionListener{

    //estados
    private enum Estado{
        Numero,
        confirmar_opcion,
        Completo
    }
    private Estado estadoActual;
    //referencias a otros paneles
    private PantallaInicial pantallaInicial;

   //recordar luego cambiar a frabric
   //spinner para ingresar numero de parti
   private JSpinner cantidad_participantes;

   //texto informativo
   private JLabel cantidad;
   private JLabel restriccion;

   // boton que ocnfirme para pasar el estado a siguiente pregunta
   private JButton aceptar;
   private JButton siguiente;
   private JButton atras;

   //Minimos y maximos
    private int max_participantes;
    private int min_participantes;


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
       this.restriccion  = new JLabel("Minimo 2 y maximo 50 participantes");

      restriccion.setBounds(100,180,2000,50);

      this.aceptar = new JButton("Confirmar");
      aceptar.setBackground(Color.white);
      aceptar.setBounds(350,250,100,30) ;
      aceptar.addActionListener(this);

      //botones

       add(aceptar);
       add(restriccion);
       add(cantidad);
       add(cantidad_participantes);
    }

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
    @Override
    public void actionPerformed(ActionEvent e) {
        int nParticipantes = (int) cantidad_participantes.getValue();
        System.out.println(nParticipantes);
        //aqui se crearar un jframe donde se ingresaran los datos de los participantes de cada equipo
        datosJugadores(nParticipantes);
    }
   public void datosJugadores(int n) {

       for(int i=0; i<n; i++) {
           PanelDatosJugadores v = new PanelDatosJugadores(i + 1); //hay que cambiar el numero del contructor, ya que se debe hacer con el numero de equipos no se participantes
       }
   }

}
