package com.jamesdick.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jamesdick.base.Food;
import com.jamesdick.repository.FoodRepository;

@Service
public class FoodService {
    @Autowired
    FoodRepository foodRepository;

    //get all foods in the freezer
    public List<Food> getAllFoods() {
        List<Food> foods = new ArrayList<Food>();
        foodRepository.findAll().forEach(food -> foods.add(food));
        return foods;
    }
    //Food by ID method
    public Food getFoodById(int id)
    {
        return foodRepository.findById(id).get();
    }
    //this allows both creating new and updating through post methods.
    public void saveOrUpdate(Food food){
        foodRepository.save(food);
    }

    public void delete(int id){
        foodRepository.deleteById(id);
    }

    //get food by its name
    public Food getFoodByName(String name){
        List<Food> foods = new ArrayList<Food>();
        foodRepository.findAll().forEach(food -> foods.add(food));
        //for loop through to find FIRST food of that name
        for (Food food : foods) {
            if (name.equalsIgnoreCase(food.getName())) { //ignore case for better usability
                return foodRepository.findById(food.getId()).get();
            }
        }
        return null; //blank return if nothing found
    }



}

