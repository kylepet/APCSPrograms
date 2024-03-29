/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 8;

	/**
	 * The number of values to shuffle.
	 */
	private static final int VALUE_COUNT = 17;

	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = new int[VALUE_COUNT];


		for (int i = 0; i < values1.length; i++) {
			values1[i] = i;
			}

			for (int j = 1; j <= SHUFFLE_COUNT; j++) {

			perfectShuffle(values1);

			System.out.print("  " + j + ":");

			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}

			System.out.println();
		}

		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = new int[VALUE_COUNT];
		for (int i = 0; i < values2.length; i++) {
			values2[i] = i;
			}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
    	int[] shuffled = new int[values.length];
		int k = 0;
		int j = values.length / 2;

		if(values.length % 2 == 1)
			j++;

		//Evens
    	for(int count = 0; count < j; count++){
    		shuffled[k] = values[count];

			k += 2;
		}

		k = 1;

		//odds
		for(int count = j; count < values.length ; count++){
    		shuffled[k] = values[count];
			k += 2;
		}

		//Copies the shuffled array to values
		for(int count = 0; count < values.length; count++ ){
			values[count] = shuffled[count];

		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {

		int rand;
		int tempCard;

		for(int k = values.length - 1; k >= 0; k--){

			rand = (int)(Math.random() * k + 1);

			tempCard = values[k];

			values[k] = values[rand];

			values[rand] = tempCard;

		}

		//Copies the shuffled array to values
		for(int count = 0; count < values.length; count++ ){
			values[count] = values[count];


		}

	}


}
