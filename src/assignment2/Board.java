/*  * EE422C Project 2 (Mastermind) submission by
 * Raiyan Chowdhury
 * rac4444
 * Slip days used: 0
 * Spring 2017
 */

package assignment2;

public class Board extends GameConfiguration {
	String secretCode;
	String[] pastGuesses;
	SmallPegs[] pastFeedback;
	int idx;
	
	public Board() {
		secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
		pastGuesses = new String[guessNumber];
		pastFeedback = new SmallPegs[guessNumber];
		idx = 0;
	}
	
	public String getCode() {
		return secretCode;
	}
	
	public boolean isValid(String guess) {
		if (guess.length() != pegNumber) {
			return false;
		}
		boolean match;
		for (int i = 0; i < pegNumber; i++) {
			match = false;
			for (int k = 0; k < colors.length; k++) {
				if (guess.charAt(i) == colors[k].charAt(0)) {
					match = true;
				}
			}
			if (match == false) return false;
		}
		return true;
	}
	
	public void addGuess(String guess) {
		pastGuesses[idx] = guess;
		SmallPegs feedback = new SmallPegs();
		feedback.setFeedback(secretCode, guess);
		pastFeedback[idx] = feedback;
		idx += 1;
	}
	
	public int getLastBlackPegs() {
		return pastFeedback[idx-1].blackPegs;
	}
	public int getLastWhitePegs() {
		return pastFeedback[idx-1].whitePegs;
	}
	
	public void printHistory() {
		for (int i = 0; i < idx; i++) {
			System.out.print(pastGuesses[i]);
			System.out.print(" -> ");
			System.out.print(pastFeedback[i].blackPegs);
			System.out.print("b_");
			System.out.print(pastFeedback[i].whitePegs);
			System.out.println("w");
		}
	}
}