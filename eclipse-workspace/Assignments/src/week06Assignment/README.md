# Week 6 Assignment: WAR Card Game

Repository for submission for week 5 coding assignment.

## Instructions 

Follow the **Exercises** below to complete this assignment.

- In Eclipse, or an IDE of your choice, write the code that accomplishes the objectives listed below. Ensure that the code compiles and runs as directed.

- Create a new repository on GitHub for this week’s assignment and push your completed code to this dedicated repo.

- Create a video showcasing your work:

    - In this video: record and present your project verbally while showing the results of the working project.   Don’t forget to include the required functionality.

    - _Easy way to Create a video:_  Start a meeting in Zoom, share your screen, open Eclipse with the code and your Console window, start recording & record yourself describing and running the program showing the results. When you click "End Meeting" it will save the video on your computer.

    - Create a video, up to five minutes max, showing and explaining how your project works with an emphasis on the portions you contributed.

    - This video should be done using screen share and voice over.  

- This should then be uploaded to a publicly accessible site, such as YouTube. Ensure the link you share is PUBLIC or UNLISTED!

- _(If it is not accessible by your grader, your project will be graded based on what they can access.)_


## Preview

For the final project you will be creating an automated version of the classic card game _WAR_, using classes and objects.

**Here are some tips and suggestions as you proceed:**

1. You will create Classes with fields & methods for the following:

    - Card
    - Deck
    - Player

2.  You will create an application class, `App`, which has a `main` method and which will use the classes created above to accomplish the goal of this project, instantiating each of the objects as needed.
    - We suggest one `Deck`, with 52 `Card`s, and 2 `Player`s.  Remember to create getters, setters and constructors for each of these.

3.  As your Final Java Project, this assignment will be written in Java, and will use much of what you have learned so far, including variables, loops, methods, classes, instantiation of objects, and more.

4. Start with the basics.  Follow the instructions. 

**Remember:**  this project is a simple, automated version of the card game WAR.  The idea is to have it run automatically.  



## Exercises

### 1. Create the following classes:

**Card**

- Fields:

    1. `value` (contains a value from 2-14 representing cards 2-Ace)
    2. `name` (e.g. Ace of Diamonds, or Two of Hearts)

- Methods:

    1. Getters and Setters
    2. `describe` (prints out information about a card)

**Deck**

- Fields:

    1. `cards` (`List` of `Card`)

- Methods:

    1. `shuffle` (randomizes the order of the cards)

    2. `draw` (removes and returns the top card of the Cards field)

    3. In the constructor, when a new `Deck` is instantiated, the `Cards` field should be populated with the standard 52 cards.


**Player**

- Fields:

    1. `hand` (`List` of `Card`)
    2. `score` (set to 0 in the constructor)
    3. `name`

- Methods:

    1. `describe` (prints out information about the player and calls the describe method for each card in the Hand List)
    2. `flip` (removes and returns the top card of the Hand)
    3. `draw` (takes a Deck as an argument and calls the draw method on the deck, adding the returned Card to the hand field)
    4. `incrementScore` (adds 1 to the Player’s score field)

### 2. Create a class called `App` with a `main` method.

- Instantiate a `Deck` and two `Player`s, call the `shuffle` method on the deck.

- Using a traditional `for` loop, iterate 52 times calling the `Draw` method on the other player each iteration using the `Deck` you instantiated.

- Using a traditional `for` loop, iterate 26 times and call the `flip` method for each player.

    - Compare the value of each card returned by the two players' `flip` methods. Call the `incrementScore` method on the player whose card has the higher value.  Print a message to say which player received a point.

    - _**Note:**  If the values are equal (it is a tie), print a message saying that no point was awarded._

- After the loop, compare the final score from each player.

- Print the final score of each player and either `Player 1`, `Player 2`, or `Draw` depending on which score is higher or if they are both the same.

 
### 3.  Tips

Printing out information throughout the game adds value, including easier debugging as you progress and a better user experience.

- Using the Card `describe()` method when each card is flipped illustrates the game play.
- Printing the winner of each turn adds interest -- or a message indicating a tie.
- Printing the updated score after each turn shows game progression.
- At the end of the game: print the final score of each player and the winner’s name or `Draw` if the result is a tie.