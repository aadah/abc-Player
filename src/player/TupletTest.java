package player;

import static org.junit.Assert.*;

import org.junit.Test;

public class TupletTest {
    
    //Methods to test: toString, HashCode, Equals, Least Common Denominator

    
    // toString boundaries: Basic tuplet with same basenote and notelength, 
    // complex note with different base notes and notelengths.
    
    @Test
    public void toStringTestBasicTuplet() {
        ABCMusic[] notes = new ABCMusic[3];
        notes[0]= new Note(1, 'A', 1, new int[] {1,6});
        notes[1]= new Note(1, 'A', 1, new int[] {1,6});
        notes[2] = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic Tuplet1 = new Tuplet(3, notes);
        String tuplet1 = "(A(1,1,1/6),A(1,1,1/6),A(1,1,1/6))";
        assertEquals(true, Tuplet1.toString().equals(tuplet1));
                
    }

    @Test
    public void toStringTestComplexTuplet() {
        ABCMusic[] notes = new ABCMusic[3];
        notes[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic Tuplet1 = new Tuplet(3, notes);
        String tuplet1 = "(B(0,1,1/2),a(1,1,1/4),C(-1,2,1/6))";
        assertEquals(true, Tuplet1.toString().equals(tuplet1));
                
    }
    
    // Boundaries HashCode: 
    // hashcode of the same tuplets (should be equal)
    // hashcodes of different tuplets (should not be equal)
    // different tuplets : [one base note in tuplet is different, accidental of one note is different,
    // octave of one of the notes is different, note length of one of the notes is different, size of tuplet different]. 
    
    @Test
    public void testHashCodeTupletTrue() {
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        ABCMusic[] notes2 = new ABCMusic[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet2 = new Tuplet(3, notes2);
       
        assertEquals(true, tuplet1.hashCode() == tuplet2.hashCode());
    }
    
    @Test
    public void testHashCodeTupletDifferentSize() {
        // tuplet size 3 is not equal to tuplet size 2
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        
        ABCMusic[] notes2 = new ABCMusic[2];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        ABCMusic tuplet2 = new Tuplet(2, notes2);
       
        assertEquals(false, tuplet1.hashCode() == tuplet2.hashCode());
    }
    
    @Test
    public void testHashCodeTupletDifferentBaseNote() {
        // tuplet 1 = (3BaC is not equal to tuplet 2 = (3BaD (same notelength)
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        
        ABCMusic[] notes2 = new ABCMusic[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'D', 2, new int[] {1,6});
        ABCMusic tuplet2 = new Tuplet(2, notes2);
       
        assertEquals(false, tuplet1.hashCode() == tuplet2.hashCode());
    }
    
    //@Test
    public void testHashCodeTupletDifferentNoteLength() {
        // tuplet 1 = (3BaC is not equal to tuplet 2 = (3BaC with different note length
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,4});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        
        ABCMusic[] notes2 = new ABCMusic[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'D', 2, new int[] {1,6});
        ABCMusic tuplet2 = new Tuplet(2, notes2);
       
        assertEquals(false, tuplet1.hashCode() == tuplet2.hashCode());
    }
    
    @Test
    public void testHashCodeTupletDifferentAccidental() {
        // different accidental of one note
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(1, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        ABCMusic[] notes2 = new ABCMusic[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet2 = new Tuplet(3, notes2);
       
        assertEquals(false, tuplet1.hashCode() == tuplet2.hashCode());
    }
    
    @Test
    public void testHashCodeTupletDifferentOctave() {
        // different octave in one tuplet
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(1, 'B', 2, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        ABCMusic[] notes2 = new ABCMusic[3];
        notes2[0]= new Note(1, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet2 = new Tuplet(3, notes2);
       
        assertEquals(false, tuplet1.hashCode() == tuplet2.hashCode());
    }
    
    // Boundaries Equals: 
    // same tuplets (should be equal)
    // different tuplets (should not be equal)
    // different tuplets : [one base note in tuplet is different, accidental of one note is different,
    // octave of one of the notes is different, note length of one of the notes is different, size of tuplet different]. 
    
    @Test
    public void tupletEqualsTestTrue() { 
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        
        ABCMusic[] notes2 = new ABCMusic[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet2 = new Tuplet(3, notes2);
       
        assertEquals(true, tuplet1.equals(tuplet2));
    }
    
    @Test
    public void tupletEqualsTestDifferentOrder() { 
        //different order of notes
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[1]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[0]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        
        ABCMusic[] notes2 = new ABCMusic[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet2 = new Tuplet(3, notes2);
       
        assertEquals(false, tuplet1.equals(tuplet2));
    }
    
    @Test
    public void tupletEqualsTestDifferentSize() { 
    // size of the tuplet is not equal
        ABCMusic[] notes1 = new ABCMusic[2];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        ABCMusic tuplet1 = new Tuplet(2, notes1);
        
        ABCMusic[] notes2 = new ABCMusic[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet2 = new Tuplet(3, notes2);
       
        assertEquals(false, tuplet1.equals(tuplet2));
    }
    
    @Test
    public void tupletEqualsTestDifferentNoteLength() { 
    // different notelength, same base notes
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,4});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        
        ABCMusic[] notes2 = new ABCMusic[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet2 = new Tuplet(3, notes2);
       
        assertEquals(false, tuplet1.equals(tuplet2));
    }
    
    @Test
    public void tupletEqualsTestDifferentBaseNotes() { 
    // different base notes
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(0, 'A', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        
        ABCMusic[] notes2 = new ABCMusic[3];
        notes2[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet2 = new Tuplet(3, notes2);
       
        assertEquals(false, tuplet1.equals(tuplet2));
    }
    
    @Test
    public void tupletEqualsTestDifferentAccidental() { 
    // different accidental of one base note
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(1, 'A', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        
        ABCMusic[] notes2 = new ABCMusic[3];
        notes2[0]= new Note(0, 'A', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet2 = new Tuplet(3, notes2);
       
        assertEquals(false, tuplet1.equals(tuplet2));
    }
    
    @Test
    public void tupletEqualsTestDifferentOctave() { 
    // different octave of one base note
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(1, 'A', 2, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        
        ABCMusic[] notes2 = new ABCMusic[3];
        notes2[0]= new Note(1, 'A', 1, new int[] {1,2});
        notes2[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes2[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet2 = new Tuplet(3, notes2);
       
        assertEquals(false, tuplet1.equals(tuplet2));
    }
    
    // Boundaries for LCD: 
    // even, odd
    
    @Test
    public void tupletLeastCommonDenominatorTestTrue() { 
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(0, 'A', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        int lcd = tuplet1.leastCommonDenominator();
        int answer = 12;
        assertEquals(true, lcd == answer);
    
}
    @Test
    public void tupletLeastCommonDenominatorTestFalse() { 
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(0, 'A', 1, new int[] {1,5});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,3});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,9});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        int lcd = tuplet1.leastCommonDenominator();
        int answer = 45;
        assertEquals(true, lcd == answer);
    
}
}

