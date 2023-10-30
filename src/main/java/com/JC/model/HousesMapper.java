package com.JC.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class HousesMapper implements RowMapper<HouseModel> {

    public HouseModel mapRow(ResultSet resultSet, int i) throws SQLException {
        HouseModel house = new HouseModel(
            resultSet.getLong("id"),
            resultSet.getString("nameOfProperty"),
            resultSet.getString("location"),
            resultSet.getInt("squareFeet"),
            resultSet.getString("dateOfConstruction"),
            resultSet.getString("photoFileName"),
            resultSet.getString("description"),
            resultSet.getDouble("value")
            );

        return house;
    }
}
