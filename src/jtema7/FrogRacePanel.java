/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtema7;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class FrogRacePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private int frogNumber;
    static int victoriousFrogs=0;
    FrogRacePanel(int frogs) {
        super();
        victoriousFrogs=0;
        this.setLayout(new GridLayout(frogs, 1));
        frogNumber = frogs;
        for (int i = 0; i < frogNumber; i++) {
            FrogRaceLane newCanvas = new FrogRaceLane("Broscuta " + (i + 1));
            newCanvas.setPreferredSize(new Dimension(200, 900));
            this.add(newCanvas);
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        if(victoriousFrogs<frogNumber)
            repaint();

    }
}
