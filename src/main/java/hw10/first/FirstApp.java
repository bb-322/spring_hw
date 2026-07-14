package hw10.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FirstApp.class);
        app.setAdditionalProfiles("first");
        app.run(args);
    }
}