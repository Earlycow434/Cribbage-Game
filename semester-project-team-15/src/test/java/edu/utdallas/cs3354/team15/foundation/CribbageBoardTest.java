package edu.utdallas.cs3354.team15.foundation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.Test;

/**
 * The CribbageBoardTest class
 * Unit test harness for the CribbageBoard class.
 * 
 * @author Shiqi Wang
 * @version %I%, %G%
 */
public class CribbageBoardTest {
    /** Tests Constructor */
    @Test
    public void test_constructor() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Peg> myPegs = new ArrayList<Peg>();
        final CribbageBoard myCribbageBoard = new CribbageBoard(myPegs);
        final Field pegsField = myCribbageBoard.getClass().getDeclaredField("pegs");
        pegsField.setAccessible(true);
        Object pegsFieldObject = pegsField.get(myCribbageBoard);
        final ArrayList<Peg> pegs = (ArrayList<Peg>) pegsFieldObject;
        assertTrue("Cribbage Board was not initialized", pegs.isEmpty());
    }

    /** Tests getPeg() */
    @Test
    public void test_getPeg() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Peg> myPegs = new ArrayList<Peg>();
        final CribbageBoard myCribbageBoard = new CribbageBoard(myPegs);
        final Field pegsField = myCribbageBoard.getClass().getDeclaredField("pegs");
        pegsField.setAccessible(true);
        Object pegsFieldObject = pegsField.get(myCribbageBoard);
        final ArrayList<Peg> pegs = (ArrayList<Peg>) pegsFieldObject;
        final Peg myPeg = new Peg(0, (short) 0);
        pegs.add(myPeg);
        assertFalse("Peg was not inserted into cribbage board", pegs.isEmpty());
        assertEquals("getPeg function returned mismatch values", myCribbageBoard.getPeg(-1), null);

    }

    /** Tests setPeg() */
    @Test
    public void test_setPeg() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Peg> myPegs = new ArrayList<Peg>();
        final CribbageBoard myCribbageBoard = new CribbageBoard(myPegs);
        final Field pegsField = myCribbageBoard.getClass().getDeclaredField("pegs");
        pegsField.setAccessible(true);
        Object pegsFieldObject = pegsField.get(myCribbageBoard);
        final ArrayList<Peg> pegs = (ArrayList<Peg>) pegsFieldObject;
        final Peg myPeg1 = new Peg(0, (short) 0);
        final Peg myPeg2 = new Peg(1, (short) 1);
        pegs.add(myPeg1);
        pegs.add(myPeg2);
        myCribbageBoard.setPeg(1, myPeg1);
        assertEquals("Peg was not set at the index", pegs.get(1), myPeg1);
        myCribbageBoard.setPeg(1, null);
        assertEquals("null peg was set at the index", pegs.get(1), myPeg1);
        myCribbageBoard.setPeg(2, myPeg1);

    }
}
