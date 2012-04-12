/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo_guard;

/**
 *
 * @author thenaox
 */

import java.awt.event.*;

public class keypressEvents {
    public static void main(String[] args) {
        keypressEvents event = new keypressEvents();
        event.keyPressed(null);
    }
    public String keyPressed(KeyEvent key){
        char i = key.getKeyChar();
        String str = Character.toString(i);
        return str;
    }
}