package player;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChordTest {
    
    //Testing Strategy for Chord Test:
    //Methods to test: toString, HashCode, equals, Least Common Denominator

    //Boundaries for toString Test:
    //Basic Chord: A Chord with same base notes and note lengths and accidentals,
    //Complex Chord: A Chord with different base notes, different note lengths and differental accidentals.
    @Test
    public void toStringTestBasicChord() {
        Note[] notes = new Note[3];
        notes[0]= new Note(1, 'A', 1, new int[] {1,6});
        notes[1]= new Note(1, 'A', 1, new int[] {1,6});
        notes[2] = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic chord1 = new Chord(3, notes, "LaLaLa");
        String chord2 = "[A(1,1,1/6),A(1,1,1/6),A(1,1,1/6)]";
        assertEquals(true, chord1.toString().equals(chord2));
    }
    
    @Test
    public void toStringTestComplexChord() {
        Note[] notes = new Note[3];
        notes[0]= new Note(0, 'b', 1, new int[] {1,6});
        notes[1]= new Note(1, 'D', 2, new int[] {1,5});
        notes[2] = new Note(-1, 'A', 1, new int[] {1,3});
        ABCMusic chord1 = new Chord(3, notes, " ");
        String chord2 = "[b(0,1,1/6),D(1,2,1/5),A(-1,1,1/3)]";
        assertEquals(true, chord1.toString().equals(chord2));
    }

    // Boundaries for testing HashCode:
    // Test if two same chords return the same hashcode(should be true)
    // Test if two different chords return same hashcode (should be false): 
    // Different Chords = [1) the number of notes in the chords are different, 2)the base notes in the chords are different
    // 3) The accidentals of the notes in the chord are different]
    // Note: the Notelength of the hashCode matters for equality but not for hashCode. 
    
    @Test
    public void testHashCodeChordTrue() {
        // both chords are the same
        Note[] notes1 = new Note[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic chord1 = new Chord(3, notes1, " ");
        
        Note[] notes2 = new Note[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic chord2 = new Chord(3, notes2, " ");
       
        assertEquals(true, chord1.hashCode() == chord2.hashCode());
    }
    
    @Test
    public void testHashCodeDifferentSizeChords() {
        //size of chords are different
        Note[] notes1 = new Note[2];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        ABCMusic chord1 = new Chord(2, notes1);
        
        Note[] notes2 = new Note[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic chord2 = new Chord(3, notes2, " ");
       
        assertEquals(false, chord1.hashCode() == chord2.hashCode());
    }
    
   
    
    @Test
    public void chordHashCodeBaseNoteDifferent() {
        //chord1 = [BaC] is not equal to chord2 = [BaD]
        Note[] notes1 = new Note[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic chord1 = new Chord(3, notes1, " ");
        
        Note[] notes2 = new Note[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'D', 2, new int[] {1,6});
        ABCMusic chord2 = new Chord(3, notes2, " ");
       
        assertEquals(false, chord1.hashCode() == chord2.hashCode());
    }
    
    @Test
    public void chordHashCodeAccidentalDifferent() {
        // chord 1 accidentals not equal chord 2 accidentals
        Note[] notes1 = new Note[3];
        notes1[0]= new Note(1, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic chord1 = new Chord(3, notes1, " ");
        
        Note[] notes2 = new Note[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic chord2 = new Chord(3, notes2, " ");
       
        assertEquals(false, chord1.hashCode() == chord2.hashCode());
    }
    
    // Boundaries for testing Equals:
    // Test if two same chords return true for equality
    // Test if two different chords return false for equality: 
    // Different Chords = [1) the number of notes in the chords are different, 2)the base notes in the chords are different
    // 3) The accidentals of the notes in the chord are different, the notelength of the base notes in the chords are different]
    // Note: the length of the hashCode matters for equality but not for hashCode. Different lyrics affect equality for chords
    
    @Test
    public void chordEqualsTestTrue() { 
        // Both chords are the same, should return true. 
        Note[] notes1 = new Note[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic chord1 = new Chord(3, notes1);
        
        Note[] notes2 = new Note[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic chord2 = new Chord(3, notes2);
       
        assertEquals(true, chord1.equals(chord2));
    }
    
    @Test
    public void chordEqualsTestAccidentalsDifferent() { 
        // different accidentals
        Note[] notes1 = new Note[3];
        notes1[0]= new Note(1, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic chord1 = new Chord(3, notes1);
        
        Note[] notes2 = new Note[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic chord2 = new Chord(3, notes2);
       
        assertEquals(false, chord1.equals(chord2));
    }
    
    @Test
    public void chordEqualsTestBaseNoteDifferent() { 
        // different base notes 
        Note[] notes1 = new Note[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'D', 2, new int[] {1,6});
        ABCMusic chord1 = new Chord(3, notes1);
        
        Note[] notes2 = new Note[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic chord2 = new Chord(3, notes2);
       
        assertEquals(false, chord1.equals(chord2));
        
    }
    
    @Test
    public void chordEqualsTestDifferentNoteLengths() { 
        // same base notes but different note lengths
        Note[] notes1 = new Note[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,8});
        ABCMusic chord1 = new Chord(3, notes1);
        
        Note[] notes2 = new Note[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic chord2 = new Chord(3, notes2);
       
        assertEquals(false, chord1.equals(chord2));
    }
    
    @Test
    public void chordEqualsTestDifferentLyrics() {
        // Same chord but different lyrics should not equal
        Note[] notes1 = new Note[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,8});
        ABCMusic chord1 = new Chord(3, notes1, "abcedf");
        
        Note[] notes2 = new Note[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,8});
        ABCMusic chord2 = new Chord(3, notes2, "ghijk");
       
        assertEquals(false, chord1.equals(chord2));
    }
    
    @Test
    public void testEqualsDifferentSizeChords() {
        //size of chords are different
        Note[] notes1 = new Note[2];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        ABCMusic chord1 = new Chord(2, notes1);
        
        Note[] notes2 = new Note[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic chord2 = new Chord(3, notes2, " ");
       
        assertEquals(false, chord1.equals(chord2));
    }
    
    
    // Boundaries for Least Common Denominator: 
    // Correct Value for Least Common Denominator, Same Note Lengths, Different Note Lengths
    // Test for incorrect least common denominator
    
    @Test
    public void chordTestLCDDifferentDenominators() { 
        Note[] notes1 = new Note[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,8});
        ABCMusic chord1 = new Chord(3, notes1, "abcedf");
        int lcd= chord1.leastCommonDenominator();
        int answer = 8;
        assertEquals(true, lcd==answer);
    }
    
    @Test
    public void chordTestLCDSameDenominators() { 
        Note[] notes1 = new Note[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,2});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,2});
        ABCMusic chord1 = new Chord(3, notes1, "abcedf");
        int lcd= chord1.leastCommonDenominator();
        int answer = 2;
        assertEquals(true, lcd==answer);
    }
    
    @Test
    public void chordEqualsLeastCommonDenominatorFalse() { 
        Note[] notes1 = new Note[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,3});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,8});
        ABCMusic chord1 = new Chord(3, notes1, "abcedf");
        int lcd= chord1.leastCommonDenominator();
        int answer = 8;
        assertEquals(false, lcd==answer);
    }
}

