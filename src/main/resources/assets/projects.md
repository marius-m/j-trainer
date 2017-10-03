# Projects 

Mini projects that take more time to achieve result.

Most of the solutions for these problems can be found [here](https://github.com/marius-m/j-basics/tree/master/src/main/java/lt/vcs).

## Guessing game

Simple game that lets players guess a number and score points

- Game has 3 players
- Computer generates a number and players should try to guess it
- Guessing right will award 1 point
- When 5 is scored player wins
- If more than one player has 5 points, play until 1 player has 1 more point

## ATM Machine

Program emulates how ATM machine works. 

- ATM machine has two states, logged in and not logged in.


- Not logged in
	- Will as user to "authenticate itself" (for now leave only one username/password)
	- If authentication fails, ask user to try again.
	- If authentication succeeds, change app state to "Logged in"

- Logged in 
	- User can see the current ballance of his card (eg.: 200$)
	- User can withdraw money (cannot withdraw more than there is on his current ballance)
	- User can bring in money.
	- User can log out of the account (change app state to "Not logged in")

## Hangman game

Game where user tries to guess a word by picking letters one by one. If the letter is in the provided
word, it is revealed in the current word. If it is not, user "looses" a life.

- All words are loaded from the file and stored locally to be used later
- When game starts, random words is picked up from the data store
- There is a high score for getting points in the game
    - 2 points for guessing the correct letter
    - 20 points for guessing the correct word
- Everything should have its own component
    - Component for loading file data
    - Component for storing all loaded file data
    - Component for drawing current state of game (draw hangman, current word status)

## Battle-ship

We'll create a single player game of battle ships. We will be using grid 7x7 to place 3
battle ships on different sizes and create a mechanism to sink the battle ship. We will have a limit
of 20 shots to kill all 3 battle ships in different areas.

- We will need a separate component to draw battle station (map of the battle)
- Algorithm to place battleships randomly on the map
    - Battle ships may be near each other
    - Battle ships cannot intersect each other
- Class that lets you make shots and draw the map of (shot made/missed)

