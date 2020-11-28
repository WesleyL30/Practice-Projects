import java.util.Random;

public class DiceCreator {

	private int numberOfSides;
	private Random rand = new Random();

	public DiceCreator(int sides) {
		numberOfSides = sides;
	}

	public int roll() {
		int value = (rand.nextInt(numberOfSides) + 1);
		return value;
	}
}