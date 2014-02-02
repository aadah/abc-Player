package player;

import sound.SequencePlayer;

public class Tuplet implements ABCMusic {
    private int numOfNotes;
    private ABCMusic[] notes;
    
    /**
     * Constructs a Tuplet
     * 
     * @param numOfNotes
     *            the number of notes a Tuplet element holds
     * @param notes
     *            an array of the notes in the Tuplet
     *            notes may include both Note and Chord elements.
     */
    public Tuplet(int numOfNotes, ABCMusic[] notes) {
        assert numOfNotes == notes.length;
        this.numOfNotes = numOfNotes;
        this.notes = notes;
    }
    
    /**
     * Returns the least common denominator of the notes in the tuplet
     * 
     * @returns integer representing the least common denominator of the notes in the tuplet
     */
    public int leastCommonDenominator() {
        int lcd = notes[0].leastCommonDenominator();
        for (int i=1; i<numOfNotes; i++) {
            lcd = Helper.lcm(lcd, notes[i].leastCommonDenominator()); 
        }
        return lcd;
    }
    
    /**
     * Returns the player after adding the tuplet instance to it
     * 
     * @returns player with the tuplet
     */
    public SequencePlayer addSelfToPlayer(SequencePlayer player) {
        for (ABCMusic note : this.notes) {
            note.addSelfToPlayer(player);
        }
        return player;
    }
    
    /**
     * Returns a String representing the Tuplet
     * 
     * @return a String representation of the Tuplet
     */    
    @Override
    public String toString() {
        String result = "(";
        for (int i = 0; i < this.numOfNotes-1; i++) {
            result = result + this.notes[i].toString() + ",";
        }
        result = result + this.notes[this.numOfNotes-1].toString() + ")";
        return result;
    }

    /**
     * Tests the for Tuplet equality
     * 
     * @param obj any Object
     * @return a boolean that reflects Tuplet equality
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tuplet)) {
            return false;
        }
        Tuplet that = (Tuplet) obj;
        if (this.numOfNotes != that.numOfNotes){
            return false;
        }
        for (int i = 0; i < this.numOfNotes; i++) {
            if (!(this.notes[i].equals(that.notes[i]))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns an integer representing internal data
     * 
     * @returns the hashCode of the Tuplet object
     */
    @Override
    public int hashCode() {
        int result = 0;
        for (ABCMusic note : this.notes) {
            result += note.hashCode();
        }
        result -= this.numOfNotes;
        return result;
    }
}
