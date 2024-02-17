package GUIS;

import javax.swing.*;
import java.awt.*;

public class registerGUI extends Baseframe{
    public registerGUI(){
        super("JK Restaurant");
    }
    @Override
    protected void addGUIComponents() {
        // create Restaurant app label
        JLabel restaurantAppLabel = new JLabel("JK Restaurant");
        restaurantAppLabel.setBounds(0, 20, super.getWidth(), 40);
        restaurantAppLabel.setFont(new Font("Dialog", Font.BOLD, 42));
        restaurantAppLabel.setHorizontalAlignment(SwingConstants.CENTER);
        restaurantAppLabel.setForeground(Color.PINK); // Set text color to white
        this.add(restaurantAppLabel); // adds to the GUI


        // First Name Label and Text Field
        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setBounds(20, 70, this.getWidth() - 30, 24);
        firstNameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        firstNameLabel.setForeground(Color.WHITE);
        this.add(firstNameLabel);

        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(20, 100, this.getWidth() - 50, 40);
        firstNameField.setFont(new Font("Dialog", 0, 28));
        this.add(firstNameField);

        // Last Name Label and Text Field
        JLabel lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setBounds(20, 150, this.getWidth() - 30, 24);
        lastNameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        lastNameLabel.setForeground(Color.WHITE);
        this.add(lastNameLabel);

        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(20, 180, this.getWidth() - 50, 40);
        lastNameField.setFont(new Font("Dialog", 0, 28));
        this.add(lastNameField);

        // Username Label and Text Field
        JLabel usernamelabel = new JLabel("Username: ");
        usernamelabel.setBounds(20, 230, this.getWidth() - 30, 24);
        usernamelabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        usernamelabel.setForeground(Color.WHITE);
        this.add(usernamelabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(20, 260, this.getWidth() - 50, 40);
        usernameField.setFont(new Font("Dialog", 0, 28));
        this.add(usernameField);

        // Password Label and Text Field
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(20, 310, this.getWidth() - 50, 24);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        passwordLabel.setForeground(Color.WHITE);
        this.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20, 340, this.getWidth() - 50, 40);
        passwordField.setFont(new Font("Dialog", 0, 28));
        this.add(passwordField);

        // Re-type Password Label and Text Field
        JLabel rePasswordLabel = new JLabel("Re-type Password: ");
        rePasswordLabel.setBounds(20, 390, this.getWidth() - 50, 24);
        rePasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        rePasswordLabel.setForeground(Color.WHITE);
        this.add(rePasswordLabel);

        JPasswordField rePasswordField = new JPasswordField();
        rePasswordField.setBounds(20, 420, this.getWidth() - 50, 40);
        rePasswordField.setFont(new Font("Dialog", 0, 28));
        this.add(rePasswordField);

        // create login label
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setOpaque(false);
        JLabel loginlable = new JLabel("<html><a href=\"#\" style=\"color: white;\">Have an account? Sign-in here</a></html>");
        loginlable.setBounds(0, 530, this.getWidth() - 10, 30);
        loginlable.setFont(new Font("Dialog", Font.PLAIN, 21));
        loginlable.setHorizontalAlignment(SwingConstants.CENTER);
    }
    }
