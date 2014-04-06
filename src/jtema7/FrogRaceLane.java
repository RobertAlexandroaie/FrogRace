/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtema7;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FrogRaceLane extends JPanel {

    private static final long serialVersionUID = 1L;
    private Broscuta myFrog;
    private boolean isOver;
    private int place;
    private BufferedImage myFrogImage;

    public FrogRaceLane(String nume) {
        super();
        isOver = false;
        myFrogImage = null;
        try {
            myFrogImage = ImageIO.read(new File("images/myturtle.png"));
        } catch (IOException e) {
            System.out.println("Nu a fost gasita imaginea testoasei");
            System.exit(0);
        }
        ((Graphics2D) myFrogImage.getGraphics()).setBackground(new Color(0, 0,
                0, 0));

        myFrog = new Broscuta(nume);
        myFrog.start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        g.drawLine(700, 0, 700, this.getHeight() - 1);
        g.drawString(myFrog.getName(), 10, (this.getHeight() - 1) / 2);
        g.drawImage(myFrogImage, myFrog.getPosition(), (this.getHeight() - 1) / 2, null);
        if (myFrog.getPosition() >= 700) {
            if (!isOver) {
                isOver=true;
                FrogRacePanel.victoriousFrogs++;
                place = FrogRacePanel.victoriousFrogs;
            }
            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(new Font("Serif", Font.BOLD, 25));
            g2d.setColor(Color.RED);
            g2d.drawString("Locul " + place, (this.getWidth() - 1) / 2, (this.getHeight() - 1) / 2);
        }

    }
}
