package player;

import sound.SequencePlayer;

public class Voice implements ABCMusic {

    private int numOfMeasures;
    private Measure[] measures;
    private String name;

    /**
     * Constructs a Voice element
     * 
     * @param name
     *            the String name of the Voice Object
     * @param numOfMeasures
     *            the number of measures a Voice element holds
     * @param measures
     *            an array of the measures in the Voice
     */
    public Voice(String name, int numOfMeasures, Measure[] measures) {
        assert numOfMeasures == measures.length;
        this.name = name;
        this.numOfMeasures = numOfMeasures;
        this.measures = measures;
    }

    /**
     * Returns the least common denominator of the notes in the measures in the
     * voice
     * 
     * @returns integer representing the least common denominator of the notes
     *          in the measures in the voice
     */
    public int leastCommonDenominator() {
        int lcd = this.measures[0].leastCommonDenominator();
        for (int i = 1; i < this.numOfMeasures; i++) {
            lcd = Helper.lcm(lcd, this.measures[i].leastCommonDenominator());
        }
        return lcd;
    }

    /**
     * Returns the player after adding the voice instance to it
     * 
     * @returns player with the voice
     */
    public SequencePlayer addSelfToPlayer(SequencePlayer player) {
        for (ABCMusic measure : this.measures) {
            measure.addSelfToPlayer(player);
        }
        return player;
    }

    /**
     * Returns a String representing the Voice
     * 
     * @return a String representation of the Voice
     */
    @Override
    public String toString() {
        String result = "";
        for (Measure measure : this.measures) {
            result += measure.toString();
        }
        result = name + ": " + result.substring(0, result.length() - 3);
        return result;
    }

    /**
     * Tests the Voices for equality
     * 
     * @param obj
     *            any Object
     * @return a boolean that reflects Voices equality
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Voice)) {
            return false;
        }
        Voice that = (Voice) obj;
        if (this.numOfMeasures != that.numOfMeasures) {
            return false;
        }
        for (int i = 0; i < this.numOfMeasures; i++) {
            if (!(this.measures[i].equals(that.measures[i]))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns an integer representing internal data
     * 
     * @returns the hashCode of the Voice object
     */
    @Override
    public int hashCode() {
        int result = 0;
        for (Measure measure : this.measures) {
            result += measure.hashCode();
        }
        result += this.numOfMeasures;
        return result;
    }
}
