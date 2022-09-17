package com.example.demojsp.dao;

import com.example.demojsp.model.Category;
import com.example.demojsp.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public List<Category> findAll() {
        List<Category> list = new ArrayList<Category>();
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.out.println("Can not connection to database");
                return null;
            }
            StringBuilder query = new StringBuilder("SELECT * FROM Category");
            PreparedStatement preparedStatement = cnn.prepareStatement(query.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                list.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
