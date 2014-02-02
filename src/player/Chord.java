package player;

import sound.SequencePlayer;

public class Chord implements ABCMusic {
    private int numOfNotes;
    private Note[] notes;
    private String lyric;
    
    /**
     * Constructs a Chord
     * 
     * @param numOfNotes
     *            the number of notes a Chord element holds
     * @param notes
     *            an array of the notes in the Chord
     */
    public Chord(int numOfNotes, Note[] notes) {
        assert numOfNotes == notes.length;
        this.numOfNotes = numOfNotes;
        this.notes = notes;
        this.lyric = "";
    }
    public Chord(int numOfNotes, Note[] notes, String lyric) {
        assert numOfNotes == notes.length;
        this.numOfNotes = numOfNotes;
        this.notes = notes;
        this.lyric = lyric;
    }  
    
    /**
     * Returns the least common denominator of the notes in the chord
     * 
     * @returns integer representing the least common denominator of the notes in the chord
     */
    public int leastCommonDenominator() {
        int lcd = notes[0].leastCommonDenominator();
        for (int i=1; i<numOfNotes; i++) {
            lcd = Helper.lcm(lcd, notes[i].leastCommonDenominator()); 
        }
        return lcd;
    }
    
    /**
     * Returns the player after adding the chord instance to it
     * 
     * @returns player with the new chord
     */
    public SequencePlayer addSelfToPlayer(SequencePlayer player) {
        int startTick = player.currentTick;
        if (!this.lyric.equals("")) {
            player.addLyricEvent(this.lyric, startTick);
        }
        notes[0].addSelfToPlayer(player);
        int endTick = player.currentTick;
        for (int i = 1; i < this.notes.length; i++) {
            player.currentTick = startTick;
            notes[i].addSelfToPlayer(player);
        }
        player.currentTick = endTick;
        return player;
    }
    
    public Chord scaledChord(int[] scalar) {
        Note[] scaledNotes = new Note[this.numOfNotes];
        for (int i = 0; i < this.numOfNotes; i++) {
            scaledNotes[i] = this.notes[i].scaledNote(scalar);
        }
        
        return new Chord(this.numOfNotes, scaledNotes);
    }
    
    /**
     * Returns a String representing the Chord
     * 
     * @return a String representation of the Chord
     */    
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < this.numOfNotes-1; i++) {
            result = result + this.notes[i].toString() + ",";
        }
        result = result + this.notes[this.numOfNotes-1] + "]";
        return result;
    }

    /**
     * Tests the for Chord equality
     * 
     * @param obj any Object
     * @return a boolean that reflects Chord equality
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Chord)) {
            return false;
        }
        Chord that = (Chord) obj;
        if (this.numOfNotes != that.numOfNotes){
            return false;
        }
        if (!this.lyric.equals(that.lyric)) {
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
     * @returns the hashCode of the Chord object
     */
    @Override
    public int hashCode() {
        int result = 0;
        for (Note note : this.notes) {
            result += note.hashCode();
        }
        result += this.numOfNotes;
        return result;
    }
}
