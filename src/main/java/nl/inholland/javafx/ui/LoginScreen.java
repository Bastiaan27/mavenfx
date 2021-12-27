package nl.inholland.javafx.ui;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import nl.inholland.javafx.data.Database;

public class LoginScreen {
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public LoginScreen() {
        // create new stage
        stage = new Stage();

        stage.setHeight(200);
        stage.setWidth(300);
        stage.setTitle("Cinemeerse - Login");

        // create the grid
        GridPane myGrid = new GridPane();
        myGrid.setPadding(new Insets(15, 15, 15, 15));
        myGrid.setVgap(10);
        myGrid.setHgap(10);

        // create username label
        Label usernameLabel = new Label("Username:");
        myGrid.add(usernameLabel, 0, 0);

        // create field for entering username
        TextField usernameField = new TextField();
        usernameField.setPromptText("enter username"); // adds placeholder text
        myGrid.add(usernameField, 1, 0);

        // create password label
        Label passwordLabel = new Label("Password:");
        myGrid.add(passwordLabel, 0, 1);

        // create field for entering password
        TextField passwordField = new TextField();
        usernameField.setPromptText("enter password"); // adds placeholder text
        myGrid.add(passwordField, 1, 1);

        // create login button
        Button loginButton = new Button("Login");
        loginButton.setVisible(false);
        myGrid.add(loginButton, 1, 3);

        // create error label
        Label errorLabel = new Label();
        myGrid.add(errorLabel, 2, 3);

        // create StringProperty
        StringProperty passwordProperty = passwordField.textProperty();

        // add the listener to this property
        passwordProperty.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue,
                                String oldValue, String newValue) {
                loginButton.setVisible(passwordField.getText().length() != 0);
            }
        });

        // let the button do something
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(usernameField.getText());
            }
        });

        // add grid to scene
        Scene scene = new Scene(myGrid);

        stage.setScene(scene);
        stage.show();
    }
}
