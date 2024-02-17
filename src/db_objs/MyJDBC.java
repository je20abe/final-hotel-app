package db_objs;
import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;


/*
    JDBC is used to interact with our MySQL Database to perform activities such as retrieving and updating our db
 */
public class MyJDBC {
    //database configuration
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/restaurantapp";
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
                    "SELECT * FROM users WHERE username = ? AND password = SHA2(?, 224)"
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
                String sql = "INSERT INTO users(firstname, lastname, username, password) VALUES (?, ?, ?, SHA2(?, 224))";
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
}