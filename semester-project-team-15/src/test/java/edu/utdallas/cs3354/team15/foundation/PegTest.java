package edu.utdallas.cs3354.team15.foundation;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;

/**
 * The PegTest Class
 * Unit test harness for PegTest class
 * 
 * @author Shiqi Wang
 * @version %I%, %G%
 */
public class PegTest {

    /** Tests Constructor */
    @Test
    public void test_constructor() throws NoSuchFieldException, IllegalAccessException {
        final Peg myPeg = new Peg(0, (short) 0);
        final Field positionField = myPeg.getClass().getDeclaredField("position");
        final Field trackField = myPeg.getClass().getDeclaredField("track");
        positionField.setAccessible(true);
        trackField.setAccessible(true);
        assertEquals("Constructed Position Field Mismatch", positionField.get(myPeg), 0);
        assertEquals("Constructed Track Field Mismatch", trackField.get(myPeg), (short) 0);
    }

    /** Tests incrementPosition() */
    @Test
    public void test_incrementPosition() throws NoSuchFieldException, IllegalAccessException {
        final Peg myPeg = new Peg(0, (short) 0);
        myPeg.incrementPosition(1);
        int position = myPeg.getPosition();
        assertEquals("Position field incremented a mismatched value", position, 1);
        myPeg.incrementPosition(-1);
        position = myPeg.getPosition();
        assertEquals("Position field accepted value less than 0", position, 1);
        myPeg.incrementPosition(122);
        position = myPeg.getPosition();
        assertEquals("Position field accepted value greater than 121", position, 1);
    }

    /** Tests getPosition() */
    @Test
    public void test_getPosition() throws NoSuchFieldException, IllegalAccessException {
        final Peg myPeg = new Peg(0, (short) 0);
        final int position = myPeg.getPosition();
        assertEquals("Position field returned mismatched value", position, 0);
    }

    /** Tests getTrack() */
    @Test
    public void test_getTrack() throws NoSuchFieldException, IllegalAccessException {
        final Peg myPeg = new Peg(0, (short) 0);
        final int track = myPeg.getTrack();
        assertEquals("Track field returned mismatched value", track, 0);
    }

}
