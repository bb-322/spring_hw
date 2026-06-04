package hw2.task23;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "hw2.task23")
public class AppConfig {

    @Bean(initMethod = "init")
    public Car car() {
        Car car = new Car("Audi");
        car.setColor("black");
        car.setMaxSpeed(220);
        return car;
    }

}
