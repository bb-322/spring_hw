package hw6.task5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hw6.task5.objects.FileManager;
import hw6.task5.objects.FileManager2;

@SpringBootApplication
public class Start {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Start.class, args);
		FileManager fileManager = context.getBean(FileManager.class);
		FileManager2 fileManager2 = context.getBean(FileManager2.class);
//		fileManager.getExtensionCount("c:\\Windows\\System32");
		fileManager.getExtensionCount("c:\\Windows\\");
		fileManager.getExtensionCount("c:\\Windows\\system32\\drivers");
		fileManager.getExtensionList("c:\\Windows\\system32\\drivers");

		fileManager2.getExtensionCount("c:\\Windows");
		fileManager2.getExtensionCount("c:\\Windows\\system32\\drivers");
	}
}
