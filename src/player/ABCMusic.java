package player;

import sound.SequencePlayer;

/**
 * ABCMusic is an immutable datatype representing a ABCMusic object.
 * 
 * ABCMusic = Note(accidental: int, letter: char, octave: int, fraction: int[],
 * lyric: String) + Chord(numOfNotes: int, notes: Note[], lyric: String) +
 * Tuplets(numOfNotes: int, notes: ABCMusic[]) + Measure(numOfElements: int,
 * elements: ABCMusic[]) + Voice(name: String, numOfMeasures: int, measures:
 * Measure[]) + Song(numOfVoices: int, voices: Voice[], header: Map<String,
 * Object>)
 * 
 */

public interface ABCMusic {

    /**
     * Returns the least common denominator of the ABCMusic object
     * 
     * @returns integer representing the least common denominator of the
     *          elements of the ABCMusic Object
     */
    public int leastCommonDenominator();

    /**
     * Returns the player after adding the ABCMusic Object to it
     * 
     * @param player
     *            a Sequence Player that will play the ABCMusic
     * 
     * @returns player with the ABCMusic Object
     */
    public SequencePlayer addSelfToPlayer(SequencePlayer player);
}
