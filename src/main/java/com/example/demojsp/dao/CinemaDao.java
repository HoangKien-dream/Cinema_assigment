package com.example.demojsp.dao;

import com.example.demojsp.model.Cinema;
import com.example.demojsp.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CinemaDao {
    public List<Cinema> findAll(){
        try {
            List<Cinema> list = new ArrayList<>();
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.out.println("Can not connection to database");
                return null;
            }
            StringBuilder query = new StringBuilder("SELECT * FROM Cinema");
            PreparedStatement preparedStatement = cnn.prepareStatement(query.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cinema cinema = new Cinema();
                cinema.setId(rs.getInt("id"));
                cinema.setAddress(rs.getString("address"));
                cinema.setDescription(rs.getString("description"));
                cinema.setName(rs.getString("name"));
                list.add(cinema);
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
