/*  * EE422C Project 2 (Mastermind) submission by
 * Raiyan Chowdhury
 * rac4444
 * Slip days used: 0
 * Spring 2017
 */

package assignment2;

public class SmallPegs extends GameConfiguration {
	int blackPegs;
	int whitePegs;
	
	public SmallPegs() {
		this.blackPegs = 0;
		this.whitePegs = 0;
	}
	
	public void setFeedback(String secretCode_, String guess_) {
		this.blackPegs = 0;
		this.whitePegs = 0;
		
		if (guess_.equals(secretCode_)) {
			this.blackPegs = pegNumber;
			return;
		}
		
		char[] secretCode = new char[pegNumber];
		for (int i = 0; i < pegNumber; i++) {
			secretCode[i] = secretCode_.charAt(i);
		}
		char[] guess = new char[pegNumber];
		for (int i = 0; i < pegNumber; i++) {
			guess[i] = guess_.charAt(i);
		}
		
		for (int i = 0; i < pegNumber; i++) {
			if (guess[i] == secretCode[i]) {
				this.blackPegs += 1;
				guess[i] = 0;//ensure that this spot doesn't get checked again
				secretCode[i] = 1;
			}
		}
		
		for (int i = 0; i < pegNumber; i++) {
			for (int k = 0; k < pegNumber; k++) {
				if (guess[k] == secretCode[i]) {
					this.whitePegs += 1;
					guess[k] = 0;
					secretCode[i] = 1;
					break;
				}
			}
		}
		
	}
}