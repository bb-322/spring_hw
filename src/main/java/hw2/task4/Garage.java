package hw2.task4;

import hw2.task23.Car;

import java.util.Map;

public class Garage {

    private Map<String, Car> cars;

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }

    public void getCars() {
        for (String key : cars.keySet()){
            System.out.println(key + " -> " + cars.get(key));
        }
    }
}
