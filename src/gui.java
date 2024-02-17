import GUIS.loginGui;

import javax.swing.*;


public class gui {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new loginGui().setVisible(true);
                //new registerGUI().setVisible(true);
//                new RestaurantGUI(
//                        new user(1, "username", "password")
//                ).setVisible(true);
            }

        });
    };
}
