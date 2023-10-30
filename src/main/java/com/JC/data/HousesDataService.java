package com.JC.data;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.JC.model.HouseModel;
import com.JC.model.HousesMapper;

@Service
public class HousesDataService implements HousesDataAccessInterface<HouseModel> {
    
    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    public HousesDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*
     * Method to return all houses
     */
    @Override
    public List<HouseModel> getHouses() {
        String sql = "SELECT * FROM `houses`";
        List<HouseModel> houses = jdbcTemplate.query(sql, new HousesMapper());
        return houses.isEmpty() ? null : houses;
    }


    /*
     * Method to search through houses
     */
    @Override
    public List<HouseModel> searchHouses(String searchTerm) {
        return jdbcTemplate.query("select * from houses where nameOfProperty LIKE ?",
        new HousesMapper(),
        new Object[] {"%" + searchTerm + "%"});
    }

    @Override
    public boolean addOne(HouseModel newHouse) {
        String sql = "INSERT INTO houses(id, nameOfProperty, location, squareFeet, dateOfConstruction, photoFileName, description, value) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, newHouse.getId(), newHouse.getNameOfProperty(), newHouse.getLocation(),
                newHouse.getSquareFeet(), newHouse.getDateOfConstruction(), newHouse.getPhotoFileName(),
                newHouse.getDescription(), newHouse.getValue());
    
        return rows == 1;
    }
    
    @Override
    public boolean deleteOne(HouseModel house) {
        String sql = "DELETE FROM houses WHERE id = ?";
        int rows = jdbcTemplate.update(sql, house.getId());
        return rows == 1;
    }
    

    @Override
    public boolean updateOne(HouseModel house) {
        String sql = "UPDATE houses SET nameOfProperty = ?, location = ?, squareFeet = ?, dateOfConstruction = ?, photoFileName = ?, description = ?, value = ? WHERE id = ?";
        int rows = jdbcTemplate.update(sql, 
                house.getNameOfProperty(), house.getLocation(), house.getSquareFeet(),
                house.getDateOfConstruction(), house.getPhotoFileName(), house.getDescription(),
                house.getValue(), house.getId());
        return rows == 1;
    }
    

    @Override
    public HouseModel getHouseById(long id) {
        String sql = "SELECT * FROM `houses` WHERE `id` = ?";
        List<HouseModel> houses = jdbcTemplate.query(sql, new HousesMapper(), id);
        return houses.isEmpty() ? null : houses.get(0);
    }
    

}