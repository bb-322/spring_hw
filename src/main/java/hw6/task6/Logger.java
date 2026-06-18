package hw6.task6;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {

    @AfterThrowing(pointcut = "execution(* hw6.task6..*(..))", throwing = "e")
    public void exceptionLogger (Exception e) {
        System.out.println("exceptionLogger: " + e.getMessage());
    }

}
