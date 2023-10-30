package com.JC.business;

import java.util.List;

import com.JC.model.HouseModel;

public interface HousesBusinessServiceInterface {
    
    public void test();
    public List<HouseModel> getHouses();
    public HouseModel getHouse(long id);
    // public HouseModel getOne(int id);
    // public List<HouseModel> searchHouses(String searchTerm);
    // public int addOne(HouseModel newHouse);
    // public boolean deleteOne(long id);
    // public HouseModel updateOne(long idToUpdate, HouseModel updateOrder);
}
