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
    Toolkit toolkit =  Toolkit.getDefaultToolkit ();
    Dimension dim = toolkit.getScreenSize();
    return dim;
    }
    
    public static void printAlert(){
        Notifications notify = new Notifications();
        Font f = new Font("Tahoma", 0, 16);
        
        JFrame alert = new JFrame("Notification");
        
        JTextArea textAlert = new JTextArea(notify.alertText());
        textAlert.setWrapStyleWord(true);
        textAlert.setLineWrap(true);
        textAlert.setEditable(false);
        textAlert.setPreferredSize(new Dimension(300, 100));
        textAlert.setFont(f);
             
        //Remove this for production
        alert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        alert.setSize(400, 200);
        Dimension position = notify.alertPosition();
        alert.setLocation(position.width-320, 180);
        alert.getContentPane().add(textAlert, BorderLayout.NORTH);
        alert.pack(); 
        alert.setVisible(true);
    }
    
}
