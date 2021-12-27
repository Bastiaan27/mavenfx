package nl.inholland.javafx.ui.views;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import nl.inholland.javafx.data.Database;
import nl.inholland.javafx.models.MovieTicket;
import nl.inholland.javafx.models.Room;

import java.util.Collection;

public class RoomListView extends HBox {

    private Database db;
    private ObservableList<MovieTicket> movieTickets;
    private ObservableList<MovieTicket> ticketsRoom1;
    private ObservableList<MovieTicket> ticketsRoom2;


    public RoomListView() {
        // initialize data
        db = new Database();
        movieTickets = FXCollections.observableArrayList(db.getMovieTickets());

        for (MovieTicket ticket : movieTickets) {
            if (ticket.movieRoom == Room.Room1)
                ticketsRoom1.add(ticket);
            else if (ticket.movieRoom == Room.Room2)
                ticketsRoom2.add(ticket);
        }

        // setup layout
        this.setPadding(new Insets(15));
        this.setSpacing(15);

        // the room 1 pane
        VBox room1Pane = new VBox();
        Label headerRoom1Label = new Label("Room 1");

        // set up tableview
        TableView<MovieTicket> room1TableView = new TableView<>();
        room1TableView.setEditable(true);
        room1TableView.getSelectionModel().setCellSelectionEnabled(false);
        room1TableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        TableColumn startTimeRoom1Col = new TableColumn("Start");
        startTimeRoom1Col.setMinWidth(100);
        startTimeRoom1Col.setCellValueFactory(new PropertyValueFactory<MovieTicket, String>("startTime"));

        TableColumn endTimeRoom1Col = new TableColumn("End");
        endTimeRoom1Col.setMinWidth(100);
        endTimeRoom1Col.setCellValueFactory(new PropertyValueFactory<MovieTicket, String>("endTime"));

        TableColumn titleRoom1Col = new TableColumn("Title");
        titleRoom1Col.setMinWidth(100);
        titleRoom1Col.setCellValueFactory(new PropertyValueFactory<MovieTicket, String>("title"));

        TableColumn seatsRoom1Col = new TableColumn("Seats");
        seatsRoom1Col.setMinWidth(50);
        seatsRoom1Col.setCellValueFactory(new PropertyValueFactory<MovieTicket, String>("seats"));

        TableColumn priceRoom1Col = new TableColumn("Price");
        priceRoom1Col.setMinWidth(50);
        priceRoom1Col.setCellValueFactory(new PropertyValueFactory<MovieTicket, String>("price"));

        room1TableView.getColumns().addAll(startTimeRoom1Col, endTimeRoom1Col, titleRoom1Col, seatsRoom1Col, priceRoom1Col);
        room1TableView.setItems(ticketsRoom1);

        // the room 2 pane
        VBox room2Pane = new VBox();
        Label headerRoom2Label = new Label("Room 2");

        // set up tableview
        TableView<MovieTicket> room2TableView = new TableView<>();
        room2TableView.setEditable(true);
        room2TableView.getSelectionModel().setCellSelectionEnabled(false);
        room2TableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        TableColumn startTimeRoom2Col = new TableColumn("Start");
        startTimeRoom2Col.setMinWidth(100);
        startTimeRoom2Col.setCellValueFactory(new PropertyValueFactory<MovieTicket, String>("startTime"));

        TableColumn endTimeRoom2Col = new TableColumn("End");
        endTimeRoom2Col.setMinWidth(100);
        endTimeRoom2Col.setCellValueFactory(new PropertyValueFactory<MovieTicket, String>("endTime"));

        TableColumn titleRoom2Col = new TableColumn("Title");
        titleRoom2Col.setMinWidth(100);
        titleRoom2Col.setCellValueFactory(new PropertyValueFactory<MovieTicket, String>("title"));

        TableColumn seatsRoom2Col = new TableColumn("Seats");
        seatsRoom2Col.setMinWidth(50);
        seatsRoom2Col.setCellValueFactory(new PropertyValueFactory<MovieTicket, String>("seats"));

        TableColumn priceRoom2Col = new TableColumn("Price");
        priceRoom2Col.setMinWidth(50);
        priceRoom2Col.setCellValueFactory(new PropertyValueFactory<MovieTicket, String>("price"));

        room2TableView.getColumns().addAll(startTimeRoom2Col, endTimeRoom2Col, titleRoom2Col, seatsRoom2Col, priceRoom2Col);
        room2TableView.setItems(ticketsRoom2);

        // get children room 1 and room 2
        room1Pane.getChildren().addAll(headerRoom1Label, room1TableView);
        room2Pane.getChildren().addAll(headerRoom2Label, room2TableView);

        // add room 1 and room 2 to global layout
        this.getChildren().addAll(room1TableView, room2TableView);
    }
}
