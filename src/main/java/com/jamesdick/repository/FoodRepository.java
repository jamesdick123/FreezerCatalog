package com.jamesdick.repository;
import org.springframework.data.repository.CrudRepository;
import com.jamesdick.base.Food;

//crud repository handles everything here
public interface FoodRepository extends CrudRepository<Food, Integer>{
}
