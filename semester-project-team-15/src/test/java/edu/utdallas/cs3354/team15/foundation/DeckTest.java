package edu.utdallas.cs3354.team15.foundation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.Test;

/**
 * The DeckTest class
 * Unit test harness for Deck class.
 * 
 * @author      Syed Zaidi
 * @version     %I%, %G%
 */
public class DeckTest {

	/* Tests Constructor */
	@Test
	public void test_constructor() throws NoSuchFieldException, IllegalAccessException {
		final Deck myDeck = new Deck();
		final Field cardsField = myDeck.getClass().getSuperclass().getDeclaredField("cards");
		cardsField.setAccessible(true);
		Object cardsFieldObject = cardsField.get(myDeck);
		final ArrayList<Card> cards = (ArrayList<Card>)cardsFieldObject;
		assertTrue("Deck was not initialized", cards.size() == 52);
	}

	/* Tests drawCard() */
	@Test
	public void test_drawCard() throws NoSuchFieldException, IllegalAccessException {
		final Deck myDeck = new Deck();
		final Field cardsField = myDeck.getClass().getSuperclass().getDeclaredField("cards");
		cardsField.setAccessible(true);

		Object cardsFieldObject = cardsField.get(myDeck);
		final ArrayList<Card> cards = (ArrayList<Card>)cardsFieldObject;
		final Card firstCard = cards.get(0);
		final Card myCard = myDeck.drawCard();

		assertEquals("Drawn card mismatch", myCard, firstCard);

		// Exhaust the entire deck of cards.
		while (!cards.isEmpty())
			myDeck.drawCard();
		final Card myCardEmpty = myDeck.drawCard();

		assertEquals("Card drawn on empty deck", myCardEmpty, null);
	}

	/* Tests cut() */
	@Test
	public void test_cut() throws NoSuchFieldException, IllegalAccessException {
		final Deck myDeck = new Deck();
		final Field cardsField = myDeck.getClass().getSuperclass().getDeclaredField("cards");
		cardsField.setAccessible(true);

		final Card myCardNull = myDeck.cut(52);
		assertEquals("Deck cut above maximum size", myCardNull, null);

		Object cardsFieldObject = cardsField.get(myDeck);
		final ArrayList<Card> cards = (ArrayList<Card>)cardsFieldObject;
		final Card deckCard = cards.get(24);
		final Card myCardCut = myDeck.cut(24);
		assertEquals("Cut card mismatch", myCardCut, deckCard);
	}
}
