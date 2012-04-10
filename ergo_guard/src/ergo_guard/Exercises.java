/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo_guard;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Alberto
 */
public class Exercises extends JFrame{
    
    Container con = null;
    JPanel panelBgImg;
    
    public Exercises() {

        super("Hagamos ejercicio!!");
        
        // Se crea el array que indica la ruta de los backgrounds
        String text[] = new String[] {
            "imgs/background/zen_1.jpg",
            "imgs/background/zen_2.jpg",
            "imgs/background/zen_3.jpg",
            "imgs/background/zen_4.jpg",
            "imgs/background/zen_5.jpg"};
        
        Random random = new Random();

        //Se decide cual background se utilizara mediante un random
        final String imgBg = text[random.nextInt(5)];;
        
        con = getContentPane();
        
        //Se establece el fondo
        con.setLayout(null);
        ImageIcon imh = new ImageIcon(imgBg);
        setSize(800, 600);
        
        //Se le da forma al fondo
        panelBgImg = new JPanel(){
            
            public void paintComponent(Graphics g){
                Image img = new ImageIcon(imgBg).getImage();
                Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
                setPreferredSize(size);
                setMinimumSize(size);
                setMaximumSize(size);
                setSize(size);
                setLayout(null);
                g.drawImage(img, 0, 0, null);
            } 
        };
        
        //Se agrega al JPanel
        con.add(panelBgImg);
        panelBgImg.setBounds(0, 0, imh.getIconWidth(), imh.getIconHeight());
        
        GridBagLayout layout = new GridBagLayout();
        
        JPanel panelContent = new JPanel(layout);
        
        
//        //Se construye leyenda del panel
        JTextArea label = new JTextArea("Has pasado mucho tiempo en la computadora,\n"
                + "          momento de relajarnos un poco.");
        
        label.setWrapStyleWord(true);
        label.setLineWrap(true);
        label.setEditable(false);
        label.setOpaque(false);
        label.setPreferredSize(new Dimension(380, 40));
        label.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        //SE agrega al JPAnel
        panelContent.add(label);
        
        panelBgImg.add(panelContent);
        
        panelBgImg.setLayout(new FlowLayout(FlowLayout.LEFT, 210, 50));
        
        setResizable(false);
    }
    
    
    private Dimension exercisePosition(){
        //Se obtiene las dimenciones de la pantalla
        Toolkit toolkit =  Toolkit.getDefaultToolkit ();
        Dimension dim = toolkit.getScreenSize();
        
        return dim;
    }

    static void createWindow() {
        
        final Exercises exercise = new Exercises();
        
        //Se le da posicion
        final Dimension position = exercise.exercisePosition();
                
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Se crea la ventana transparente
                Window w = new Exercises();
                w.setVisible(true);
                com.sun.awt.AWTUtilities.setWindowOpacity(w, 0.8f);
                
                w.setLocation((position.width/2)-400, (position.height/2)-300);
            }
        });
        
        JFrame alert = new JFrame("Alerta");
        
        alert.setSize(400, 600);
        alert.setLocation(position.width-320, 180);
        alert.setUndecorated(true);     //Remove border
        alert.pack(); 
        alert.setVisible(true);
    }
}