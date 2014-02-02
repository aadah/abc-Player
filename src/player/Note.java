package player;

import sound.Pitch;
import sound.SequencePlayer;

/**
 * Note implements the ABCMusic abstract datatype It supports note expressions
 * in our representation such as "^F3/4" or "__C,/"
 */

public class Note implements ABCMusic {

    private int accidental;
    private char letter;
    private int octave;
    private int[] fraction;
    private String lyric;

    /**
     * Constructs a Note
     * 
     * @param accidental
     *            the accidental affecting the note if any. In the range [-2,2].
     * @param letter
     *            the character representation of the note. The letter must be
     *            in the following set {A, B, C, D, E, F, G}.
     * @param octave
     *            an integer indicating the note's octave relative to middle C.
     * @param fraction
     *            the fractional length of a note relative to L. 
     *            fraction = [numerator, denominator]. |fraction| = 2.
     */
    public Note(int accidental, char letter, int octave, int[] fraction) {
        this.accidental = accidental;
        this.letter = letter;
        this.octave = octave;
        int gcd = Helper.gcd(fraction[0], fraction[1]);
        if (gcd != 1) {
            fraction[0] = fraction[0]/gcd;
            fraction[1] = fraction[1]/gcd;
        }
        this.fraction = fraction;
        this.lyric = "";
    }
    
    /**
     * Constructs a Note
     * 
     * @param accidental
     *            the accidental affecting the note if any. In the range [-2,2].
     * @param letter
     *            the character representation of the note. The letter must be
     *            in the following set {A, B, C, D, E, F, G}.
     * @param octave
     *            an integer indicating the note's octave relative to middle C.
     * @param fraction
     *            the fractional length of a note relative to L. 
     *            fraction = [nominator, denominator]. |fraction| = 2.
     * @param lyric
     *            the lyric associated with the note
     */
    public Note(int accidental, char letter, int octave, int[] fraction, String lyric) {
        this.accidental = accidental;
        this.letter = letter;
        this.octave = octave;
        int gcd = Helper.gcd(fraction[0], fraction[1]);
        if (gcd != 1) {
            fraction[0] = fraction[0]/gcd;
            fraction[1] = fraction[1]/gcd;
        }
        this.fraction = fraction;
        this.lyric = lyric;
    }
    
    /**
     * returns a Pitch object that represent the pitch of this Note.
     * 
     * @return A Pitch object representing the Note
     */
    public Pitch toPitch() {
        Pitch pitch = new Pitch(this.letter).accidentalTranspose(this.accidental).octaveTranspose(this.octave);
        return pitch;
    }
    
    public int toMidi() {
        return this.toPitch().toMidiNote();
    }
    
    public double decimalFraction() {
        return 1.0*this.fraction[0]/this.fraction[1];
    }
    
    /**
     * Returns the lcd  of all notes in the instance, which
     * in this case is just it's own.
     * 
     * @return the denominator of the note fraction
     */
    public int leastCommonDenominator() {
        return fraction[1];
    }
    
    
    /**
     * Returns the player after adding the note instance to it
     * 
     * @returns player with the new note
     */
    
    public SequencePlayer addSelfToPlayer(SequencePlayer player) {
        int numTicks = (int) (player.ticksPerBeat*this.decimalFraction());
        if (this.letter == 'z') { // If a rest, just shift the current tick.
            player.currentTick += numTicks;
            return player;
        }
        player.addNote(this.toMidi(), player.currentTick, numTicks);
        if (!this.lyric.equals("")) {
            player.addLyricEvent(this.lyric, player.currentTick);
        }
        player.currentTick += numTicks;
        return player;
    }
    
    /**
     * Returns a new Note with a length of this.fraction*scalar
     * 
     * @param scalar the factor by which the length is scaled
     * @return a new Note with the scaled length
     */
    public Note scaledNote(int[] scalar) {
        int newNum = this.fraction[0]*scalar[0];
        int newDen = this.fraction[1]*scalar[1];
        return new Note(this.accidental, this.letter, this.octave, new int[] {newNum, newDen}, this.lyric);
    }
    
    /**
     * Returns a String representing the Note
     * 
     * @return a String representation of the Note 
     *         it should look like "letter(accidental,octave,fraction)" 
     *         for example: "G(2,-1,1/2)" represents ^^G,/2
     */
    
    @Override
    public String toString() {
        return letter + "(" + accidental + "," + octave + "," + this.fraction[0] + "/" + this.fraction[1] + ")";
    }

    /**
     * Tests the for Note equality
     * 
     * @param obj any Object
     * @return a boolean that reflects Note equality
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Note)) {
            return false;
        }
        Note that = (Note) obj;
        boolean sameAcc = this.accidental == that.accidental;
        boolean sameLetter = this.letter == that.letter;
        boolean sameOct = this.octave == that.octave;
        boolean sameFrac = this.fraction[0] == that.fraction[0] && this.fraction[1] == that.fraction[1];
        boolean sameLyric = this.lyric.equals(that.lyric);
        if (sameAcc && sameLetter && sameOct && sameFrac && sameLyric){
            return true;
        }
        return false;
    }

    /**
     * Returns an integer representing internal data
     * 
     * @returns the hashCode of the Note object
     */
    @Override
    public int hashCode() {
        return accidental + letter + octave + this.fraction[0] + this.fraction[1];
    }

}
