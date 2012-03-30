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
    String text[] = new String[] {"Gira un poco la cabeza sobre el cuello. Nunca fuerzes el movimiento, hazlo suave y"
    + " durante 5 segundos. Si sientes dolor, detente y hazlo aún más suave y lento.",
    "Al estirar tus brazos y mover tus hombros, hazlo suave y sin presionar "
    + "tus músculos. Si sientes dolor, detente y hazlo aún más suave y lento.",
    "Al estirar tus piernas trata siempre de flexionar tus rodillas, para evitar"
    + " posibles lesiones por lo frio que se encuentra el músculo.",
    "Respira profundamente 3 veces lentamente. Inhala por la nariz y exhala "
    + "por la boca, ayudará a relajarte.",
    "Toma 5 o 10 minutos para despejarte de las actividades que realizas y "
    + "caminar un poco."};
    
    Random random = new Random();
    
    return text[random.nextInt(5)];
    }
    
    public static void printAlert(){
        Notifications notify = new Notifications();
        
        JFrame alert = new JFrame("Notification");
        
        alert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel textLabel = new JLabel(notify.alertText(),
                 SwingConstants.CENTER); 
        textLabel.setPreferredSize(new Dimension(30, 10));
         
        alert.getContentPane().add(textLabel, BorderLayout.CENTER);
        
        alert.pack(); 
        
        alert.setVisible(true);
    }
    
}
