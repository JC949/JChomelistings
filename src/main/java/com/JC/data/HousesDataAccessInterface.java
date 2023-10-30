package com.JC.data;

import java.util.List;
import com.JC.model.HouseModel;

public interface HousesDataAccessInterface <T> {
    public T getHouseById(long id);
    public List<HouseModel> getHouses();
    public List<HouseModel> searchHouses(String searchTerm);
    public boolean addOne(T t);
    public boolean deleteOne(T t);
    public boolean updateOne(T t);
}
