package com.JC.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JC.data.HousesDataAccessInterface;
import com.JC.model.HouseModel;

@Service
public class HousesBusinessService implements HousesBusinessServiceInterface {

        @Autowired
        HousesDataAccessInterface<HouseModel> service;
    
        public HousesBusinessService() {
            // default constructor
        }

    @Override
    public void test() {
        System.out.println("test method of houses business service");
    }

    @Override
    public List<HouseModel> getHouses() {
        return service.getHouses();
    }

    @Override
    public HouseModel getHouse(long id) {
        return service.getHouseById(id);
    }
}

