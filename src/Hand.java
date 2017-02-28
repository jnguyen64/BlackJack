/*
 * Hand.java
 * Author: Jonathan Nguyen
 * Submission Date: 12/07/15
 *
 * Purpose: Hand class for the Blackjack Project. Deals with the dealer and the player's
 * cards in their hand.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia. 
 */
/**
 * 
 * @author ghyzel
 *
 */
public class Hand {
	
	/**
	 * The cards in the hand
	 */
	private Card [] cards;
	
	/**
	 * Creates an empty hand
	 */
	public Hand() {
		//Initializing an empty array. 
		//Calling cards.length on this array would return 0
		cards = new Card[0];		
	}

	/**
	 * Adds Card c to the hand
	 * 
	 * @param c card to be added
	 */
	public void addCard(Card c) {
		Card[] newHand = new Card [cards.length+1];
		for(int x = 0; x < cards.length; x++)
		{
			newHand[x] = cards[x];
		}
		newHand[newHand.length - 1] = c;
		cards = newHand;
	}
	
	/**
	 * @return number of cards in the hand
	 */
	public int size() {
		int handSize = cards.length;
		return handSize;
	}
	
	/**
	 * Returns an array of all the cards in the hand
	 * 
	 * @return the cards in the hand
	 */
	public Card[] getCards() {
		Card[] copyHand = new Card[cards.length]; 
		for(int x = 0; x < cards.length; x++)
		{
			copyHand[x] = cards[x]; 
		}
		return copyHand;
	}
	
	/**
	 * Empties the hand, and returns an array containing the discarded cards.
	 * 
	 * @return the discarded cards
	 */
	public Card[] emptyHand() {
		Card[] discardHand = new Card[cards.length]; 
		for(int x = 0; x < cards.length; x++)
		{
			discardHand[x] = cards[x]; 
		}
		Card[] cleanHand = new Card[0];
		cards = cleanHand;
		return discardHand;
	}
	
	/**
	 * Returns a String representation of the hand
	 * 
	 * E.g.
	 * 
	 * "Empty Hand"
	 * "1. ACE OF SPADES\n2. QUEEN OF HEARTS"
	 * 
	 * @return a String representing the hand
	 */
	@Override
	public String toString() {
		String handPrint = "";
		for (int x = 0; x < cards.length; x++ )
		{
			handPrint = handPrint + x + ". " + getCards().toString() + "\n";
		}
		// HINT: Use the toString() method of the card class
		if(cards.length == 0)
		{
			handPrint = "Empty hand";
		}
		return handPrint;
	}
}
