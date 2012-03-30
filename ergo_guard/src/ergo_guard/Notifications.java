/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo_guard;

import java.awt.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Alberto
 */
public class Notifications {
    
    private String alertText(){
        //Esta funcion retorna una recomendacion
        String text[] = new String[] {
            "Gira un poco la cabeza sobre. " 
                + " el cuello. Nunca fuerzes el movimiento, "
                + " hazlo suave y durante 5 segundos."
                + " Si duele hazlo más lento.",
            "Al estirar tus brazos, no hagas "
                + "fuerza, hazlo suave y poco a poco.",
            "Al estirar tus piernas , flexiona "
                + "siempre las rodillas.",
                "Respira profundo por la nariz y "
                + "exhala por la boca 3 veces.",
            "Toma 5 o 10 minutos para caminar un poco."};

        Random random = new Random();

        return text[random.nextInt(5)];
    }
    
    private Dimension alertPosition(){
        //Se obtiene las dimenciones de la pantalla
        Toolkit toolkit =  Toolkit.getDefaultToolkit ();
        Dimension dim = toolkit.getScreenSize();
        
        return dim;
    }
    
    public static void printAlert(){
        
        Notifications notify = new Notifications();
        
        //Esta variable se usara para modificar la fuente de los textos
        Font f = new Font("Tahoma", Font.BOLD, 16);
        
        //Se instancia un JFrame que se donde se despliegue la alerta
        JFrame alert = new JFrame("Alerta");
        
        //Se genera el texto que tendra el JFrame
        JTextArea textAlert = new JTextArea(notify.alertText());
        
        //Se el dan ciertas propeidades como que WRAP, Font, Dimension
        textAlert.setBackground(Color.black);
        textAlert.setForeground(Color.white);
        textAlert.setWrapStyleWord(true);
        textAlert.setLineWrap(true);
        textAlert.setEditable(false);
        textAlert.setPreferredSize(new Dimension(300, 100));
        textAlert.setFont(f);
             
        //Remove this for production
        alert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Se instancia la funcion que determina el tamano de pantalla
        Dimension position = notify.alertPosition();
        
        //Se dan propiedades al JFrame
        alert.setSize(400, 200);
        alert.setLocation(position.width-320, 180);
        alert.getContentPane().add(textAlert, BorderLayout.CENTER);
        
      
        
        //Se despliega el JFrame
        alert.pack(); 
        alert.setVisible(true);
    }
    
}
