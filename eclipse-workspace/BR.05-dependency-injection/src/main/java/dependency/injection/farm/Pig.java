/**
 * 
 */
package dependency.injection.farm;

import org.springframework.stereotype.Component;

@Component(value = "MyPig")
public class Pig extends FarmAnimal {

	@Override
	protected String makeSound() {
		return "oink";
	}

}
