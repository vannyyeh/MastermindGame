package assignment2;

import java.util.Arrays;

public class CheckInput {
	boolean contains;
	String userInputString;

	public boolean correctGuessInput(String userInput, int passcodeLength, String[] color) {
		if (userInput.length() == passcodeLength) {
			for (int i = 0; i < userInput.length(); i++) {

				userInputString = String.valueOf(userInput.charAt(i));
				contains = Arrays.asList(color).contains(userInputString);
				if (!contains) {
					return false;
				}
			}
			return true;

		} else {
			return false;
		}

	}

}