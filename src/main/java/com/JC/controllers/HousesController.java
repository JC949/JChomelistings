package com.JC.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.JC.business.HousesBusinessServiceInterface;
import com.JC.data.HousesDataAccessInterface;
import com.JC.model.HouseModel;

@Controller
@RequestMapping("/houses")
public class HousesController {

	@Autowired
	private HousesBusinessServiceInterface service;
	@Autowired
	private HousesDataAccessInterface<HouseModel> dataService;

	/**
	 * basic house page
	 * 
	 * @param model
	 * @return newProduct view
	 */
	@GetMapping("/")
	public String displayHouses(Model model) {
		List<HouseModel> houses = service.getHouses();
		model.addAttribute("title", "The Houses");
		model.addAttribute("houses", houses); // Correctly add houses to the model
		model.addAttribute("houseID", new HouseModel());
	
		return "houses";
	}
	

	/*
	 * Method for finding search id
	 */
@GetMapping("/search")
public String searchHouses(@RequestParam("id") Long id, Model model) {
    HouseModel house = dataService.getHouseById(id);
    if (house != null) {
        List<HouseModel> houses = new ArrayList<>();
        houses.add(house);
        model.addAttribute("title", "Search Results");
        model.addAttribute("houses", houses);
        return "houses";
    } else {
        model.addAttribute("title", "Search Results");
        model.addAttribute("houses", new ArrayList<HouseModel>());
        return "houses";
    }
}

	
	


	/**
	 * Method for displaying add house page
	 * 
	 * @param model
	 * @return Product view
	 */
	@GetMapping("/addHouse")
	public String enterProduct(Model model) {
		// adds attributes of title and houseModel to be shown in the web page
		model.addAttribute("title", "Add a House");
		model.addAttribute("house", new HouseModel());
		return "addHouse";
	}

	@GetMapping("/editHouse/{id}")
	public String editHouse(@PathVariable("id") Long id, Model model) {
    // Retrieve the house with the specified ID from your data source
    HouseModel house = dataService.getHouseById(id);

    if (house != null) {
        // If the house exists, add it to the model
        model.addAttribute("house", house);
        model.addAttribute("title", "Edit House");
        return "editHouse"; // Return the editHouse.html template
    } else {
        // Handle the case where the house with the specified ID doesn't exist
        // You can display an error message or redirect to an error page
        return "redirect:/houses"; // Redirect to the houses listing page
    }
}


	/**
	 * validates and adds house
	 * 
	 * @param houseModel
	 * @param bindingResult
	 * @param model
	 * @return newProduct view
	 */
	@PostMapping("/addHouse")
	public String addHouse(@Valid HouseModel houseModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Could not add House");
			return "addHouse";
		}
	
	
		return "redirect:/houses"; 
	}
	

	@PostMapping("/doAddHouse")
	public String doAddHouse(@Valid HouseModel houseModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Could not add House");
			return "addHouse";
		}
	
		// Set a valid value for the "value" field (replace this with the actual value)
		houseModel.setValue(10000.00); // Set an example value
	
		// Save the house to the database
		dataService.addOne(houseModel);
	
		model.addAttribute("title", "House was added");
		model.addAttribute("houseModel", service.getHouses());
	
		return "redirect:/houses/";
	}
	


	/**
	 * Method for displaying update house page
	 * 
	 * @param model
	 * @return Product view
	 */
	// Sets up URI for localhost:8080/enterHouse
	@PostMapping("/updateHouse")
	public String updateProduct(HouseModel houseModel, Model model) {
		// adds attributes of title and houseModel to be shown in the web page
		model.addAttribute("title", "Update " + service.getHouse(houseModel.getId()).getNameOfProperty());
		model.addAttribute("houseModel", service.getHouse(houseModel.getId()));
		return "houses";
	}

	/**
	 * validates and updates house
	 * 
	 * @param houseModel
	 * @param bindingResult
	 * @param model
	 * @return newProduct view
	 */
	@PostMapping("/doUpdateHouse/{id}")
	public String doUpdateHouse(@PathVariable("id") Long id, @Valid HouseModel houseModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Could not update house");
			model.addAttribute("houseModel", houseModel);
			return "editHouse";
		}
	
		// Set the ID of the house model to the ID from the path variable
		houseModel.setId(id);
	
		// Update the house in the database
		dataService.updateOne(houseModel);
	
		return "redirect:/houses/";
	}
	

	/**
	 * Method for displaying delete house page
	 * 
	 * @param model
	 * @return Product view
	 */
	// Sets up URI for localhost:8080/enterProduct/
	@PostMapping("/deleteHouse")
	public String deleteHouse(HouseModel house, Model model) {
		// adds attributes of title and houseModel to be shown in the web page
		model.addAttribute("title", "Delete a House");
		model.addAttribute("houseModel", service.getHouse(house.getId()));
		return "houses";
	}

	/**
	 * validates and deletes house
	 * 
	 * @param houseModel
	 * @param bindingResult
	 * @param model
	 * @return newProduct view
	 */
	@GetMapping("/doDeleteHouse/{id}")
	public String doDeleteHouse(@PathVariable("id") Long id, Model model) {
		HouseModel houseToDelete = dataService.getHouseById(id);
	
		if (houseToDelete != null) {
			dataService.deleteOne(houseToDelete);
		}
	
		return "redirect:/houses/";
	}
	

}
