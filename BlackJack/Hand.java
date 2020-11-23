import java.util.ArrayList;

/**
 * This class handles all of the functions relating to the hand
 */

public class Hand {
	private ArrayList<String> currentHand;

	public Hand() {
		currentHand = new ArrayList<String>();
	}

	public void addToHand(String card) {
		currentHand.add(card);
	}

	public void emptyHand() {
		currentHand.clear();
	}

	public void getHand(int displacement) {
		for (int i = 0 + displacement; i <= currentHand.size() - 1; i++) {
			String str = currentHand.get(i);
			System.out.print("[" + str + "]");
		}
	}

	public int calulateHand() {
		int currentScore = 0;
		boolean hasAce = false;
		for (int i = 0; i <= currentHand.size() - 1; i++) {
			String card = currentHand.get(i);
			switch (card) {
				case "Ace":
					if ((currentScore + 1) > 21 && hasAce) {
						hasAce = false;
						currentScore -= 9;
					} else if (currentScore >= 11) {
						currentScore += 1;
					} else {
						currentScore += 11;
						hasAce = true;
					}
					break;

				case "2": 
					if ((currentScore + 2) > 21 && hasAce) {
						hasAce = false;
						currentScore -= 8;
					} else {
						currentScore += 2;
					}
					break;

				case "3":
					if ((currentScore + 3) > 21 && hasAce) {
						hasAce = false;
						currentScore -= 7;
					} else {
						currentScore += 3;
					}
					break;

				case "4": 
					if ((currentScore + 4) > 21 && hasAce) {
						hasAce = false;
						currentScore -= 6;
					} else {
						currentScore += 4;
					}
					break;

				case "5": 
					if ((currentScore + 5) > 21 && hasAce) {
						hasAce = false;
						currentScore -= 5;
					} else {
						currentScore += 5;
					}
					break;

				case "6": 
					if ((currentScore + 6) > 21 && hasAce) {
						hasAce = false;
						currentScore -= 4;
					} else {
						currentScore += 6;
					}
					break;

				case "7": 
					if ((currentScore + 7) > 21 && hasAce) {
						hasAce = false;
						currentScore -= 3;
					} else {
						currentScore += 7;
					}
					break;

				case "8": 
					if ((currentScore + 8) > 21 && hasAce) {
						hasAce = false;
						currentScore -= 2;
					} else {
						currentScore += 8;
					}
					break;

				case "9": 
					if ((currentScore + 9) > 21 && hasAce) {
						hasAce = false;
						currentScore -= 1;
					} else {
						currentScore += 9;
					}
					break;

				case "10":
				case "Jack": 
				case "Queen":
				case "King": 
					if ((currentScore + 10) > 21 && hasAce) {
						hasAce = false;
					} else {
						currentScore += 10;
					}
					break;
			}
		}
		return currentScore;
	}
}
