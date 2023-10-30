package com.JC.data;

import java.util.List;

import com.JC.model.HouseModel;

public interface HousesDAOInterface {
    public HouseModel getById(int id);
    public List<HouseModel> getHouses();
    public List<HouseModel> searchHouses(String searchTerm);
    public int addOne(HouseModel newHouse);
    public boolean deleteOne(long id);
    public HouseModel updateOne(long idToUpdate, HouseModel updateOrder);
    
}
