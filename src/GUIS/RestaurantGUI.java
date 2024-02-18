package GUIS;

import db_objs.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    performs restaurant functionalities such as viewing menu to place order and also view order history.
    This extends from baseframe which means i will need to define our own addGuicomponent
 */
public class RestaurantGUI extends Baseframe implements ActionListener {
    public RestaurantGUI(user User) {
        super("Restaurant app", User);
    }

    @Override
    protected void addGUIComponents() {
        // Construct and add a welcome message label
        String welcomeMessage = "<html><body style='text-align:center'><b>Hello " + User.getUsername() + "</b><br>What would you like to order today?</body></html>";
        JLabel welcomeMessageLabel = new JLabel(welcomeMessage);
        welcomeMessageLabel.setBounds(0, 20, getWidth() - 10, 40);
        welcomeMessageLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        welcomeMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeMessageLabel.setForeground(Color.white);
        add(welcomeMessageLabel);

        // Add Menu, Order History, and Logout buttons to the frame
        add(createButton("MENU", 10, 130));
        add(createButton("Order History", 10, 230));
        add(createButton("LogOut", 10, 430));

    }

    // Helper method to create a styled button
    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, getWidth() - 40, 35);
        button.setFont(new Font("Dialog", Font.BOLD, 22));
        button.setForeground(Color.BLACK);
        button.setOpaque(true);
        button.setBackground(new Color(95, 127, 161)); // Custom color for the button
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new RestaurantappDailogue(this, User).setVisible(true);

}}
