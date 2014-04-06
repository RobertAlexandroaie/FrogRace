
package jtema7;

import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;

public class Broscuta extends Thread{
    private int x;
    private int viteza;

    public Broscuta(String nume) {
        super(nume);
        x = 10;
        viteza = 30;
    }

    public int getPosition(){
        return x;
    }
    
    public int getSpeed(){
        return viteza;
    }
    
    public int calculeazaViteza() {
        if(!FrogRaceFrame.isActive){
            return 0;
        }
        double speedmodif = Math.random();
        if (speedmodif < 0.2) {
            viteza += (int) ((Math.random()) * (viteza/3));
            if(viteza>=50){
                viteza=50;
            }
        } else if (speedmodif < 0.4 && speedmodif >= 0.2) {
            viteza -= (int) ((Math.random()) * (viteza/3));
            if (viteza <= 20) {
                viteza = 20;
            }
        }
        return viteza;

    }

    @Override
    public void run() {
        while(true) {
            x = x + calculeazaViteza();
            if (x > 705) {
                x = 705;
            }
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                System.exit(0);
            }
            if (x >= 700) {
                break;
            }
            yield();
        }
    }
}
