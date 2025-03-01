/**
 * 
 */
package dependency.injection.farm;

import org.springframework.stereotype.Component;

@Component
public class Cow extends FarmAnimal {

	@Override
	protected String makeSound() {
		return "moo";
	}

}
