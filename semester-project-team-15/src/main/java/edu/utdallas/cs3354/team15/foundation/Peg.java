package edu.utdallas.cs3354.team15.foundation;

/**
 * The Peg class
 * A generic entity representing a physical peg.
 * It is placed on a cribbage board and it's location is determined by a numeric
 * position and on which track it is traveling.
 * At round end, the locations of the pegs are incremented appropriately.
 * 
 * @author Shiqi Wang
 * @version %I%, %G%
 */
public class Peg {

    /* Class Attributes */
    private int position;
    private short track;

    /**
     * Constructs a peg
     * 
     * @param pos The position of the peg
     * @param tra The track that the peg is on
     */
    public Peg(int pos, short tra) {
        position = pos;
        track = tra;
    }

    /* Member Functions */

    /**
     * Increments the position
     * 
     * @param value The number of positions to increment
     */
    public void incrementPosition(int value) {
        if (value > 0 && (position + value) < 121)
            position += value;
    }

    /**
     * Returns the position
     * 
     * @return The position of the peg
     */
    public int getPosition() {
        return position;
    }

    /**
     * Returns the track
     * 
     * @return The track the peg is on
     */
    public short getTrack() {
        return track;
    }
}
