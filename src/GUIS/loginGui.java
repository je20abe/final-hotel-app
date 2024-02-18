package GUIS;

import db_objs.user;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import static db_objs.MyJDBC.validatelogin;

/*
    This gui will allow user to log in or launch the register GUI
 */
public class loginGui extends Baseframe {
    private Image backgroundImage;
    public loginGui() {
        super("JK Restaurant");


        // Load the background image
        // https://stackoverflow.com/questions/9864267/loading-resources-like-images-while-running-project-distributed-as-jar-archive/9866659#9866659
        try {
            backgroundImage = ImageIO.read(new File("/Users/justice/Library/CloudStorage/OneDrive-UniversityofHertfordshire/hotel app/login.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Set the content pane to a new panel that will draw the background image
        setContentPane(new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        });

        addGUIComponents();
    }

    protected void addGUIComponents() {
        // create Restaurant app label
        JLabel restaurantAppLabel = new JLabel("JK Restaurant");

        // set the location and the size of the gui components
        restaurantAppLabel.setBounds(0, 20, super.getWidth(), 40);

        // change the font style
        restaurantAppLabel.setFont(new Font("Dialog", Font.BOLD, 42));

        // center the text in jLabel
        restaurantAppLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Set text color
        restaurantAppLabel.setForeground(Color.PINK);

        // adds to the GUI
        this.add(restaurantAppLabel);

        // create username label
        JLabel usernamelabel = new JLabel("Username: ");
        usernamelabel.setBounds(20, 120, this.getWidth() - 30, 24);
        usernamelabel.setFont(new Font("Dialog", Font.PLAIN, 20));
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
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //getUserName
                String username = usernameField.getText();

                //get password
                String password = String.valueOf(passwordField.getPassword());

                // validate login
                user User = validatelogin(username, password);

                //if user is null it means invalid otherwise it is a valid account
                if(User != null){
                    //means valid login

                    //dispose this GUI
                    loginGui.this.dispose();

                    //launch restaurant app gui
                    RestaurantGUI restaurantGUI =  new RestaurantGUI(User);
                    restaurantGUI.setVisible(true);

                    //show success dialog
                    JOptionPane.showMessageDialog(restaurantGUI, "Login successfully!");
                }else {
                    //invalid login
                    JOptionPane.showMessageDialog(loginGui.this, "invalid username or password");
                }

            }
        });
        this.add(loginButton);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setOpaque(false);
        JLabel registerlabel = new JLabel("<html><a href='#' style='color: white;'>Don't have an account? Register here</a></html>");
        registerlabel.setFont(new Font("Dialog", Font.BOLD, 21));
        registerlabel.setBounds(0, 510, getWidth() -10, 30 );
        registerlabel.setHorizontalAlignment(SwingConstants.CENTER);
        //registerlabel.setForeground(Color.BLACK); // Set the entire label's text color

        //adds an event listener so when the mouse is clicked it will launch the register gui
        registerlabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //dispose of this gui
                loginGui.this.dispose();

                //launch the register gui
                new registerGUI().setVisible(true);
            }
        });
        this.add(registerlabel);

        bottomPanel.add(registerlabel); // Add the label to the bottom panel
        // Using BorderLayout's SOUTH to add the register label at the bottom
        getContentPane().add(registerlabel, BorderLayout.SOUTH);

    }

}
