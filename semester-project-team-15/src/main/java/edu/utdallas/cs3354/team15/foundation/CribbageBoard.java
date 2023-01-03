package edu.utdallas.cs3354.team15.foundation;

import java.util.ArrayList;

/**
 * The CribbageBoard class
 * A generic entity representing the physical cribbage board.
 * Acts functionally as a container for all player pegs.
 * Pegs are modified by their requisite positions.
 * 
 * @author Shiqi Wang
 * @version %I%, %G%
 */
public class CribbageBoard {

    /* Class Attributes */
    private ArrayList<Peg> pegs;

    /**
     * Constructs a cribbage board
     * 
     * @param pegs The pegs of the a player
     */
    public CribbageBoard(ArrayList<Peg> pegs) {
        if (pegs != null)
            this.pegs = pegs;
        else
            pegs = new ArrayList<Peg>();
    }

    /**
     * Returns the peg
     * Indices 0, 1 map to player 1
     * Indices 2, 3 map to player 2
     * Indices 4, 5 map to player 3
     *
     * @param index The index of the peg
     * @return The peg at the index
     * @see Peg
     */
    public Peg getPeg(int index) {
        if (index >= 0 && index < pegs.size())
            return pegs.get(index);
        return null;
    }

    /**
     * Sets the peg at the index
     *
     * @param index The index of the peg
     * @param peg   The peg to be set
     */
    public void setPeg(int index, Peg peg) {
        if (index >= 0 && index < pegs.size() && peg != null)
            pegs.set(index, peg);
    }

}
