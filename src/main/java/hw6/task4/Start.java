package hw6.task4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import hw6.task4.objects.FileManager;

@SpringBootApplication
public class Start {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Start.class, args);
		FileManager fileManager = context.getBean(FileManager.class);
		fileManager.getExtensionCount("c:\\Windows\\System32");
		fileManager.getExtensionCount("c:\\Windows\\");
		fileManager.getExtensionCount("c:\\Windows\\system32\\drivers");

		fileManager.getExtensionList("c:\\Windows\\System32");
		fileManager.getExtensionList("c:\\Windows\\");
		fileManager.getExtensionList("c:\\Windows\\system32\\drivers");
	}
}
