import java.io.IOException;
import java.util.Scanner;

public class Dealer {
	// public static void clearScreen() {
    // 	System.out.print("\033[H\033[2J");
    // 	System.out.flush();
  	// }
	public static void main(String[] args) {
		int wins = 0;
		int losses = 0;
		int ties = 0;
		Deck firstDeck = new Deck();
		Hand player = new Hand();
		Hand dealer = new Hand();

		try {
			firstDeck.createDeck();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// clearScreen();
		System.out.println("Welcome to BlackJack: ");
		Scanner scan = new Scanner(System.in);
		boolean playing = true;
		while (playing) {
			boolean playerPlaying = true;
			boolean playerBusted = false;
			boolean dealerBusted = false;
			firstDeck.hit(player);
			firstDeck.hit(player);
			firstDeck.hit(dealer);
			firstDeck.hit(dealer);
			while (playerPlaying) {
				System.out.println("Your current hand is: ");
				player.getHand(0);
				System.out.println("\nYour current score is: " + player.calulateHand());
				System.out.println("\nDealer's Shown card: ");
				dealer.getHand(1);
				if (player.calulateHand() == 21) {
					System.out.println("BlackJack!");
					playerPlaying = false;
				} else {
					System.out.print("\n\nWould you like to hit[h] or stay[s]: ");
					String input = scan.next();
					if (input.toLowerCase().equals("h")) {
						firstDeck.hit(player);
						if (player.calulateHand() > 21) {
							playerBusted = true;
							System.out.println("\n\nYou busted:");
							System.out.println("Your current hand is: ");
							player.getHand(0);
							System.out.println("\nCurrent Score: " + player.calulateHand());
							playerPlaying = false;
						} else if (player.calulateHand() == 21) {
							System.out.println("\n\nBlackJack!");
							playerPlaying = false;
						}
					} else if (input.toLowerCase().equals("s")) {
						System.out.println("\n\nCurrent Score: " + player.calulateHand());
						System.out.println(" ");
						System.out.println("Your hand is: ");
						player.getHand(0);
						playerPlaying = false;
					} else {
						System.out.println("Please enter a valid input");
					}
				}
			}

			boolean dealerPlaying = true;
			while (dealerPlaying) {
				System.out.println("\n\nDealer's current hand is: ");
				dealer.getHand(0);
				System.out.println("\nDealer's Score: " + dealer.calulateHand());
				if (playerBusted) {
					dealerPlaying = false;
				} else if (dealer.calulateHand() == 16) {
					firstDeck.hit(dealer);
					dealerPlaying = false;
				} else if (dealer.calulateHand() == 17) {
					dealerPlaying = false;
				} else if (dealer.calulateHand() == 21) {
					System.out.println("BlackJack!");
					dealer.getHand(0);
					System.out.println("\n");
					dealerPlaying = false;
				} else if (dealer.calulateHand() < player.calulateHand()) {
					firstDeck.hit(dealer);
				}  else if (dealer.calulateHand() > 21) {
					dealerBusted = true;
					dealerPlaying = false;
				} else if (dealer.calulateHand() >= player.calulateHand()){
					dealerPlaying = false;
				}
			}

			if (playerBusted && dealerBusted) {
				losses++;
			} else if (playerBusted) {
				losses ++;
			} else if (dealerBusted) {
				wins++;
			} else if (dealer.calulateHand() > player.calulateHand()) {
				losses++;
			} else if (dealer.calulateHand() < player.calulateHand()) {
				wins++;
			} else if (dealer.calulateHand() == player.calulateHand()) {
				ties++;
			}

			System.out.println("\n\nCurrent record: \nWins: " + wins + "\nTies: " + ties + "\nLosses: " + losses);
			System.out.println("Dealer busted: " + dealerBusted + "\nPlayer busted: " + playerBusted);
			System.out.print("\nWould you like to keep playing? [y/n]: ");
			String keepPlaying = scan.next();
			if (keepPlaying.toLowerCase().equals("y")) {
				// clearScreen();
				System.out.println("Welcome to blackjack: ");
				player.emptyHand();
				dealer.emptyHand();
				playerBusted = false;
				dealerBusted = false;
			} else if (keepPlaying.toLowerCase().equals("n")) {
				System.out.println("Thanks for using this program!");
				playing = false;
			}
		}
		scan.close();
	}
}