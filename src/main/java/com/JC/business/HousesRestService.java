package com.JC.business;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JC.model.HouseModel;

@RestController
@RequestMapping("/service")
public class HousesRestService {

    @Autowired
    private HousesBusinessServiceInterface service;

    @GetMapping(path="/houses", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getHouses()
    {
        try {
            List<HouseModel> houses = service.getHouses();
            if (houses == null) 
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else
                return new ResponseEntity<>(houses, HttpStatus.OK);
        //returns all houses in a JCon format
        //return service.getHouses();
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    /**
     * Returns JCON version of a specific house
     */
    @GetMapping(path = "/houses/{id}", produces = { "application/JCon" })
    public ResponseEntity<HouseModel> getHouse(@PathVariable("id") long id) {
        try {
            HouseModel house = service.getHouse(id);
            if (house == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(house, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
