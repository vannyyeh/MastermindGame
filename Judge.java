package assignment2;

public class Judge {
	private final int CORRECTBLACKNUMBER;
	private int blackPeg;
	private int whitePeg;

	public Judge(int PASSCODELENGTH) {
		CORRECTBLACKNUMBER = PASSCODELENGTH;
	}

	public String checkGuess(String passcode, String guess) {
		char[] passcodeArr = passcode.toCharArray();
		char[] guessArr = guess.toCharArray();
		blackPeg = 0;
		whitePeg = 0;

		for (int i = 0; i < passcodeArr.length; i++) { // check for correct letter AND position
			if (guessArr[i] == passcodeArr[i]) {
				// to replace guessArr[i] and passcodeArr[i] so it isn't counted again
				passcodeArr[i] = 'k';
				guessArr[i] = 'g';
				blackPeg++;

			}
		}
		for (int i = 0; i < guess.length(); i++) { // check for correct letter only
			for (int j = 0; j < passcodeArr.length; j++) {
				if (guessArr[i] == passcodeArr[j]) {
					passcodeArr[j] = 'k';
					whitePeg++;

					break;
				}
			}
		}

		String responseOutput = guess + " - >" + blackPeg + "b" + "_" + whitePeg + "w";
		return responseOutput;
	}

	public boolean checkWins() {
		if (blackPeg == CORRECTBLACKNUMBER)
			return true;
		return false;
	}
}
