package nl.inholland.javafx.models;

public class User extends Person{
    public UserType userType = UserType.User;

    public User(String userName, String password) {
        super(userName, password);
    }
}
