package db_objs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.ArrayList;
//import java.util.List;


/*
    JDBC is used to interact with our MySQL Database to perform activities such as retrieving and updating our db
 */
public class MyJDBC {
    //database configuration
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/project";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Eshune215201102";


    // if valid return an object with the user's information
    public static user validatelogin(String username, String password) {
        try {
            //establish a connection with the database using configuration
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // create SQL query
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ? AND password = ?"
            );

            // ? values
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // execute query and store it in resultset
            ResultSet resultSet = preparedStatement.executeQuery();

            //next() true or false
            //true - query returned data and result is set now points to first row
            //false - query returns no data and result is null

            if (resultSet.next()) {
                //success
                //getid
                int usersid = resultSet.getInt("id");

                //return user object

                return new user(usersid, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //not valid user
        return null;
    }

    public static boolean register(String firstName, String lastName, String username, String password) {
        try {
            // Check if the user already exists to avoid duplicates
            if (!checkUser(username)) {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                // Prepare the SQL statement to insert the new user with an encrypted password
                String sql = "INSERT INTO users(firstname, lastname, username, password) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                // Set parameters for the INSERT statement
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, username);
                preparedStatement.setString(4, password); // Password will be encrypted by MySQL

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0; // Return true if the insertion was successful
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if the user exists or an error occurs
    }

    // check if username already exist in db
    //true - user exist
    //false - user doesn't exist
    private static boolean checkUser(String username){
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?"
            );

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            // this means that the query returned no data meaning that the username is available
            if(!resultSet.next()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;

    }

    public static List<MenuItem> getMenuItem() {
        List<MenuItem> menuItems = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, description, price, category FROM menu");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                String category = resultSet.getString("category");

                MenuItem menuItem = new MenuItem(name, description, price, category);
                menuItems.add(menuItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuItems;
    }

    public static boolean insertOrder(int userId, String orderDetails) {
        // Define SQL query with order_date
        String sql = "INSERT INTO orders (user_id, order_details, order_date) VALUES (?, ?, NOW())";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement insertOrder = connection.prepareStatement(sql)) {

            insertOrder.setInt(1, userId);
            insertOrder.setString(2, orderDetails);
            // No need to set order_date explicitly as NOW() function is used to set the current date and time

            int rowsAffected = insertOrder.executeUpdate();
            return rowsAffected > 0; // Return true if the insertion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<DetailedOrderItem> getOrderDetails(int userId) {
        List<DetailedOrderItem> orderDetails = new ArrayList<>();
        // Replace 'id' with the actual column name for the order number in your 'orders' table
        String sql = "SELECT id AS order_number, order_date, order_details " +
                "FROM orders " +
                "WHERE user_id = ? " +
                "ORDER BY order_date DESC";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Make sure column names here match those in your database
                    int orderNumber = resultSet.getInt("order_number"); // or resultSet.getInt(1) if using column index
                    String orderDate = resultSet.getString("order_date");
                    String orderDetailsString = resultSet.getString("order_details");
                    DetailedOrderItem item = new DetailedOrderItem(orderNumber, orderDate, orderDetailsString);
                    orderDetails.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

}