package com.example.lab8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * Create a mock list for testing the CustomList class.
     * @return a new CustomList with an empty list of cities
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @BeforeEach
    public void setUp() {
        list = MockCityList();
    }

    /**
     * Test the addCity method.
     * Get the size of the list, add a new city, and check
     * if the new size equals the old size plus one.
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        assertEquals(false, list.hasCity(city));
        // Add the city
        list.addCity(city);
        assertEquals(true, list.hasCity(city));
    }
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);

        // Confirm city is in the list
        assertEquals(true, list.hasCity(city));

        // Delete the city
        list.deleteCity(city);

        // Now it should not exist
        assertEquals(false, list.hasCity(city));
    }
    @Test
    public void countCitiesTest() {
        list = MockCityList();
        City city1 = new City("Estevan", "SK");
        City city2 = new City("Regina", "SK");

        assertEquals(0, list.countCities());

        list.addCity(city1);
        assertEquals(1, list.countCities());

        list.addCity(city2);
        assertEquals(2, list.countCities());

        list.deleteCity(city1);
        assertEquals(1, list.countCities());
    }

}
