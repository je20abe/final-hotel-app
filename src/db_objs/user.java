package db_objs;

/*
    user entity which is used to store user information
 */
public class user {
    private final int id;
    private final String username, password;

    public user(int id, String username, String password){
        this.id = id;
        this.password = password;
        this.username = username;


    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}


