package edu.utdallas.cs3354.team15.foundation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.Test;

/**
 * The CribTest class
 * Unit test harness for Crib class.
 * 
 * @author      Syed Zaidi
 * @version     %I%, %G%
 */
public class CribTest {

	/* Tests Constructor */
	@Test
	public void test_constructor() throws NoSuchFieldException, IllegalAccessException {
		final Crib myCrib = new Crib();
		final Field cardsField = myCrib.getClass().getSuperclass().getDeclaredField("cards");
		cardsField.setAccessible(true);
		Object cardsFieldObject = cardsField.get(myCrib);
		final ArrayList<Card> cards = (ArrayList<Card>)cardsFieldObject;
		assertTrue("Crib was not initialized", cards.isEmpty());
	}

	/** Tests addCard() */
	@Test
	public void test_addCard() throws NoSuchFieldException, IllegalAccessException {
		final Crib myCrib = new Crib();
		final Field cardsField = myCrib.getClass().getSuperclass().getDeclaredField("cards");
		cardsField.setAccessible(true);

		final Card myCard = new Card(Suit.Spades, 1,1);
		myCrib.addCard(myCard);
		myCrib.addCard(null);

		Object cardsFieldObject = cardsField.get(myCrib);
		final ArrayList<Card> cards = (ArrayList<Card>)cardsFieldObject;
		assertFalse("Card was not inserted into crib", cards.isEmpty());
		assertEquals("Inserted card mismatch", cards.get(0), myCard);
		assertTrue("Null card inserted", cards.size() == 1);
	}

	/** Tests getCardStack() */
	@Test
	public void test_getCardStack() throws NoSuchFieldException, IllegalAccessException {
		final Crib myCrib =  new Crib();
		final Field cardsField = myCrib.getClass().getSuperclass().getDeclaredField("cards");
		cardsField.setAccessible(true);

		final ArrayList<Card> cribCards = myCrib.getCardStack();

		Object cardsFieldObject = cardsField.get(myCrib);
		final ArrayList<Card> cards = (ArrayList<Card>)cardsFieldObject;
		assertEquals("Crib cards mismatch", cribCards, cards);
	}

}
