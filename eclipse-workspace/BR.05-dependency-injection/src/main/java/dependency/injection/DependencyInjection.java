/**
 * 
 */
package dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dependency.injection.farm.Animal;

@SpringBootApplication
public class DependencyInjection implements CommandLineRunner {

	@Autowired
	@Qualifier("cow") // if no name is specified, Spring will automatically use the class name converted to camelCase
	private Animal animal;

	public static void main(String[] args) {
		SpringApplication.run(DependencyInjection.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		animal.speak();
	}

}
