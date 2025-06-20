package org.example;

import javax.swing.*;
import java.awt.*;

public class PanelAsistentes extends JPanel {
    public PanelAsistentes() {
        setBackground(Color.gray);
        setLayout(null);

       JLabel lblAsistente = new JLabel("Cantidad de participantes:");
       lblAsistente.setFont(new Font("Serif", Font.PLAIN, 26));
       lblAsistente.setBounds(100,80,2000,50);
       lblAsistente.setForeground(Color.white);
       SpinnerNumberModel model = new SpinnerNumberModel(4,2,50,1);
       JSpinner spnAsistente = new JSpinner(model);
       spnAsistente.setBounds(150,140,100,30);
        // en teoria esto es apra accceder al editor del texto del spin
       JComponent jcomp = spnAsistente.getEditor();
       JFormattedTextField ftfAsistente = ((JSpinner.DefaultEditor) jcomp).getTextField();
       jcomp.setBackground(Color.white);
       ftfAsistente.setFont(new Font("Serif", Font.PLAIN, 20)) ;

       JLabel lblAsistente2 = new JLabel("Minimo 2 y maximo 50 participantes");
       lblAsistente2.setBounds(100,180,2000,50);

       JButton confirmar = new JButton("Confirmar");
       confirmar.setBackground(Color.white);
       confirmar.setBounds(350,250,100,30) ;


       add(confirmar);
       add(lblAsistente2);
       add(lblAsistente);
       add(spnAsistente);
    }

}
