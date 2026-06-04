package hw2.task4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    static void main() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("hw2/task4/appContext.xml");

        Garage garage = context.getBean(Garage.class);
        garage.getCars();
    }
}
