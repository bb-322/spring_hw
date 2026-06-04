package hw2.task23;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private final String model;
    private String color;
    private int maxSpeed;

    public Car(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public void init() {
        System.out.println("car initialized");
        this.maxSpeed = this.maxSpeed + 10;
    }

}
