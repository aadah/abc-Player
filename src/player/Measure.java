package player;

import sound.SequencePlayer;

public class Measure implements ABCMusic {

    private int numOfElements;
    private ABCMusic[] elements;
    
    /**
     * Constructs a Measure
     * 
     * @param numOfElements
     *            the number of elements a Measure holds
     * @param elements
     *            an array of the elements of the Measure.
     *            elements include Notes, Chords or Tuplets.
     */
    public Measure(int numOfElements, ABCMusic[] elements) {
        assert numOfElements == elements.length;
        this.numOfElements = numOfElements;
        this.elements = elements;
    }
    
    /**
     * Returns the least common denominator of the elements in the measure
     * 
     * @returns integer representing the least common denominator of the elements in the measure
     */
    public int leastCommonDenominator() {
        int lcd = this.elements[0].leastCommonDenominator();
        for (int i=1; i<this.numOfElements; i++) {
            lcd = Helper.lcm(lcd, this.elements[i].leastCommonDenominator()); 
        }
        return lcd;
    }
    
    /**
     * Returns the player after adding the measure instance to it
     * 
     * @returns player with the new measure
     */
    
    public SequencePlayer addSelfToPlayer(SequencePlayer player) {
        for (ABCMusic element : this.elements) {
            element.addSelfToPlayer(player);
        }
        return player;
    }

    
    /**
     * Returns a String representing the Measure
     * 
     * @return a String representation of the Measure
     */    
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.numOfElements-1; i++) {
            result = result + this.elements[i].toString() + ",";
        }
        result = result + this.elements[this.numOfElements-1].toString() + " | ";
        return result;
    }
    
    /**
     * Tests for Measure equality
     * 
     * @param obj any Object
     * @return a boolean that reflects Measure equality
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Measure)) {
            return false;
        }
        Measure that = (Measure) obj;
        if (this.numOfElements != that.numOfElements){
            return false;
        }
        for (int i = 0; i < this.numOfElements; i++) {
            if (!(this.elements[i].equals(that.elements[i]))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns an integer representing internal data
     * 
     * @returns the hashCode of the Measure object
     */
    @Override
    public int hashCode() {
        int result = 0;
        for (ABCMusic element : this.elements) {
            result += element.hashCode();
        }
        result += this.numOfElements;
        return result;
    }
}
