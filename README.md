# Odds and Evens Game

Welcome to the Odds and Evens Game repository! This project is a simple terminal-driven game where a human player competes against an AI opponent named HAL-9000.

## Features

The system allows players to:
- Choose to play as odds or evens
- Play multiple rounds against the AI
- Display the winner of each round
- Track scores across multiple rounds to determine an overall winner

## Command Menu

The system is controlled through a menu of commands, which can be selected by typing the command code and any required arguments. The available commands are:

- `CHOOSE_ODDS_OR_EVENS` [1 argument]    Choose whether to play as odds or evens
- `SHOW_FINGERS`         [1 argument]    Show a number of fingers (0-5)
- `PLAY_ROUND`           [no args]       Play a round against the AI
- `VIEW_SCORE`           [no args]       View the current score
- `HELP`                 [no args]       Print usage
- `EXIT`                 [no args]       Exit the application

## Installation

1. Clone this repository to your local machine:
   ```sh
   git clone https://github.com/buba278/odds-and-evens
   ```
2. Navigate to the project directory:
   ```sh
   cd odds-and-evens-game
   ```
3. Ensure you have Java installed, then use the maven wrapper:

   If on Windows:
   ```sh
   .\mvnw.cmd clean compile exec:java@run
   ```

   If on Unix/Mac OS:
   ```sh
   ./mvnw clean compile exec:java@run
   ```

## Usage

1. Start the application by running the maven wrapper.
2. The terminal will display the command menu.
3. Type the command code and any required arguments to perform an action.
4. Follow any additional prompts to complete the command.

## Implementation

The system is implemented using Object-Oriented Programming (OOP). The main components include:
- `Player`: A class representing the human player with methods to choose odds or evens and show fingers.
- `HAL9000`: A class representing the AI player with methods to predict the human player's moves and show fingers.
- `Game`: A class that manages the game logic, including deciding the winner of each round and tracking scores.
