package com.jamesdick.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//also need import these classes from the other packages.
import com.jamesdick.base.Food;
import com.jamesdick.service.FoodService;

@RestController
public class FoodController {

    @Autowired
    FoodService foodService;

    //get the detail of the food by ID
    @GetMapping("/food/{id}")
    private Food getFoodById(@PathVariable("id") int id) {
        return foodService.getFoodById(id);
    }
    //add or update food in the freezer
    @PostMapping("/food")
    private int addFood(@RequestBody Food food){
        foodService.saveOrUpdate(food); //if the food is already there this just overwrites it.
        return food.getId(); //further development could be here, incorporate only allowing the user to update the quantity
    }

    @DeleteMapping("/food/{id}")
    private void deleteFood(@PathVariable("id") int id){
        foodService.delete(id);
    }
    //get food by string
    @GetMapping("/food/search/{name}")
    private Food getFoodByName(@PathVariable("name") String name){
        return foodService.getFoodByName(name);
}


}
