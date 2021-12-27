package nl.inholland.javafx.models;

import java.time.LocalDateTime;

public class MovieTicket {
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public String title;
    public int seats;
    public double price;
    public Room movieRoom;

    public MovieTicket(LocalDateTime start, LocalDateTime end, String title, int seats, double price, Room room) {
        startTime = start;
        endTime = end;
        this.title = title;
        this. seats = seats;
        this.price = price;
        movieRoom = room;
    }
}