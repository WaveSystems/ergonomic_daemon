/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo_guard;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Alberto
 */
public class Exercises extends JFrame {
    
    Container con = null;
    JPanel panelBgImg;
    
    public Exercises() {

        super("Hagamos ejercicio!!");

        con = getContentPane();
        
        con.setLayout(null);
        ImageIcon imh = new ImageIcon("imgs/zen_1.jpg");
        setSize(800, 600);
        
        panelBgImg = new JPanel()
        {
            public void paintComponent(Graphics g) 
            {
                Image img = new ImageIcon("imgs/zen_1.jpg").getImage();
                Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
                setPreferredSize(size);
                setMinimumSize(size);
                setMaximumSize(size);
                setSize(size);
                setLayout(null);
                g.drawImage(img, 0, 0, null);
            } 
        };
        
        con.add(panelBgImg);
        panelBgImg.setBounds(0, 0, imh.getIconWidth(), imh.getIconHeight());
        
        GridBagLayout layout = new GridBagLayout();
        
        JPanel panelContent = new JPanel(layout);
        GridBagConstraints gc = new GridBagConstraints();

        gc.insets = new Insets(3, 3, 3, 3);
        gc.gridx = 1;
        gc.gridy = 1;
        
        JLabel label = new JLabel("Has pasado mucho tiempo en la computadora, momento"
                + " de relajarnos un poco ");
        panelContent.add(label, gc);
        
        panelBgImg.add(panelContent);
        
        panelBgImg.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        setResizable(false);
	}
    
    private Dimension exercisePosition(){
        //Se obtiene las dimenciones de la pantalla
        Toolkit toolkit =  Toolkit.getDefaultToolkit ();
        Dimension dim = toolkit.getScreenSize();
        
        return dim;
    }

	public static void createWindow() {
            
            final Exercises exercise = new Exercises();
            
		JFrame.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Window w = new Exercises();
				w.setVisible(true);
				com.sun.awt.AWTUtilities.setWindowOpacity(w, 0.8f);
                                
                                Dimension position = exercise.exercisePosition();
                                
                                w.setLocation((position.width/2)-400, (position.height/2)-300);
			}
		});
	}
}
