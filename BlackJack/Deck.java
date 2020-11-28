import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * This class handles all the functions related to the deck
 * of cards used while playing.
 * @author Wesley Long
 * All of this work is mine unless otherwise stated.
 */

public class Deck {
	private static ArrayList<String> deal; 
	private static ArrayList<String> used;

	/**
	 * Constructor for initiallizing the main deck of cards
	 * and the discard pile.
	 */
	public Deck() {
		deal = new ArrayList<String>();
		used = new ArrayList<String>();
	}


	/**
	 * This method fills the "deal" ArrayList with all
	 * the cards needed to create a 52 card deck.
	 * @throws IOException
	 */
	public void createDeck() throws IOException {
		Scanner read = new Scanner(new File("cards.txt"));
		while (read.hasNextLine()) {
      		String str = read.nextLine();
			deal.add(str);
			deal.add(str);
			deal.add(str);
			deal.add(str);
		}
	}

	/**
	 * This function draws a card anf add's it to the hand that is specified.
	 * This function is named "hit" as that is the term used in blackjack.
	 * @return
	 */
	public String hit(Hand draw) {
		Random rand = new Random();
		int card = 0;
		if (deal.size() == 1) {
			card = 0;
		} else {
			card = rand.nextInt(deal.size() - 1);
		}
		
		String dealtCard = deal.get(card);
		draw.addToHand(dealtCard);
		deal.remove(card);

		if (deal.size() == 0) {
			shuffle();
		}
		return dealtCard;
	}

	public void discard(String str) {
		used.add(str);
	}

	/**
	 * Puts the contents of the discard ArrayList into the deal ArrayList.
	 */
	public void shuffle() {
		// deal.clear();
		// deal.trimToSize();
		deal = (ArrayList<String>) used.clone();
		System.out.println("Shuffling deck...");
		used.clear();
	}
}