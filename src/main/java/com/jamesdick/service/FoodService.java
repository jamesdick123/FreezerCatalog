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
        //cycles through to find first food of that name
        for(int i = 0; i<foods.size(); i++) {
            if (name.equalsIgnoreCase(foods.get(i).getName())) { //ignore case for usability
                return foodRepository.findById(foods.get(i).getId()).get();
            }
        }
        return null; //blank return message if nothing found, could possibly return a "not found" message
    }



}

