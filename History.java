package assignment2;

import java.util.ArrayList; // import the ArrayList class

public class History {
	ArrayList<String> userGuessHistory = new ArrayList<String>(); // Create an ArrayList object to store Guess History

	public void save(String s) {
		userGuessHistory.add(s);
	}

	public void read() {
		for (int i = 0; i < userGuessHistory.size(); i++) {
			System.out.println(userGuessHistory.get(i));
		}

	}

}
