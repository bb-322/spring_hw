package hw10.second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SecondApp.class);
        app.setAdditionalProfiles("second");
        app.run(args);
    }
}