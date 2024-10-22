package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mocklist for my citylist
     *
     * @return
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    void testHasCity() {
        CustomList cityList = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertTrue(cityList.hasCity(city));

        City city2 = new City("Leduc", "Alberta");

        assertFalse(cityList.hasCity(city2));
    }

    @Test
    void testDeleteCity() {
        CustomList cityList = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        cityList.deleteCity(city);
        assertEquals(1, cityList.countCities());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Code that should throw the exception
            cityList.deleteCity(city);

        });

    }

    @Test
    void testCountCities() {
        CustomList cityList = MockCityList();
        assertEquals(1, cityList.countCities() );

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertEquals(2, cityList.countCities());

    }
}
