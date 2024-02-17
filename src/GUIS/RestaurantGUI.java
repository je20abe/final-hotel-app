package GUIS;

import db_objs.user;

/*
    performs restaurant functionalities such as viewing menu to place order and also view order history.
    This extends from baseframe which means i will need to define our own addGuicomponent
 */
public class RestaurantGUI extends Baseframe{
    public RestaurantGUI(user User) {
        super("Restaurant app", User);
    }

    @Override
    protected void addGUIComponents() {

    }
}
