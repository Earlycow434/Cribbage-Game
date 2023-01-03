package edu.utdallas.cs3354.team15.foundation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Deck class.
 * A stacked collection of cards. Consumers can draw a card, causing the card to be removed from the deck.
 * The deck can also be cut, where the top card is returned from the split deck.
 * 
 * @author      Syed Zaidi
 * @version     %I%, %G%
 */
public class Deck extends CardStack {

	/**
	 * Constructs a Deck
	 */
	public Deck() {
		cards = new ArrayList<Card>();

		// Generate full 52-card set of cards.
		for (Suit suit : Suit.values()) {
			for (int rank = 1; rank <= 13; rank++) {
				int value = (rank > 10) ? 10 : rank;
				cards.add(new Card(suit, rank, value));
			}
		}

		// Shuffle the generated deck.
		Collections.shuffle(cards);
	}

	/**
	 * Draws a card from the top of the deck, returning null if deck is empty.
	 * 
	 * @return Drawn card.
	 * @see Card
	 */
	public Card drawCard() {
		if (cards.isEmpty())
			return null;

		Card tmpCard = cards.get(0);
		cards.remove(0);
		return tmpCard;
	}

	/**
	 * Cuts the deck at provided position and returns top of split deck.
	 * A null card is returned for an empty deck or invalid position.
	 * 
	 * @param position Location in deck to split.
	 * @return Topmost card.
	 * @see Card
	 */
	public Card cut(int position) {
		if(position < 0 || cards.isEmpty() || position > cards.size()-1)
			return null;

		Card tmpCard = cards.get(position);
		cards.remove(position);
		return tmpCard;
	}

	public int getSize(){
		return cards.size();
	}

}
