package com.example.demojsp.dao;

import com.example.demojsp.model.Cinema;
import com.example.demojsp.model.Room;
import com.example.demojsp.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDao {
    public List<Room> findAll(){
        try {
            List<Room> list = new ArrayList<>();
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.out.println("Can not connection to database");
                return null;
            }
            StringBuilder query = new StringBuilder("SELECT * FROM Room");
            PreparedStatement preparedStatement = cnn.prepareStatement(query.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                room.setCinemaId(rs.getInt("cinema_id"));
                list.add(room);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
