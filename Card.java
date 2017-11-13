public class Card {
	public enum Suit {Club, Diamond, Heart, Spade}
	private Suit suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; // 1~13

	/**
	 * @param s
	 *            suit
	 * @param r
	 *            rank
	 */
	public Card(Suit s, int value) {
		suit = s;
		rank = value;
	}

	// TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10
	// for rank)
	public void printCard() {
		// Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as
		// Clubs Ace
		String rank = "";
		switch (getRank()) {
		case 1:
			rank = "Ace";
			break;
		case 2:
			rank = "Two";
			break;
		case 3:
			rank = "Three";
			break;
		case 4:
			rank = "Four";
			break;
		case 5:
			rank = "Five";
			break;
		case 6:
			rank = "Six";
			break;
		case 7:
			rank = "Seven";
			break;
		case 8:
			rank = "Eight";
			break;
		case 9:
			rank = "Nine";
			break;
		case 10:
			rank = "Ten";
			break;
		case 11:
			rank = "Jack";
			break;
		case 12:
			rank = "Queen";
			break;
		case 13:
			rank = "King";
			break;
		}
		System.out.print(getSuit() + " " + rank +"\n");
	}

	public Suit getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

}
