/*
 * Cards.java
 * Author: Jonathan Nguyen
 * Submission Date: 12/07/15
 *
 * Purpose: Card class for the Blackjack Project. Deals with cards in the game.
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
import javafx.scene.image.Image;

public class Card {
	
	/**
	 * Suits of a card deck
	 */
	public static enum Suit{
		CLUB, DIAMOND, HEART, SPADE
	}
	
	/**
	 * Types of cards
	 */
	public static enum Type {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	private Suit suit;
	private Type type;
	
	/**
	 * Create a card with Type type and Suit suit
	 * @param type type of the card
	 * @param suit suit of the card
	 */
	public Card(Type type, Suit suit) {
		this.type = type;
		this.suit = suit;
		
	}
	
	/**
	 * Checks if this card equals card c
	 * @param c Card to compare
	 * @return boolean true if the suit and type of the cards match
	 */
	public boolean equals(Card c) {
		boolean cardCheck = false;
		if((this.type == c.type) && (this.suit == c.suit))
		{
			cardCheck = true;
		}
		return cardCheck; //replace this line with your own code
	}
	
	/**
	 * Returns a String representation of the Card (ex. ACE OF SPADES)
	 */
	@Override
	public String toString() {
		String cardPrint = this.type + " OF " + this.suit + "S";
		return cardPrint;
	}
	
	/**
	 * @return the suit of the card
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * @return the type of the card
	 */
	public Type getType() {
		return type;
	}
	/**
	 * Don't worry about this method. This is for the Graphical User Interface
	 * @return the image of the card
	 */
	public Image getImage() {
		return new Image("file:classic-cards/" + this.getType() + "" + this.getSuit() + ".png");
	}
}
