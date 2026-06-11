package hw2.task23;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    static void main() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("context/hw2/task23/appContext.xml");

        Car car = context.getBean(Car.class);
        System.out.println(car);
    }
}
