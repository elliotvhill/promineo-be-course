package week05;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private List<Player> players = new ArrayList<Player>();
	private String name;
	
	// Constructor -- not using default constructor bc adding field for team name
	public Team(String name) {
		this.setName(name);
	}
	
	// Describe team and print players
	public void describe() {
		System.out.println(String.format("Team name:	%s%n", name));
		for (Player player : players) {
			player.describe();
		}
	}
	
	// Add player to team
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	// Delete player from team
	public void removePlayer(String playerName) {
		for (int i = players.size() - 1; i >= 0; i--) {
			if (players.get(i).getName().equals(playerName)) {
				players.remove(i);
			}
		}
		/* ALTERNATELY can use .removeIf() with Java 8+ */
//		players.removeIf(player -> player.getName().equals(playerName));
	}
	

	// Getters & setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
