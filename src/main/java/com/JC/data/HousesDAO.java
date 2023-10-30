package com.JC.data;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.JC.model.HouseModel;

// This class does not connect to the database, it can be used for testing but has no
// practical use
@Repository
public class HousesDAO implements HousesDAOInterface {
    private List<HouseModel> houses = new ArrayList<HouseModel>();
    
    // Method to get orders by their ID
    @Override
    public HouseModel getById(int id) {
        return houses.stream().filter(house -> house.getId() == id)
        .findFirst().get();
    }

    // Method to return all houses
    @Override
    public List<HouseModel> getHouses() {
        return houses;
    }

    // Method to search through a list of items 
    @Override
    public List<HouseModel> searchHouses(String searchTerm) {
        List<HouseModel> foundItems = new ArrayList<HouseModel>();
        return foundItems.stream().filter(house -> house.getNameOfProperty().toLowerCase()
        .contains(searchTerm.toString().toLowerCase())).collect(Collectors.toList());
    }

    // Method to add a house to the list
    @Override
    public int addOne(HouseModel newHouse) {
        boolean success = houses.add(newHouse);

        System.out.println("Added one house. There are now " + 
        houses.size() + " houses in the list!");

        if (success)
        {
            return 1;
        }
        return 0;

    }

    // Method to remove a house from the list
    @Override
    public boolean deleteOne(long id) {
        houses.removeIf(house -> house.getId() == id);

        // For testing print message
        System.out.println("Removed one item. There are now "
         + houses.size() + "houses in the list!");

         return true;
    }

    // Method to update a house in the list
    @Override
    public HouseModel updateOne(long idToUpdate, HouseModel updateOrder) {
        houses.stream().forEach(house -> {
            if (house.getId() == idToUpdate)
            {
                house.setNameOfProperty(updateOrder.getNameOfProperty());
                house.setLocation(updateOrder.getLocation());
                house.setSquareFeet(updateOrder.getSquareFeet());
                house.setDateOfConstruction(updateOrder.getDateOfConstruction());
                house.setPhotoFileName(updateOrder.getPhotoFileName());
                house.setDescription(updateOrder.getDescription());
                house.setValue(updateOrder.getValue());
            }
        });

        // For testing purposes, print status message to console
        System.out.println("Updating house number: " +  idToUpdate + ". The updated order is " + updateOrder.toString());

        // If no house matches the given idToUpdate, do nothing and return null
        System.out.println("I tried to find house number: " + idToUpdate + " but there was not a match.");
        return null;
    }
}

