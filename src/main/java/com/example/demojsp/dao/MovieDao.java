package com.example.demojsp.dao;

import com.example.demojsp.model.Movie;
import com.example.demojsp.util.ConnectionHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {
    public List<Movie> getAll() {
        try {
            List<Movie> list = new ArrayList<>();
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.out.println("Can not connection to database");
                return null;
            }
            StringBuilder query = new StringBuilder("SELECT * FROM Movie");
            PreparedStatement preparedStatement = cnn.prepareStatement(query.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setName(rs.getString("name"));
                movie.setCategoryId(rs.getInt("category_id"));
                movie.setDescription(rs.getString("description"));
                movie.setThumbnail(rs.getString("thumbnail"));
                list.add(movie);
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

    public Movie save(Movie movie) {
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.out.println("Can not connection to database");
                return null;
            }
            StringBuilder query = new StringBuilder("INSERT INTO Movie");
            query.append(" ");
            query.append("(name, category_id, description, thumbnail,status)");
            query.append(" ");
            query.append("VALUES");
            query.append(" ");
            query.append("(?, ?, ?, ?, ? )");
            PreparedStatement preparedStatement = cnn.prepareStatement(query.toString());
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setInt(2, movie.getCategoryId());
            preparedStatement.setString(3, movie.getDescription());
            preparedStatement.setString(4, movie.getThumbnail());
            preparedStatement.setInt(5, 1);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
