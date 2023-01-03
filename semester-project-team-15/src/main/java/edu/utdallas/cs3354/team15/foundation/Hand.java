package edu.utdallas.cs3354.team15.foundation;

import java.util.ArrayList;
import java.util.stream.StreamSupport;

/**
 * The Hand Class
 * A stacked collection of cards. 
 * Cards can be added to the hand and they can also be selected,
 * which causes them to be removed from the hand.
 * 
 * @author Shiqi Wang
 * @version %I%, %G%
 */


public class Hand extends CardStack{
	
	/**
	 *  Constructs a hand
	 */
	public Hand(){
	  cards = new ArrayList<Card>();
	}

	/**
	 *  Adds a card to hand, null cards will be discarded
	 * 
	 * @param card The card
	 */
	public void addCard(Card card){
		if(card != null)
			cards.add(card); 
	}

	/**
	 *  Returns a card from the hand at the provided position
	 * 	If the position is invalid or the hand is empty,
	 * 	no card will be returned
	 * 
	 * @param position The index of the card
	 * @return a card
	 * @see Card
	 */
	public Card selectCard(int position){
		if(position < 0 || this.isEmpty() || position > cards.size())
			return null;
		Card temp = cards.get(position);
		cards.remove(position);
		return temp;
	}

	/**
	 *  Checks if the hand is empty
	 * 
	 * @return True or False
	 * @see Boolean
	 */
	public Boolean isEmpty(){
		return StreamSupport.stream(cards.spliterator(), true).allMatch(o -> o == null);
	}

	public ArrayList<Card> getHand(){
		return cards;
	}
 }