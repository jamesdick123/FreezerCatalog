package com.jamesdick.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jamesdick.base.Food;
import com.jamesdick.repository.FoodRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;

@WebMvcTest(FoodService.class)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations="classpath:application-test.properties")
class FoodServiceTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @Mock
    HttpURLConnection connection;
    @MockBean
    FoodRepository foodRepository;
    @MockBean
    FoodService foodService;
    //Food food2 = new Food(2, "Carrot", "Vegetable", 10);
    Food food3 = new Food(3, "Cauliflower", "Vegetable", 5);

    @Test
    void contextLoads() throws Exception {
        assertThat(foodRepository).isNotNull();
    }

    @Test
    void addFoodTest() throws Exception {
        Food food1 = new Food(1, "Chicken", "Meat", 10);
        URL url = new URL("http://localhost:8080/food");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        byte[] out = "{\"id\":\"1\",\"name\":\"chicken\",\"type\":\"meat\",\"quantity\":\"10\"}" .getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        http.connect();
        OutputStream os = http.getOutputStream();
        os.write(out);
        InputStream is = http.getInputStream();
        assertEquals(is.read(), "1");
    }
    @Test
    void getAllFoods() throws Exception {

    }

    @Test
    void getFoodById() {
        Food food1 = new Food(1, "Chicken", "Meat", 2);
        foodRepository.save(food1);
        Food food2;
        food2 = foodRepository.findById(1).get();
        assertEquals("Chicken", food2.getName());
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void delete() {
    }

    @Test
    void getFoodByName() {
    }
}