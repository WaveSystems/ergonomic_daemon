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

/**
 *
 * @author Alberto
 */
public class Exercises extends JFrame {
    public Exercises() {
		super("Hagamos ejercicio");
                ImageIcon img = new ImageIcon("imgs/zen_1.jpg");
                JLabel imageLabel = new JLabel(img);
                
                this.add(imageLabel);
                
                
		this.setSize(new Dimension(800, 600));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Window w = new Exercises();
				w.setVisible(true);
				com.sun.awt.AWTUtilities.setWindowOpacity(w, 0.8f);
			}
		});
	}
}
