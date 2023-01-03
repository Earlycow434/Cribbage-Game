package edu.utdallas.cs3354.team15.foundation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.Test;

/**
 *  The HandTest class
 *  Unit test harness for the Hand class.
 * 
 *  @author        Shiqi Wang
 *  @version       %I%, %G% 
 */
public class HandTest {

	/** Tests Constructor */
	@Test
	public void test_constructor() throws NoSuchFieldException, IllegalAccessException {
		final Hand myHand = new Hand();
		final Field cardsField = myHand.getClass().getSuperclass().getDeclaredField("cards");
		cardsField.setAccessible(true);
		Object cardsFieldObject = cardsField.get(myHand);
		final ArrayList<Card> cards = (ArrayList<Card>)cardsFieldObject;
		assertTrue("Hand was not initialized", cards.isEmpty());
	}

	/** Tests addCard() */
	@Test
	public void test_addCard() throws NoSuchFieldException, IllegalAccessException {
		final Hand myHand = new Hand();
		final Card myCard = new Card(Suit.Spades, 1,1);
		final Field cardsField = myHand.getClass().getSuperclass().getDeclaredField("cards");
		cardsField.setAccessible(true);
		myHand.addCard(myCard);
		myHand.addCard(null);
		Object cardsFieldObject = cardsField.get(myHand);
		final ArrayList<Card> cards = (ArrayList<Card>)cardsFieldObject;
		assertFalse("Card was not inserted into hand", cards.isEmpty());
		assertEquals("Inserted card mismatch", cards.get(0), myCard);
		assertTrue("Null card inserted", cards.size() == 1);
	}

	/** Tests selectCard() */
	@Test
	public void test_selectCard() throws NoSuchFieldException, IllegalAccessException {
		final Hand myHand = new Hand();
		final Card myCard1 = new Card(Suit.Spades, 1,1);
		final Card myCard2 = new Card(Suit.Diamonds, 2,2);
		final Card myCard3 = new Card(Suit.Hearts, 3,3);
		final Field cardsField = myHand.getClass().getSuperclass().getDeclaredField("cards");
		assertEquals("Selected card on empty hand", myHand.selectCard(0), null);
		myHand.addCard(myCard1);
		myHand.addCard(myCard2);
		myHand.addCard(myCard3);
		Object cardsFieldObject = cardsField.get(myHand);
		final ArrayList<Card> cards = (ArrayList<Card>)cardsFieldObject;
		Card selectedCard1 = myHand.selectCard(0);
		assertEquals("Card1 not removed from hand", cards.get(0), null);
		Card selectedCard2 = myHand.selectCard(1);
		assertEquals("Card2 not removed from hand", cards.get(1), null);
		Card selectedCard3 = myHand.selectCard(2);
		assertEquals("Card3 not removed from hand", cards.get(2), null);
		assertEquals("Position less than 0", myHand.selectCard(-1), null);
		assertEquals("Position greater than hand size", myHand.selectCard(3), null);
		assertEquals("Selected cards not removed from hand", myHand.selectCard(0), null);
		assertEquals("Selected card1 mismatch", selectedCard1, myCard1);
		assertEquals("Selected card2 mismatch", selectedCard2, myCard2);
		assertEquals("Selected card3 mismatch", selectedCard3, myCard3);
	}

	/** Tests isEmpty() */
	@Test
	public void test_isEmpty() throws NoSuchFieldException, IllegalAccessException {
		final Hand myHand = new Hand();
		final Field cardsField = myHand.getClass().getSuperclass().getDeclaredField("cards");
		cardsField.setAccessible(true);
		Object cardsFieldObject = cardsField.get(myHand);
		final ArrayList<Card> cards = (ArrayList<Card>)cardsFieldObject;
		assertEquals("Hand was not empty", cards.isEmpty(), myHand.isEmpty());
	}

}
