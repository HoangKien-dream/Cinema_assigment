package com.example.demojsp.model;

import java.sql.Time;
import java.util.Date;

public class Ticket {
    private int id;
    private String column;
    private int row;
    private double price;

    private int roomId;
    private int movieId;
    private Time time;
   private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Ticket() {
    }

    public Ticket(int id, String column, int row, double price, Time time) {
        this.id = id;
        this.column = column;
        this.row = row;
        this.price = price;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
