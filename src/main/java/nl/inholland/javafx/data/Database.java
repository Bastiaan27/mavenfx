package nl.inholland.javafx.data;

import nl.inholland.javafx.models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<MovieTicket> movieTickets = new ArrayList<>();
    private List<Person> persons = new ArrayList<>();

    public List<MovieTicket> getMovieTickets() { return movieTickets; }

    public List<Person> getPersons() {
        return persons;
    }

    public Database() {
        // movies
        movieTickets.add(new MovieTicket(LocalDateTime.of(2021, 10, 27, 10, 00),
                LocalDateTime.of(2021, 10, 27, 12, 15), "No time to fly", 300, 12.50, Room.Room1));
        movieTickets.add(new MovieTicket(LocalDateTime.of(2021, 11, 5, 22, 00),
                LocalDateTime.of(2021, 11, 5, 23, 45), "Spiderman: Home Alone", 200, 14.00, Room.Room1));
        movieTickets.add(new MovieTicket(LocalDateTime.of(2021, 12, 27, 12, 15),
                LocalDateTime.of(2021, 10, 27, 15, 10), "Avengers: Begingame", 250, 15.00, Room.Room1));

        // persons
        persons.add(new User("harry", "harry123"));
        persons.add(new Admin("admin", "admin"));
    }
}
