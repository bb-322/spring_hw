package hw6.task3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import hw6.task3.objects.FileManager;

@SpringBootApplication
public class Start {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Start.class, args);
		FileManager fileUtil = context.getBean(FileManager.class);
		System.out.println(fileUtil.getExtensionCount("c:\\Windows\\System32"));
		System.out.println(fileUtil.getExtensionCount("c:\\Windows\\"));

		System.out.println(fileUtil.getExtensionList("c:\\Windows\\System32"));
		System.out.println(fileUtil.getExtensionList("c:\\Windows\\"));
	}

}
