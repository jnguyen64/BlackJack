/*
 * Dealer.java
 * Author: Jonathan Nguyen
 * Submission Date: 12/07/15
 *
 * Purpose: Dealer class for the Blackjack Project. Creates methods used for the dealer.
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
 * The Dealer in your game of BlackJack. Draws until he/she gets 17 points or has 5 cards.
 *
 */
public class Dealer {
	/**
	 * The dealers hand
	 */
	Hand hand;
	
	/**
	 * Construct a new dealer with an empty hand
	 */
	public Dealer() {
		hand = new Hand();
	}
	
	/**
	 * Dealer draws a card if his hand is worth less than 17 points and has less than 5 cards in in his hand.
	 * 
	 * @param deck
	 * @return
	 */
	public Card playTurn(Deck deck) 
	{
		Card d = null;
		if(BlackJack.getValueOfHand(hand) < 17 && hand.size() < 5)
		{
			 d = deck.draw();
			 hand.addCard(d);
		}


		return d;
	}
	
	/**
	 * A method to check if the dealer has busted
	 * @return boolean true if the dealer has busted
	 */
	public boolean busted() {
		boolean bustCheck = false;
		if(BlackJack.getValueOfHand(hand) > 21)
		{
			bustCheck = true;
		}
		return bustCheck;
	}
	
	/**
	 * A method to check if the dealer will draw a card.
	 * @return
	 */
	public boolean isDone() {
		boolean drawCheck = false;
		if(BlackJack.getValueOfHand(hand) > 16 || hand.size() > 4)
		{
			drawCheck = true;
		}
		return drawCheck;
	}
	
	/**
	 * Returns the dealers cards to the deck
	 * @param d Deck to return the cards to
	 */
	public void returnCardstoDeck(Deck d) {
		Card[] temp = hand.emptyHand();
		for(int x = 0; x < temp.length; x++)
		{
			d.addToBottom(temp[x]);
		}

	}
	/**
	 * @return Hand the dealer's hand
	 */
	public Hand getHand() {
		return hand;
	}
}
