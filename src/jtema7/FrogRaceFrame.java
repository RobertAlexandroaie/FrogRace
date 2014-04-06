
package jtema7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrogRaceFrame extends Frame {

    private static final long serialVersionUID = 1L;
    private FrogRacePanel myPanel;
    static boolean isActive;
    public FrogRaceFrame(String nume, int size) {
        super(nume);
        this.setMinimumSize(new Dimension(800, size * 30));
        this.setSize(800, 700);
        isActive=true;
        myPanel = new FrogRacePanel(size);
        this.add(myPanel, BorderLayout.CENTER);
        myPanel.setPreferredSize(getMaximumSize());

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
            public void windowDeiconified(WindowEvent e){
               isActive=true;
            }
            public void windowIconified(WindowEvent e){
                isActive=false;
            }
            public void windowStateChanged(WindowEvent e){
                //isActive=!isActive;
            }
        });

    }
}