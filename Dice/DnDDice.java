import java.util.Scanner;

public class DnDDice {
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean running = true;

		while(running) {
			System.out.print("Select a number of sides for the dice (This dice can not be real): ");
			int input = scan.nextInt();
			DiceCreator six = new DiceCreator(input);
			int roll = six.roll();
			System.out.println("\nThe value of the roll is: " + roll);
			System.out.println("Would you like to roll again? [y/n]");
			String keeprunning = scan.next();
			if (keeprunning.toLowerCase().equals("n")) {
				System.out.println("Thanks for using the Dice Roller!");
				running = false;
				scan.close();
			}
		}
	}
}

