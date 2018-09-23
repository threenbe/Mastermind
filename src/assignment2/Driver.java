/*  * EE422C Project 2 (Mastermind) submission by
 * Raiyan Chowdhury
 * rac4444
 * Slip days used: 0
 * Spring 2017
 */

package assignment2;

import java.util.Scanner;

public class Driver {
	
	public static void main(String args[]) {
		boolean showCode = false;
		if (args.length > 0) {
			if (args[0].equals("1")) {
				showCode = true;
			}
		}
		
		System.out.println("Welcome to Mastermind.");
		System.out.println("Do you want to play a new game? (Y/N):");
		Scanner sc = new Scanner(System.in);
		String y_n = sc.nextLine();
		
		while (y_n.equals("Y")) {
			Game newGame = new Game(showCode, sc);
			newGame.runGame();
			System.out.println("Do you want to play a new game? (Y/N):");
			y_n = sc.nextLine();
		}
	}
}