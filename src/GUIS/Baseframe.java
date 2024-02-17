package GUIS;

import javax.swing.*;
import java.awt.*;

/*
    creating an abstract class that helps set up the blueprint that the GUI will follow, eg; in each GUI they will be the same size
    and will need to invoke addGUIComponents() which will be unique for each class. NB: The size for each GUI can be changed depending
    on how you want it
 */
public abstract class Baseframe extends JFrame {
    protected user User;
    public Baseframe(String title) {
        this.initialize(title);
    }
    public Baseframe(String title, user User){
        // initialize user
        this.User = User;
        initialize(title);
    }

    private void initialize(String title) {
        // instantiate jframe properties and add a title to the bar
        this.setTitle(title);

        // set size(in pixels)
        // https://stackoverflow.com/questions/8193801/how-to-set-specific-window-frame-size-in-java-swing
        this.setSize(500, 600);
        this.setDefaultCloseOperation(3);
        this.setLayout((LayoutManager)null);
        this.setResizable(false);
        this.setLocationRelativeTo((Component)null);
        this.addGUIComponents();
    }

    protected abstract void addGUIComponents();
}
