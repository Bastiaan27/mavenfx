package nl.inholland.javafx.models;

public class Admin extends Person{
    public UserType userType = UserType.Admin;

    public Admin(String userName, String password) {
        super(userName, password);
    }
}
