package GUIS;

import db_objs.user;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/*
    performs restaurant functionalities such as viewing menu to place order and also view order history.
    This extends from baseframe which means I will need to define our own addGuicomponent
 */


/*
The BackgroundPanel class is created as a custom component to allow the panel to have a background image. This is necessary because JPanel does not natively support background images.
* */
// Custom JPanel to paint background image
class BackgroundPanel1 extends JPanel {
    private Image backgroundImage;

    // Constructor to set the background image
    public BackgroundPanel1(String imagePath) {
        try {
            // Load the background image
            backgroundImage = ImageIO.read(new File("/Users/justice/Desktop/final hotel app/final hotel app/GUI.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
public class RestaurantGUI extends Baseframe implements ActionListener {
    public RestaurantGUI(user User) {
        super("Restaurant app", User);

        // Background setup
        BackgroundPanel1 backgroundPanel = new BackgroundPanel1("/Users/justice/Library/CloudStorage/OneDrive-UniversityofHertfordshire/hotel app/GUI.jpg");
        backgroundPanel.setLayout(null); // Use null layout for absolute positioning
        setContentPane(backgroundPanel); // Set the background panel as the content pane

        // Add GUI components
        addGUIComponents();

        // Frame visibility
        setVisible(true);
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
        // Handle action events for buttons
        String buttonPressed = e.getActionCommand();

        // Open Menu Dialogue if "Menu" button is pressed
        if ("Menu".equalsIgnoreCase(buttonPressed)) {
            new RestaurantappDailogue(this, User, "Menu").setVisible(true);
        }
        // Open Order History Dialogue if "Order History" button is pressed
        else if ("Order History".equalsIgnoreCase(buttonPressed)) {
            new RestaurantappDailogue(this, User, "Order History").setVisible(true);
        }
        // Logout and open login window if "Logout" button is pressed
        else if ("Logout".equalsIgnoreCase(buttonPressed)) {
            dispose(); // Close the current window
            new loginGui().setVisible(true); // Open the login window
        }
    }
}
