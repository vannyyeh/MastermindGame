/*
 * Mastermind
 * Jun 14, 2021
 */

package assignment2;

import java.util.Scanner;

public class Driver {
	private static Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {
		boolean isTesting = true;
		String[] color1 = new String[] { "B", "G", "Y", "R" };
		GameConfiguration config1 = new GameConfiguration(3, color1, 4);
		SecretCodeGenerator generator1 = new SecretCodeGenerator(config1);
		start(isTesting, config1, generator1);
	}

	public static void start(Boolean isTesting, GameConfiguration config, SecretCodeGenerator generator) {
		System.out.println("Welcome to Mastermind.");
		boolean continuePlaying = true;
		while (continuePlaying) {
			Game game = new Game(isTesting, config, generator, sc);
			game.rungame();
		}
	}
}
