package edu.utdallas.cs3354.team15.foundation;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;

/**
 *  The CardTest class
 *  Unit test harness for the Card class.
 * 
 *  @author        Ben Brothers
 *  @version       %I%, %G% 
 */
public class CardTest {

    /** Tests Constructor */
    @Test
    public void test_constructor() throws NoSuchFieldException, IllegalAccessException {
        final Card myCard = new Card(Suit.Spades, 1, 1);
        final Field suitField = myCard.getClass().getDeclaredField("suit");
        final Field rankField = myCard.getClass().getDeclaredField("rank");
        final Field valueField = myCard.getClass().getDeclaredField("value");
        suitField.setAccessible(true);
        rankField.setAccessible(true);
        valueField.setAccessible(true);
        assertEquals("Constructed Suit Field Mismatch", suitField.get(myCard), Suit.Spades);
        assertEquals("Constructed Rank Field Mismatch", rankField.get(myCard), 1);
        assertEquals("Constructed Value Field Mismatch", valueField.get(myCard), 1);
    }

    /** Tests getSuit() */
    @Test
    public void test_getSuit() throws NoSuchFieldException, IllegalAccessException {
        final Card myCard = new Card(Suit.Spades, 1, 1);
        final Suit suit = myCard.getSuit();
        assertEquals("Suit field returned mismatched value", suit, Suit.Spades);
    }

    /** Tests getRank() */
    @Test
    public void test_getRank() throws NoSuchFieldException, IllegalAccessException {
        final Card myCard = new Card(Suit.Spades, 1, 1);
        final int rank = myCard.getRank();
        assertEquals("Rank field returned mismatched value", rank, 1);
    }

    /** Tests getValue() */
    @Test
    public void test_getValue() throws NoSuchFieldException, IllegalAccessException {
        final Card myCard = new Card(Suit.Spades, 1, 1);
        final int value = myCard.getValue();
        assertEquals("Value field returned mismatched value", value, 1);
    }

}
