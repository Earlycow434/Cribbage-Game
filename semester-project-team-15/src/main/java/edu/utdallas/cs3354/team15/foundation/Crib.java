package edu.utdallas.cs3354.team15.foundation;

import java.util.ArrayList;

/**
 * The Crib class
 * An initially empty stacked collection of cards. Cards are added to the crib, and cannot be removed. 
 * Upon completion of the round, the crib is emptied and cards return to the deck.
 * 
 * @author      Syed Zaidi
 * @version     %I%, %G%
 */
public class Crib extends CardStack {

	public Crib() {
		cards = new ArrayList<Card>();
	}

	/**
	 * Adds the provied card the crib, with null cards being discarded.
	 * 
	 * @param card Card to add to crib.
	 */
	public void addCard(Card card) {
		if (card != null)
			cards.add(card);
	}

	/**
	 * Returns the crib's current stack of cards.
	 * 
	 * @return ArrayList of cards
	 * @see Card
	 */
	public ArrayList<Card> getCardStack() {
		return cards;
	}

}
