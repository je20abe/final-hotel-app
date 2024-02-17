package GUIS;

import javax.swing.*;
import java.awt.*;

/*
    This gui will allow user to log in or launch the register GUI
 */
public class loginGui extends Baseframe {
    public loginGui() {
        super("JK Restaurant");
    }

    @Override
    protected void addGUIComponents() {
        // create Restaurant app label
        JLabel restaurantAppLabel = new JLabel("JK Restaurant");

        // set the location and the size of the gui components
        restaurantAppLabel.setBounds(0, 20, super.getWidth(), 40);

        // change the font style
        restaurantAppLabel.setFont(new Font("Dialog", Font.BOLD, 42));

        // center the text in jLabel
        restaurantAppLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Set text color to white
        restaurantAppLabel.setForeground(Color.PINK);

        // adds to the GUI
        this.add(restaurantAppLabel);

        // create username label
        JLabel usernamelabel = new JLabel("Username: ");

        //getwidth() returns the width of our frame
        usernamelabel.setBounds(20, 120, this.getWidth() - 30, 24);

        //change the font style
        usernamelabel.setFont(new Font("Dialog", Font.PLAIN, 20));

        // Set text color to white
        usernamelabel.setForeground(Color.WHITE); // Set text color to white
        this.add(usernamelabel); // adds to GUI

        // create username textfield
        JTextField usernameField = new JTextField();
        usernameField.setBounds(20, 160, this.getWidth() - 50, 40);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 28));
        this.add(usernameField); // adds to gui

        // create password label
        JLabel passwordlabel = new JLabel("password: ");
        passwordlabel.setBounds(20, 280, this.getWidth() - 50, 24);
        passwordlabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        passwordlabel.setForeground(Color.WHITE); // Set text color to white
        this.add(passwordlabel); // adds to gui

        // create password textfield
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20, 320, this.getWidth() - 50, 40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 28));
        this.add(passwordField); // adds to gui

        // create login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(20, 470, this.getWidth() - 50, 40);
        loginButton.setFont(new Font("Dialog", Font.PLAIN, 21));
        add(loginButton);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setOpaque(false);
        JLabel registerlabel = new JLabel("<html><a href='#' style='color: white;'>Don't have an account? Register here</a></html>");
        registerlabel.setFont(new Font("Dialog", Font.BOLD, 21));
        registerlabel.setBounds(0, 510, getWidth() -10, 30 );
        registerlabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
