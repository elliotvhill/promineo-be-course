package week05;

public class Player {
	
	private String name, position, specialty;
	
	// Constructor:
	public Player(String name, String position, String specialty) {
		this.name = name;
		this.position = position;
		this.specialty = specialty;
	}
	
	public void describe() {
		System.out.println(String.format("Player:		%s%nPosition:	%s%nSpecialty:	%s%n", name, position, specialty));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	};

}
