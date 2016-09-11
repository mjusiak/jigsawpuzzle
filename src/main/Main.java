package main;

import widok.GameFrame;
import widok.StartFrame;

/**
 *
 * @author Mati
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameFrame gf = new GameFrame();
        gf.setVisible(false);
        StartFrame sf = new StartFrame(gf);
        sf.setVisible(true);
    }
    
}
