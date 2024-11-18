package week03;

import java.util.Scanner;

public class Week03TeamMenuApp {

	static Scanner s = new Scanner(System.in); // if outside main, Scanner has to be 'static'
	
//	Keep track of where we are in array when adding team members
	static int addingIndex = 0;
	
	public static void main(String[] args) {
		
		/*
		 * Add team member
		 * View team member
		 * View all team members
		 * Delete team member by position
		 * Delete all team members
		 */
		
		String[] team = new String[5];
		int decision = 0;
		
//		While loop to keep app running until user exits
		while (decision != -1) {
			showMenu();
			
//			Get user menu choice
			decision = s.nextInt();
			
//			Example from video approach:
			
//			if (decision < -1 || decision > 5) {
//				System.out.println("Please pick a valid option.");
//			} else if (decision == 1) {
//				showTeam(team);
//			} else if (decision == 2) {
//				showTeamMember(team);
//			} else if (decision == 3) {
//				addTeamMember(team);
//			} else if (decision == 4) {
//				deleteTeamMember(team);
//			} else {
//				deleteTeam(team);
//			}
			
//			
//			My approach: 
			
			switch (decision) {
			case 1:
				showTeam(team);
				break;
			case 2:
				showTeamMember(team);
				break;
			case 3:
				addTeamMember(team);
				break;
			case 4:
				deleteTeamMember(team);
				break;
			case 5:
				deleteTeam(team);
				break;
			default:
				System.out.println("Please pick a valid option.");
				break;
			}
		}

	}
	
	public static void showMenu() {
		System.out.println("Please pick an option or enter -1 to exit.");
		System.out.println("1) Show team");
		System.out.println("2) Show team member");
		System.out.println("3) Add team member");
		System.out.println("4) Delete team member");
		System.out.println("5) Delete all team members");
	}
	
	public static void showTeam(String[] team) {
		System.out.println("Team:");
		for (int i = 0; i < team.length; i++) {
			System.out.println(i + ": " + team[i]);
		}
	}
	
	public static void showTeamMember(String[] team) {
//		Get team member index
		System.out.print("Which team member would you like to see? ");
		int teamNumber = s.nextInt();
		
//		Check for valid input
		if (isValid(teamNumber)) {
			System.out.println(teamNumber + ": " + team[teamNumber]);
		}
		
	}
	
	public static void addTeamMember(String[] team) {
		System.out.print("Enter new member name: ");
		String newNumber = s.next();
		
		if (isValid(addingIndex)) {
			team[addingIndex++] = newNumber;
		}
		
	}
	
	public static void deleteTeamMember(String[] team) {
		System.out.print("Which team member would you like to delete? ");
		int memberToDelete = s.nextInt();
		
		if (isValid(memberToDelete)) {
			System.out.println("Team member " + team[memberToDelete] + " deleted.");
			team[memberToDelete] = null;
		}
	}
	
	public static void deleteTeam(String[] team) {
		for (int i = 0; i < team.length; i++) {
			team[i] = null;
		}
		System.out.println("Team deleted.");
	}
	
	public static boolean isValid(int input) {
		if (input >= 0 && input < 5) {
			return true;
		} else {
			System.out.println("Invalid entry");
			return false;
		}
	}

}









