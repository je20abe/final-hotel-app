package GUIS;


import db_objs.user;

import javax.swing.*;




/*
    Display a custom dialogue for the RestaurantGUI
 */
public class RestaurantappDailogue extends JDialog {
    private user User;
    private RestaurantGUI restaurantGUI;


    public RestaurantappDailogue(RestaurantGUI restaurantGUI, user User) {
        // we will need access to user info to make updates to our db or retrieve data about the user
        this.User = User;

        // we will need to reference to our gui
        this.restaurantGUI = restaurantGUI;


        // Dialog setup

        // set the size
        setSize(550, 600);

        // add focus to the dialog(can't interact with anything until it's closed)
        setModal(true);

        // loads in the center of RestaurantGUI
        setLocationRelativeTo(restaurantGUI);

        //when suer closes the dialog, it releases its resources that are being used
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // prevent dialog from being resized
        setResizable(true);

        // allow us to manually specify the size and position of each component
        setLayout(null);


    }
}
