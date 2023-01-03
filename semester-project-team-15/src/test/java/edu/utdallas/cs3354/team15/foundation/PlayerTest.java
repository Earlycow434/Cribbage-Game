package edu.utdallas.cs3354.team15.foundation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;

import java.lang.reflect.Field;

import org.junit.Test;

/**
 *  The PlayerTest class
 *  Unit test harness for the Player class.
 * 
 *  @author        Ben Brothers
 *  @version       %I%, %G% 
 */
public class PlayerTest {

	/** Tests Constructor() */
	@Test
	public void test_constructor() throws NoSuchFieldException, IllegalAccessException {
		final Player myPlayer = new Player();
		final Field originalHandField = myPlayer.getClass().getDeclaredField("originalHand");
		final Field currentHandField = myPlayer.getClass().getDeclaredField("currentHand");
		final Field pointsField = myPlayer.getClass().getDeclaredField("points");
		final Field isDealerField = myPlayer.getClass().getDeclaredField("isDealer");
		final Field isPlayingField = myPlayer.getClass().getDeclaredField("isPlaying");
		currentHandField.setAccessible(true);
		originalHandField.setAccessible(true);
		pointsField.setAccessible(true);
		isDealerField.setAccessible(true); 
		isPlayingField.setAccessible(true);
		
		assertEquals("Constructed Current Hand Field Mismatch", currentHandField.get(myPlayer), originalHandField.get(myPlayer));
		assertEquals("Constructed Current Hand Field Mismatch", pointsField.get(myPlayer), 0);
		Object isDealerObject = isDealerField.get(myPlayer);
		final boolean isDealer = (boolean)isDealerObject;
		assertFalse("Constructed Current Hand Field Mismatch", isDealer);
		Object isPlayingObject = isPlayingField.get(myPlayer);
		final boolean isPlaying = (boolean)isPlayingObject;
		assertFalse("Constructed Current Hand Field Mismatch", isPlaying);
	}

	/** Tests getCurrentHand() */
	@Test
	public void test_getCurrentHand() throws NoSuchFieldException, IllegalAccessException{
		final Player myPlayer = new Player();
		final Field currentHandField = myPlayer.getClass().getDeclaredField("currentHand");
		currentHandField.setAccessible(true);
		assertEquals("Current Hand field returned mismatched value", currentHandField.get(myPlayer), myPlayer.getCurrentHand());

	}

	/** Tests getOriginalHand() */
	@Test
	public void test_getOriginalHand() throws NoSuchFieldException, IllegalAccessException{
		final Player myPlayer = new Player();
		final Field originalHandField = myPlayer.getClass().getDeclaredField("originalHand");
		originalHandField.setAccessible(true);
		assertEquals("Original Hand field returned mismatched value", originalHandField.get(myPlayer), myPlayer.getOriginalHand());
	}

	/** Tests setHand() */
	@Test
	public void test_setHand() throws NoSuchFieldException, IllegalAccessException{
		final Player myPlayer = new Player();
		final Field currentHandField = myPlayer.getClass().getDeclaredField("currentHand");
		currentHandField.setAccessible(true);

		final Hand hand = new Hand();
		myPlayer.setHand(hand);

		assertEquals("Current Hand Field mismatch", currentHandField.get(myPlayer), hand);

		myPlayer.setHand(null);
		
		assertNotEquals("Hand set to null", currentHandField.get(myPlayer), null);
	}

	/** Tests resetHand() */
	@Test
	public void test_resetHand() throws NoSuchFieldException, IllegalAccessException{
		final Player myPlayer = new Player();
		final Field currentHandField = myPlayer.getClass().getDeclaredField("currentHand");
		final Field originalHandField = myPlayer.getClass().getDeclaredField("originalHand");
		currentHandField.setAccessible(true);
		originalHandField.setAccessible(true);
		
		final Hand hand = new Hand();
		myPlayer.setHand(hand);
		myPlayer.resetHand();
		
		assertEquals("Current and Original Hand Fields mismatch", originalHandField.get(myPlayer), currentHandField.get(myPlayer));
	}

	/** Tests getPoints() */
	@Test
	public void test_getPoints() throws NoSuchFieldException, IllegalAccessException{
		final Player myPlayer = new Player();
		final Field pointsField = myPlayer.getClass().getDeclaredField("points");
		pointsField.setAccessible(true);
		assertEquals("Points field returned mismatched value", pointsField.get(myPlayer), myPlayer.getPoints());
	}

	/** Tests setPoints() */
	@Test
	public void test_setPoints() throws NoSuchFieldException, IllegalAccessException{
		final Player myPlayer = new Player();
		final Field pointsField = myPlayer.getClass().getDeclaredField("points");
		pointsField.setAccessible(true);

		myPlayer.setPoints(1);

		assertEquals("Points Field mismatch", pointsField.get(myPlayer), 1);

		myPlayer.setPoints(0);

		assertEquals("Points set to 0", pointsField.get(myPlayer), 1);

		myPlayer.setPoints(Integer.MAX_VALUE);

		assertEquals("Points set to max", pointsField.get(myPlayer), 1);
	}

	/** Tests setDealer() */
	@Test
	public void test_setDealer() throws NoSuchFieldException, IllegalAccessException{
		final Player myPlayer = new Player();
		final Field dealerField = myPlayer.getClass().getDeclaredField("isDealer");
		dealerField.setAccessible(true);

		myPlayer.setDealer(true);

		assertEquals("Dealer Field mismatch", dealerField.get(myPlayer), true);
	}

	/** Tests setPlaying() */
	@Test
	public void test_setPlaying() throws NoSuchFieldException, IllegalAccessException{
		final Player myPlayer = new Player();
		final Field playingField = myPlayer.getClass().getDeclaredField("isPlaying");
		playingField.setAccessible(true);

		myPlayer.setPlaying(true);

		assertEquals("Playing Field mismatch", playingField.get(myPlayer), true);
	}

	/** Tests isDealer() */
	@Test
	public void test_isDealer() throws NoSuchFieldException, IllegalAccessException{
		final Player myPlayer = new Player();
		final Field dealerField = myPlayer.getClass().getDeclaredField("isDealer");
		dealerField.setAccessible(true);
		assertEquals("Dealer field returned mismatched value", dealerField.get(myPlayer), myPlayer.isDealer());
	}

	/** Tests isPlaying() */
	@Test
	public void test_isPlaying() throws NoSuchFieldException, IllegalAccessException{
		final Player myPlayer = new Player();
		final Field playingField = myPlayer.getClass().getDeclaredField("isPlaying");
		playingField.setAccessible(true);
		assertEquals("Playing field returned mismatched value", playingField.get(myPlayer), myPlayer.isPlaying());
	}
}