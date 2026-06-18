package hw6.task5.logging;

import java.util.Map;
import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLogger {

	@Pointcut("execution(* hw6.task5.objects..*(..))")
	private void allMethods() {
	};

	@Around("execution(java.util.Map *(..)) && allMethods() && @annotation(hw6.task5.annotations.ShowTime)")
	public Object watchTime(ProceedingJoinPoint joinpoint) {
		long start = System.currentTimeMillis();
		System.out.println("method begin: " + joinpoint.getSignature().toShortString() + " >>");
		Object output = null;

		for (Object object : joinpoint.getArgs()) {
			System.out.println("Param : " + object);
		}

		try {
			output = joinpoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		long time = System.currentTimeMillis() - start;
		System.out.println("method end: " + joinpoint.getSignature().toShortString() + ", time=" + time + " ms <<");
		System.out.println();

		return output;
	}

	@AfterReturning(pointcut = "execution(java.util.Set *(..)) && allMethods() && @annotation(hw6.task5.annotations.ShowResult)", returning = "obj")
	public void printSet(Object obj) {

		System.out.println("Print info begin >>");

		Set set = (Set) obj;
		for (Object object : set) {
			System.out.println(object);
		}

		System.out.println("Print info end <<");
		System.out.println();

	}

	@AfterReturning(pointcut = "execution(java.util.Map *(..)) && allMethods() && @annotation(hw6.task5.annotations.ShowResult)", returning = "obj")
	public void printMap(Object obj) {

		System.out.println("Print info begin >>");

		Map map = (Map) obj;
		for (Object object : map.keySet()) {
			System.out.println("key=" + object + ", " + map.get(object));
		}

		System.out.println("Print info end <<");
		System.out.println();

	}

}
