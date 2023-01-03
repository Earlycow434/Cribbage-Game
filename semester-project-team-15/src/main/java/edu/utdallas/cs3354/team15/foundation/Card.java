package edu.utdallas.cs3354.team15.foundation;

/**
 * The Card class
 * A generic entity that represents a physical deck card.
 * It's uniqueness is determined by it's rank and suit.
 * Value is necessary for specific rules within the game for cards with a rank
 * greater than 10.
 * Note, after construction, card properties are immutable.
 * 
 * @author Ben Brothers
 * @version %I%, %G%
 */
public class Card {

    /* Class Attributes */
    private Suit suit;
    private int rank;
    private int value;

    /**
     * Constructs a card
     * 
     * @param s The suit of the card
     * @param r The rank of the card
     * @param v The value of the card
     */
    public Card(Suit s, int r, int v) {
        suit = s;
        rank = r;
        value = v;
    }

    /* Member Functions */

    /**
     * Returns the suit
     *
     * @return The suit of the card
     * @see Suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Returns the rank
     * 
     * @return The rank of the card
     */
    public int getRank() {
        return rank;
    }

    /**
     * Returns the value
     * 
     * @return The value of the card
     */
    public int getValue() {
        return value;
    }

}
