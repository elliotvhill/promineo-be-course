package week05Quiz;

public class Cat implements Animal {

	@Override
	public void speak() {
		System.out.println("Meow");
	}

	@Override
	public void eat() {
		System.out.println("Fish");
	}

}
