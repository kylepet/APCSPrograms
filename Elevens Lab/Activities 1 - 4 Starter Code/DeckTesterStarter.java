import java.util.List;
import java.util.ArrayList;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTesterStarter {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"jack", "queen", "king", "ace"};
		String[] suits = {"blue", "red"};
		int[] pointValues = {11, 12, 13, 1};
		Deck d = new Deck(ranks, suits, pointValues);

		System.out.println("**** Original Deck Methods ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After 1 Card Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal Remaining 5 Cards ****");
		for (int i = 0; i < 5; i++) {
			System.out.println("  deal: " + d.deal());
		}
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After All Cards Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card From Empty Deck ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		//Shuffle test
		System.out.println("Shuffling deck...");

		d.shuffle();

		System.out.print(d.toString());

		//Test to see if shuffle resets the size back, and just a normal shuffle
		d.deal();
		d.deal();

		d.shuffle();

		System.out.println(d.toString());

		//Test shuffling on empty deck
		d.deal();
		d.deal();
		d.deal();
		d.deal();
		d.deal();
		d.deal();

		d.shuffle();

		System.out.print(d.toString());

		ArrayList<String> test = new ArrayList<String>();



		//Empty arrays
		String[] emptyRanks = {};
		String[] emptySuits = {};
		int[] emptyPointValues = {};

		//Test Shuffling with an empty deck
		Deck emptyD = new Deck(emptyRanks, emptySuits, emptyPointValues);

		System.out.println("Empty deck testing");

		System.out.println("Size of emptyD: " + emptyD.size());

		//print deck
		System.out.println(emptyD.toString());

		//shuffle deck
		System.out.println("Shuffling deck...");
		emptyD.shuffle();
		System.out.println(emptyD.toString());

	}
}
