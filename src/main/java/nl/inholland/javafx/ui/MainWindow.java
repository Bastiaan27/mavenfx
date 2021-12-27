package nl.inholland.javafx.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.javafx.models.MovieTicket;
import nl.inholland.javafx.ui.views.RoomListView;

import javax.swing.text.TableView;

public class MainWindow {

    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public MainWindow() {
        // create new stage
        stage = new Stage();

        stage.setHeight(720);
        stage.setWidth(1280);
        stage.setTitle("Cinemeerse - Main window");

        // menu
        VBox layout = new VBox();
        layout.setPadding(new Insets(10, 10, 10, 10));

        // elements in the vbox
        HBox menuBar = new HBox();
        layout.getChildren().add(1, new RoomListView());

        //stage.setScene(scene);
        stage.show();
    }
}
