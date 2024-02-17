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

        // set layout to null to have an absolute layout which allows us to manually specify the size and position of each gui component
        this.setLayout(null);

        // prevent GUI from being resized
        this.setResizable(false);

        // launch the gui in the center of the screen
        this.setLocationRelativeTo((Component)null);

        // call on subclass addGUIComponents()
        this.addGUIComponents();
    }

    // this method will need to be defined by subclasses when this class is being inherited from
    protected abstract void addGUIComponents();
}
