//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  Object Oriented Programming
// Java Week 05 Lab  
//
package week05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week05OOPLab {

	// This Lab will give you a basic look at creating an Object Oriented Card Game.
	// The idea here is to prepare you for your Week 6 Unit Final Project.
	// There are many ways to implement this Lab, please use the tools that you
	// know, and go from there.
	// These exercises are intended to be coded in order 1 through 5.

	public static void main(String[] args) {

		// A standard deck of playing cards has 52 cards as specified below
		// i. There are 4 suits: Clubs, Diamonds, Hearts, & Spades
		//
		// ii. Each suit has 13 cards: Two, Three, Four, Five, Six, Seven,
		// Eight, Nine, Ten, Jack, Queen, King & Ace
		//
		// iii. Comparing Cards: When comparing two cards, Ace is high and Two is low.
		// to make this easy, a Two will have a value of 2, a
		// Three will have a value of 3, ... and an Ace will have
		// a value of 14.
		//

		// 1. Card Class:
		// Create a class called Card to represent a standard playing card.
		// Fields: The Card class should have the following fields:
		// a. name field
		// b. suit field
		// c. value field for comparing against other cards.
		//
		// Methods: This class can have any useful method.
		// a. describe() to display the card information to the Console.
		// b. Getters & Setters
		//
		System.out.println("\nQuestion 1: Card Class");
		// Add your code here to instantiate a Card
		Card threeOfClubs = new Card("three", "Clubs", 3);

		// Call the describe method on the newly instantiated card.
		threeOfClubs.describe();

		// 2. Deck Class:
		// Create a class called Deck.
		// Fields: This class should have a list of Card field called cards
		// that will hold all the cards in the deck.
		// List<Card> cards = new ArrayList<Card>();
		//
		// Constructor: The constructor for the Deck Class should
		// instantiate all 52 standard playing cards and add them to the cards list.
		
		// Methods:
		//
		// a. describe() to describe the deck to the Console --
		// print out all of the cards in the deck.
		//
		System.out.println("\nQuestion 2: Deck Class");
		// Add your code here to instantiate a Deck
		Deck deck = new Deck();

		// Call the describe method on the newly instantiated deck.
		deck.describe();

		// 3. Deck shuffle() Method:
		// Add a shuffle method within the Deck Class
		System.out.println("\nQuestion 3: Deck shuffle() method");
		// Test your method here
		deck.shuffle();

		// Call the describe method on the newly shuffled deck.
		System.out.println();
		deck.describe();
		
//		deck.shuffle();
//		System.out.println();
//		deck.describe();

		// 4. Deck draw() Method:
		// Add a draw method within the Deck Class
		System.out.println("\nQuestion 4: Deck draw() method");
		// Test your method here
		Card drawnCard = deck.draw();
		System.out.println(String.format("You drew the %s (%d) of %s", drawnCard.getName(), drawnCard.getValue(), drawnCard.getSuit()));
//		System.out.println("\nRemaining cards in deck:\n");
//		deck.describe();

		// 5. Create Game Board:
		// Create and test a method that takes an int as a parameter (representing the
		// number of players for a game) and returns a Map<String, List<Card>>
		// that represents each player (i.e. "Player 1", "Player 2", etc..)
		// and their cards.
		//
		// The method should create a new instance of Deck, shuffle it,
		// and deal the cards out to the "players" in the Map.
		System.out.println("\nQuestion 5: Create Game");
		// Call your method here
		dealCardsToPlayers(2);
		System.out.println();

	}

	// Method 5:

	public static Map<String, List<Card>> dealCardsToPlayers(int numOfPlayers) {
			Deck deck = new Deck();
			deck.shuffle();
			Map<String, List<Card>> players = new HashMap<>();
			List<Card> playerCards = new ArrayList<Card>();
			
			// Check for even number of players or just a single player
			if (numOfPlayers % 2 == 0 || numOfPlayers == 1) {
				// Create a player per numOfPlayers int
				for (int i = 0; i < numOfPlayers; i++) {
					// Use StringBuilder to build the player names to be stored in the Map
					StringBuilder playerName = new StringBuilder();
					playerName.append("Player ");
					playerName.append(i + 1);
//			System.out.println(playerName.toString());

					// Deal cards from deck to players
					// Divide cards evenly
					int cardsPerPlayer = 52 / numOfPlayers;
					while (cardsPerPlayer > 0) {
						// Draw a random card and add it to the player's hand
						Card cardToDeal = deck.draw();
						playerCards.add(cardToDeal);
						// Decrement the remaining number of cards to deal for each player
						cardsPerPlayer--;
					}

					// Add player name and their cards to the Map
					players.put(playerName.toString(), playerCards);
				}
			} else {
				System.out.println("You need an even number of players to play!");
			}
			return players;
	}
	
}