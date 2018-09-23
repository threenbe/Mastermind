/*  * EE422C Project 2 (Mastermind) submission by
 * Raiyan Chowdhury
 * rac4444
 * Slip days used: 0
 * Spring 2017
 */

package assignment2;

import java.util.Scanner;

public class Game extends GameConfiguration {
	boolean showCode;
	Scanner sc;
	int guessesLeft;
	boolean gameWon;
	
	public Game(boolean showCode, Scanner scan) {
		this.showCode = showCode;
		this.sc = scan;
		guessesLeft = guessNumber;
		gameWon = false;
	}
	
	public void runGame() {
		Board gameBoard = new Board();
		if (showCode) {
			System.out.print("Secret code: ");
			System.out.println(gameBoard.getCode());
		}
		
		String guess;
		while (gameWon == false && guessesLeft != 0) {
			System.out.println();
			System.out.println("You have " + guessesLeft + " guess(es) left.");
			System.out.println("Enter guess:");
			guess = sc.nextLine();
			
			if (guess.equals("HISTORY")) {
				gameBoard.printHistory();
				continue;
			}
			
			if (gameBoard.isValid(guess) == false) {
				System.out.println("INVALID_GUESS");
			} else {
				gameBoard.addGuess(guess);
				guessesLeft -= 1;
				System.out.print(guess);
				System.out.print(" -> ");
				int bPegs = gameBoard.getLastBlackPegs();
				int wPegs = gameBoard.getLastWhitePegs();
				System.out.print(bPegs);
				System.out.print("b_");
				System.out.print(wPegs);
				System.out.println("w");
				
				if (bPegs == pegNumber) gameWon = true;
				
			}
			
		}
		
		if (gameWon) {
			System.out.println("You win!");
		} else {
			System.out.print("You lose! The pattern was ");
			System.out.println(gameBoard.getCode());
		}
		System.out.println();
	}
}