/**
 * 
 */
package dependency.injection.farm;

public abstract class FarmAnimal implements Animal {

	protected abstract String makeSound();

	@Override
	public void speak() {
		System.out.println("The " + this + " says " + makeSound() + ".");
	}

	@Override
	public String toString() {
		return super.getClass().getSimpleName();
	}

}
