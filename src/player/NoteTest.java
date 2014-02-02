package player;

import static org.junit.Assert.*;

import org.junit.Test;
import sound.Pitch;

public class NoteTest {
    
    //Methods to Test: ToString, HashCode, Equals, ToPitch
    
    
    // toString: Basic Note, Note with notelength=1
    @Test
    public void basicToStringTest() {
        ABCMusic note = new Note(1, 'A', 1, new int[] {1,6});
        String noteToString = "A(1,1,1/6)";
        assertEquals(noteToString, note.toString());
    }
    
    @Test
    public void basicToStringTest2() {
        ABCMusic note = new Note(0, 'A', 0, new int[] {1,1});
        String noteToString = "A(0,0,1/1)";
        assertEquals(noteToString, note.toString());
    }
    
    // Boundaries for hashCode:
    // Two Same notes should have same hashcodes
    // two different notes should note have same hashcodes:
    // Different note types: [sifferent base notes, Same base note but different octave, different accidental,
    // different notelength]
    
    @Test
    public void testHashCodeNoteTrue() {
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        assertEquals(true, note1.hashCode() == note2.hashCode());
    }
    @Test
    public void noteHashCodeTestDifferentAccidental() { 
        // Different accidental
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(0, 'A', 1, new int[] {1,6});
        assertEquals(false, note1.hashCode() == note2.hashCode());
    }
    
    @Test
    public void noteHashCodeTestDifferentBaseNote() { 
        // Different base note
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'B', 1, new int[] {1,6});
        assertEquals(false, note1.hashCode() == note2.hashCode());
    }
    
    @Test
    public void noteHashCodeTestDifferentOctave() { 
        // Different octave
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 5, new int[] {1,6});
        assertEquals(false, note1.hashCode() == note2.hashCode());
    }
    
    @Test
    public void noteHashCodeTestDifferentNumerator() { 
        // Different numerator
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {3,6});
        assertEquals(false, note1.hashCode() == note2.hashCode());
    }
    
    @Test
    public void noteHashCodeTestDifferentDenominator() { 
        // Different denominator
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,4});
        assertEquals(false, note1.hashCode() == note2.hashCode());
    }
    
    @Test
    public void noteHashCodeTestDifferentNoteLength() { 
        // Different fraction
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {2,3});
        assertEquals(false, note1.hashCode() == note2.hashCode());
    }
    
    // Boundaries for Equals:
    // Two Same notes should be equal
    // two different notes should not be equal:
    // Different note types: [sifferent base notes, Same base note but different octave, different accidental,
    // different notelength]
    @Test
    public void noteEqualsTestTrue() {
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        assertEquals(true, note1.equals(note2));
    }
    
    @Test
    public void noteEqualsTestDifferentAccidental() { 
        // Different accidental
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(0, 'A', 1, new int[] {1,6});
        assertEquals(false, note1.equals(note2));
    }
    
    @Test
    public void noteEqualsTestDifferentBaseNote() { 
        // Different base note
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'B', 1, new int[] {1,6});
        assertEquals(false, note1.equals(note2));
    }
    
    @Test
    public void noteEqualsTestDifferentOctave() { 
        // Different octave
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 5, new int[] {1,6});
        assertEquals(false, note1.equals(note2));
    }
    
    @Test
    public void noteEqualsTestDifferentNumerator() { 
        // Different numerator
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {3,6});
        assertEquals(false, note1.equals(note2));
    }
    
    @Test
    public void noteEqualsTestDifferentDenominator() { 
        // Different denominator
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,4});
        assertEquals(false, note1.equals(note2));
    }
    
    @Test
    public void noteEqualsTestDifferentNoteLength() { 
        // Different fraction
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {2,3});
        assertEquals(false, note1.equals(note2));
    }
    
    // Boundaries for ToPitch:
    // Octave up, Same Octave, High Octave, Octave Low, Octave Down
    // Sharp, Flat, Natural Accidental, 
    // invalid Note
    
    @Test
    public void toPitchSharpTest(){
        Note note1 = new Note(1, 'A', 1, new int[] {1,6});
        Pitch pitch1 = note1.toPitch();
        String pitch = "^a";
        assertEquals(true, pitch1.toString().equals(pitch));       
        
    }
    @Test
    public void toPitchFlatTest(){
        Note note1 = new Note(-1, 'A', 0, new int[] {1,6});
        Pitch pitch1 = note1.toPitch();
        String pitch = "_A";
        assertEquals(true, pitch1.toString().equals(pitch));  
}
    @Test
    public void toPitchNaturalHighOctave(){
        Note note1 = new Note(0, 'A', 9, new int[] {1,6});
        Pitch pitch1 = note1.toPitch();
        String pitch = "a''''''''";
        assertEquals(true, pitch1.toString().equals(pitch));  
    }
        
    @Test
    public void toPitchNaturalOctaveDown(){
        Note note1 = new Note(0, 'A', -1, new int[] {1,6});
        Pitch pitch1 = note1.toPitch();
        String pitch = "A,";
        assertEquals(true, pitch1.toString().equals(pitch)); 
}
    
    @Test
    public void toPitchNaturalOctaveLow(){
        Note note1 = new Note(0, 'A', -9, new int[] {1,6});
        Pitch pitch1 = note1.toPitch();
        String pitch = "A,,,,,,,,,";
        assertEquals(true, pitch1.toString().equals(pitch)); 
    }
    @Test(expected = IllegalArgumentException.class)
    public void toPitchNaturalInvalidInput(){
        Note note1 = new Note(0, 'H', 9, new int[] {1,6});
        note1.toPitch();
    } 
}
  