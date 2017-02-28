/*
 * BlackJack.java
 * Author: Jonathan Nguyen
 * Submission Date: 12/07/15
 *
 * Purpose: BlackJack class for the Blackjack Project. Creates methods used for 
 * the game itself.
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
 * Class representing a single player blackjack game
 */
public class BlackJack {
	
	private Deck deck;
	private Dealer dealer;
	private Player player;


	/**
	 * Constructs and prepares for a new game of BlackJack.
	 * Creates player, dealer and deck objects then shuffles
	 * the deck and gives both the dealer and player two cards.
	 */
	public BlackJack() {
		player = new Player();
		dealer = new Dealer();
		deck = new Deck();
	
		deck.shuffle();
		player.getHand().addCard(deck.draw());
		player.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());
	}
	/**
	 * Restarts in a few steps
	 * 1. The Player and dealer return their cards to the deck.
	 * 2. The deck is shuffled.
	 * 3. Both the player and the dealer receive two cards drawn form the top of the deck.
	 */
	public void restart() {
		player.returnCardstoDeck(deck);
		dealer.returnCardstoDeck(deck);
		deck.shuffle();
		player.getHand().addCard(deck.draw());
		player.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());

	}
	/**
	 * Returns the value of a card in a standard game of Blackjack based on the type of the card
	 * ex. An Ace would return 1, a 2 would return 2... 
	 * @param c card whose value is extracted
	 * @return value of the card
	 */
	public static int getValueOfCard(Card c) {
		int cardVal = 0;
		String cardType = "" + c.getType();
		if(cardType.equals("ACE"))
		{
			cardVal = 1;
		}
		
		if(cardType.equals("TWO"))
		{
			cardVal = 2;
		}
		if(cardType.equals("THREE"))
		{
			cardVal = 3;
		}
		if(cardType.equals("FOUR"))
		{
			cardVal = 4;
		}
		if(cardType.equals("FIVE"))
		{
			cardVal = 5;
		}
		if(cardType.equals("SIX"))
		{
			cardVal = 6;
		}
		if(cardType.equals("SEVEN"))
		{
			cardVal = 7;
		}
		if(cardType.equals("EIGHT"))
		{
			cardVal = 8;
		}
		if(cardType.equals("NINE"))
		{
			cardVal = 9;
		}
		
		if(cardType.equals("TEN") || cardType.equals("JACK") ||
				cardType.equals("QUEEN") || cardType.equals("KING"))
		{
			cardVal = 10;
		}
		return cardVal;
	}
	/**
	 * Returns the maximum value of the hand that does not result in a bust
	 * @param h Hand whose value is returned
	 * @return value of h
	 */
	public static int getValueOfHand(Hand h) {
		int handVal = 0;
		int aceCount = 0;
		boolean aceCheck = false;
		Card[] z = h.getCards();
		for(int x = 0; x<z.length; x++)
		{
			handVal += getValueOfCard(z[x]);
			if(getValueOfCard(z[x]) == 1)
			{
				aceCount++;
			}
		}
		if(aceCount > 0 && handVal < 21)
		{
			handVal = handVal + (aceCount * 10);
			aceCheck = true;
		}
		if(aceCount > 0 && handVal > 21 && aceCheck == true)
		{
			handVal = handVal - (aceCount * 10);
		}
		return handVal;
	}

	/**
	 * @return Deck used to play
	 */
	public Deck getDeck() {
		return deck;
	}
	
	/**
	 * @return Dealer of the game
	 */
	public Dealer getDealer() {
		return dealer;
	}
	
	/**
	 * @return Player playing the blackjack game
	 */
	public Player getPlayer() {
		return player;
	}

}
