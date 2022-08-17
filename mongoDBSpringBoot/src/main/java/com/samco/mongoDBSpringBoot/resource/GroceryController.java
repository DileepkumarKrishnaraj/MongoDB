package com.samco.mongoDBSpringBoot.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.samco.mongoDBSpringBoot.model.GroceryItems;
import com.samco.mongoDBSpringBoot.repository.GroceryRepository;

@RestController
public class GroceryController {
	@Autowired
	private GroceryRepository groceryRepository;
	
	@PostMapping("/addGrocery")
	public String saveGrocery(@RequestBody GroceryItems groceryItems) {
		groceryRepository.save(groceryItems);
		return "Added Grocery Item: " + groceryItems.getId();
	}
	
	@GetMapping("/findAllGrocery")
	public List<GroceryItems> getGrocery(){
		return groceryRepository.findAll();
	}
	
	@GetMapping("/findById/{id}") 
	public Optional<GroceryItems> getById(@PathVariable String id){
		return groceryRepository.findById(id);
	}
	
	@DeleteMapping("/delete")
	public String deleteGrocery(@PathVariable String id) {
		groceryRepository.deleteById(id);
		return "Grocery delete by id: " + id;
	}
	 
}
