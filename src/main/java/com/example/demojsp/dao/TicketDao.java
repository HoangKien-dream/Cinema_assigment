package com.example.demojsp.dao;

import com.example.demojsp.model.Ticket;
import com.example.demojsp.util.ConnectionHelper;

import java.sql.*;

public class TicketDao {
    public boolean createTicket(Ticket ticket, int slotNumber) {
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.out.println("Can not connection to database");
                return false;
            }
            StringBuilder query = new StringBuilder("INSERT INTO Ticket");
            query.append(" ");
            query.append("(room_id, movie_id, colum, row, price, time,date)");
            query.append(" ");
            query.append("VALUES");
            query.append(" ");
            query.append("(?, ?, ?, ?, ?, ? ,?)");
            PreparedStatement preparedStatement = cnn.prepareStatement(query.toString());
            for (int i = 0; i < slotNumber; i++) {
                switch (i){
                    case 0:
                        ticket.setColumn("A");
                        break;
                    case 5:
                        ticket.setColumn("B");
                        break;
                    case 10:
                        ticket.setColumn("C");
                        break;
                    case 15:
                        ticket.setColumn("D");
                        break;
                    case 20:
                        ticket.setColumn("E");
                        break;
                }
                preparedStatement.setInt(1, ticket.getRoomId());
                preparedStatement.setInt(2, ticket.getMovieId());
                preparedStatement.setString(3, ticket.getColumn());
                preparedStatement.setInt(4, i+1);
                preparedStatement.setDouble(5, ticket.getPrice());
                preparedStatement.setTime(6, ticket.getTime());
                preparedStatement.setDate(7, new Date(ticket.getDate().getTime()));
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
