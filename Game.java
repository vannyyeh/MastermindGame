package assignment2;

import java.util.Scanner;

public class Game {

	// field to know whether it is in testing mode
	private boolean isTesting;
	private boolean codeRevealed = false;
	// fields to keep track of game
	private int numGuesses = 0;
	// passcode configuration
	private final String PASSCODE;
	private final int PASSCODELENGTH;
	private final int GUESSNUMBER;
	private final String[] COLOR;
	// fields to check status to determine whether game should end
	private boolean gameIsOn;
	private boolean userWins;
	// initialize object
	private Scanner sc;
	private Judge judge;
	private CheckInput checkInput = new CheckInput();
	private History history = new History();

	public Game(boolean isTesting, GameConfiguration config, SecretCodeGenerator generator, Scanner scanner) {
		this.isTesting = isTesting;
		this.sc = scanner;
		PASSCODE = generator.getNewSecretCode();
		PASSCODELENGTH = PASSCODE.length();
		GUESSNUMBER = config.guessNumber;
		COLOR = config.colors;
		judge = new Judge(PASSCODELENGTH);
	}

	public void rungame() {
		askUserPlay();
		while ((numGuesses < GUESSNUMBER) && !userWins && gameIsOn) {
			numGuesses++;
			checkTestingMode();
			System.out.println();
			String guessInput = askUserGuess();
			runGuess(guessInput);

		}
		endGame();

	}

	public void askUserPlay() {
		System.out.println("Do you want to play a new game? (Y/N):");
		String userInput = sc.next();
		if (userInput.equals("Y")) {
			gameIsOn = true;
		} else {
			gameIsOn = false;
			Driver.continuePlaying = false;
		}
	}

	public void checkTestingMode() {
		if (isTesting && !codeRevealed) {
			System.out.println("Secret code: " + PASSCODE);
			codeRevealed = true;
		}
	}

	public String askUserGuess() {
		System.out.println("You have " + (GUESSNUMBER - numGuesses + 1) + " guess(es)left.");
		System.out.println("Enter guess:");
		String userInput = sc.next();
		if (userInput.equals("HISTORY")) {
			history.read();
			System.out.println();
			return askUserGuess();
		}
		if (checkInput.correctGuessInput(userInput, PASSCODELENGTH, COLOR)) {
			return userInput;
		}
		System.out.println("INVALID_GUESS");
		System.out.println();
		return askUserGuess();
	}

	public void runGuess(String guess) {
		String guessResponse = judge.checkGuess(PASSCODE, guess);
		System.out.println(guessResponse);
		history.save(guessResponse);
		if (judge.checkWins()) {
			userWins = true;
		}
	}

	public void endGame() {
		if (userWins) {
			System.out.println("You win!");
			System.out.println();

		} else if (!userWins && gameIsOn) {
			System.out.println("You lose! The pattern was " + PASSCODE);
			System.out.println();
		}
	}

}
