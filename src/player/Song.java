package player;

import java.util.Map;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import player.ABCMusic;
import sound.LyricListener;
import sound.OurLyricListener;
import sound.SequencePlayer;

public class Song implements ABCMusic {
    
    private int numOfVoices;
    private Voice[] voices;
    private Map<String, Object> header;
    // Header keys
    private final String C = "C"; // Composer
    private final String K = "K"; // Key
    private final String L = "L"; // Default length
    private final String M = "M"; // Meter
    private final String Q = "Q"; // Tempo
    private final String T = "T"; // Title
    private final String X = "X"; // Index #
    
    /**
     * Constructs a Song
     * 
     * @param numOfVoices
     *            the number of voices a Song holds
     * @param voices
     *            an array of the voices in the Song
     * @param header
     *            a map mapping Strings to Objects representing the information in the header.
     *            the keys of the map include {"C", "K", "L", "M", "Q", "T", "X"}. The header must include X, T and K fields. 
     *            Other fields are optional.             
     */
    public Song(int numOfVoices, Voice[] voices, Map<String, Object> header) {
        this.numOfVoices = numOfVoices;
        this.voices = voices;
        this.header = header;
    }
    
    /**
     * Prints the title of the piece and also the composer.
     */
    public void printTitleAndAuthor() {
        System.out.println(header.get(T) + " by " + header.get(C));
    }
    
    /**
     * Returns the least common denominator of the voices and measures in the song
     * 
     * @returns integer representing the least common denominator of the voices and measures in the song
     */
    public int leastCommonDenominator() {
        int lcd = this.voices[0].leastCommonDenominator();
        for (int i=1; i<this.numOfVoices; i++) {
            lcd = Helper.lcm(lcd, this.voices[i].leastCommonDenominator()); 
        }
        return lcd;
    }

    /**
     * Returns the player after adding the song instance to it
     * 
     * @returns player with the song
     */
    
    public SequencePlayer addSelfToPlayer(SequencePlayer player) {
        int startTick = player.currentTick;
        for (Voice voice : this.voices) {
            player.currentTick = startTick;
            voice.addSelfToPlayer(player);
        }
        return player;
    }
    
    /**
     * Calculates the ticks per beat by multiplying the LCD of the song to the denominator of Note Length. 
     * 
     * @returns ticks per beat to play the song
     */
    
    public int getTicksPerBeat() {
        int lcm = this.leastCommonDenominator();
        int factor = ((int[]) this.header.get(L))[1];
        return lcm*factor;
    }
    
    /**
     * Creates a player to play the song with the required ticks per beat and tempo 
     * 
     * @returns a Sequence Player player that will play the song 
     */
    
    public SequencePlayer createPlayer() {
        int beatsPerMin = (int) this.header.get(Q);
        int ticksPerBeat = this.getTicksPerBeat();
        LyricListener listener = new OurLyricListener();
        try {
            SequencePlayer player = new SequencePlayer(beatsPerMin, ticksPerBeat, listener);
            return this.addSelfToPlayer(player);
        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Returns a String representing the Song
     * 
     * @return a String representation of the Song
     */ 
    @Override
    public String toString() {
        String result = "";
        for (int i = 0 ; i < this.numOfVoices - 1 ; i++) {
            result += this.voices[i].toString() + "\n";
        }
        result += this.voices[this.numOfVoices - 1].toString();
        result = "Song: " + (String) header.get(T) + "\n" + result;
        return result;
    }
    
    /**
     * Tests for Song equality
     * 
     * @param obj any Object
     * @return a boolean that reflects Song equality
     */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Song)) {
            return false;
        }
        Song that = (Song) obj;
        if (this.numOfVoices != that.numOfVoices){
            return false;
        }
        for (int i = 0; i < this.numOfVoices; i++) {
            if (!(this.voices[i].equals(that.voices[i]))) {
                return false;
            }
        }
        if (!(this.header.equals(that.header))) {
            return false;
        }
        return true;
    }
    
    /**
     * Returns an integer representing internal data
     * 
     * @returns the hashCode of the Song object
     */
    public int hashCode() {
        int result = 0;
        for (int i = 0 ; i < this.numOfVoices ; i++) {
            if (i%2 == 0) {
                result += this.voices[i].hashCode();
            }
            else {
                result -= this.voices[i].hashCode();
            }
        }
        result += this.numOfVoices;
        return result;
    }
}
