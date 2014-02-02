package player;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeasureTest {

    // Methods to Test: toString, HashCode, Equals, Least Common Denominator
    
    // Boundaries for toString: 
    // basic Measure with same singular notes, complex measure with tuplet, chord and note with different base notes. 
    
    @Test
    public void toStringMeasuretestBasic(){
        
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[3];
        elements[0]= note1;
        elements[1]= note2;
        elements[2]= note3;
        ABCMusic measure1 = new Measure(3, elements);
        String measure2 = "A(1,1,1/6),A(1,1,1/6),A(1,1,1/6) | ";
        assertEquals(true, measure1.toString().equals(measure2));
      
        
        
    }
    @Test
    public void toStringMeasuretestComplex() {
        Note[] notes = new Note[3];
        notes[0]= new Note(1, 'A', 1, new int[] {1,6});
        notes[1]= new Note(1, 'A', 1, new int[] {1,6});
        notes[2] = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic chord1 = new Chord(3, notes, "LaLaLa");;
        
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
  
        ABCMusic[] elements1 = new ABCMusic[3];
        elements1[0] = chord1;
        elements1[1]= note1;
        elements1[2]= tuplet1;
        
        ABCMusic measure1 = new Measure(3, elements1);
        String measure2 = "[A(1,1,1/6),A(1,1,1/6),A(1,1,1/6)],A(1,1,1/6),(B(0,1,1/2),a(1,1,1/4),C(-1,2,1/6)) | ";
        assertEquals(true, measure1.toString().equals(measure2));
    }

 // Boundaries for testing HashCode:
    // Test if two same measures return the same hashcode(should be true)
    // Test if two different measures return same hashcode (should be false): 
    // Different Measures = [1) the number of elements in the measures are different,
    // 2)the elements of the measures are different
    // 3) The note length of the base note in the elements of the measure are different,
    // 4) Accidentals of elements are different]
    
    @Test
    public void testHashCodeMeasureTrue() {
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements1 = new ABCMusic[3];
        elements1[0]= note1;
        elements1[1]= note2;
        elements1[2]= note3;
        ABCMusic measure1 = new Measure(3, elements1);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        ABCMusic measure2 = new Measure(3, elements2);
        
        assertEquals(true, measure1.hashCode()==measure2.hashCode());
        
    }
    @Test
    public void testHashCodeMeasureDifferentElements() {
        // Different elements in the measure
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements1 = new ABCMusic[3];
        elements1[0]= note1;
        elements1[1]= note2;
        elements1[2]= note3;
        ABCMusic measure1 = new Measure(3, elements1);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'B', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        ABCMusic measure2 = new Measure(3, elements2);
        
        assertEquals(false, measure1.hashCode()==measure2.hashCode());
        
    }
    
    @Test
    public void testHashCodeMeasureDifferentNumberOfElements() {
        // Different size of elements
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements1 = new ABCMusic[3];
        elements1[0]= note1;
        elements1[1]= note2;
        elements1[2]= note3;
        ABCMusic measure1 = new Measure(3, elements1);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[2];
        elements2[0]= note4;
        elements2[1]= note6;
        ABCMusic measure2 = new Measure(2, elements2);
        
        assertEquals(false, measure1.hashCode()==measure2.hashCode());
        
    }
    
    @Test
    public void testHashCodeMeasureDifferentNoteLength() {
        // Different NoteLengths of elements
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,2});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements1 = new ABCMusic[3];
        elements1[0]= note1;
        elements1[1]= note2;
        elements1[2]= note3;
        ABCMusic measure1 = new Measure(3, elements1);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        ABCMusic measure2 = new Measure(3, elements2);
        
        assertEquals(false, measure1.hashCode()==measure2.hashCode());
        
    }
    
    @Test
    public void testHashCodeMeasureDifferentAccidental() {
        // different accidentals for the elements
        
        ABCMusic note1 = new Note(-1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements1 = new ABCMusic[3];
        elements1[0]= note1;
        elements1[1]= note2;
        elements1[2]= note3;
        ABCMusic measure1 = new Measure(3, elements1);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        ABCMusic measure2 = new Measure(3, elements2);
        
        assertEquals(false, measure1.hashCode()==measure2.hashCode());
    }
    
    // Boundaries for testing Equals:
    // Test if two same measures are equal to each other (Basic & Complex Measures) (should be true_
    // Test if two different measures are equal to each other (should be false): 
    // Different Measures = [1) the number of elements in the measures are different,
    // 2)the elements of the measures are different
    // 3) The note length of the base note in the elements of the measure are different,
    // 4) Accidentals of elements are different]
    
    @Test
    public void testEqualsMeasureBasicTrue() {
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements1 = new ABCMusic[3];
        elements1[0]= note1;
        elements1[1]= note2;
        elements1[2]= note3;
        ABCMusic measure1 = new Measure(3, elements1);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        ABCMusic measure2 = new Measure(3, elements2);
        
        assertEquals(true, measure1.equals(measure2));
        
    }
    
    @Test
    public void testEqualsMeasureComplex() {
        Note[] notes = new Note[3];
        notes[0]= new Note(1, 'A', 1, new int[] {1,6});
        notes[1]= new Note(1, 'A', 1, new int[] {1,6});
        notes[2] = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic chord1 = new Chord(3, notes, "LaLaLa");
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] notes1 = new ABCMusic[3];
        notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
        notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
        notes1[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tuplet1 = new Tuplet(3, notes1);
        ABCMusic[] elements1 = new ABCMusic[3];
        elements1[0] = chord1;
        elements1[1]= note1;
        elements1[2]= tuplet1;
        ABCMusic measure1 = new Measure(3, elements1);
        
        Note[] notesOther = new Note[3];
        notesOther[0]= new Note(1, 'A', 1, new int[] {1,6});
        notesOther[1]= new Note(1, 'A', 1, new int[] {1,6});
        notesOther[2] = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic chordOther = new Chord(3, notesOther, "LaLaLa");
        ABCMusic Note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] Notes = new ABCMusic[3];
        Notes[0]= new Note(0, 'B', 1, new int[] {1,2});
        Notes[1]= new Note(1, 'a', 1, new int[] {1,4});
        Notes[2] = new Note(-1, 'C', 2, new int[] {1,6});
        ABCMusic tupletOther = new Tuplet(3, Notes);
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0] = chordOther;
        elements2[1]= Note2;
        elements2[2]= tupletOther;
        ABCMusic measure2 = new Measure(3, elements2);
        assertEquals(true, measure1.equals(measure2));
}
    
    @Test
    public void testEqualsMeasureDifferentElements() {
        //different elements in the measure
        ABCMusic note1 = new Note(1, 'B', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements1 = new ABCMusic[3];
        elements1[0]= note1;
        elements1[1]= note2;
        elements1[2]= note3;
        ABCMusic measure1 = new Measure(3, elements1);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        ABCMusic measure2 = new Measure(3, elements2);
        
        assertEquals(false, measure1.equals(measure2));
        
    }
    
    @Test
    public void testEqualsMeasureDifferentAccidental() {
        // different accidentals of the elements in the measure
        ABCMusic note1 = new Note(0, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements1 = new ABCMusic[3];
        elements1[0]= note1;
        elements1[1]= note2;
        elements1[2]= note3;
        ABCMusic measure1 = new Measure(3, elements1);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        ABCMusic measure2 = new Measure(3, elements2);
        
        assertEquals(false, measure1.equals(measure2));
        
    }
    
    @Test
    public void testEqualsMeasureDifferentNoteLength() {
        // different note length of elements in the measure
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements1 = new ABCMusic[3];
        elements1[0]= note1;
        elements1[1]= note2;
        elements1[2]= note3;
        ABCMusic measure1 = new Measure(3, elements1);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,5});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        ABCMusic measure2 = new Measure(3, elements2);
        
        assertEquals(false, measure1.equals(measure2));
        
    }
    
    @Test
    public void testEqualsMeasureDifferentNumberElements() {
        // different number of elements in the measure
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements1 = new ABCMusic[3];
        elements1[0]= note1;
        elements1[1]= note2;
        elements1[2]= note3;
        ABCMusic measure1 = new Measure(3, elements1);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[2];
        elements2[0]= note4;
        elements2[1]= note5;
        ABCMusic measure2 = new Measure(2, elements2);
        
        assertEquals(false, measure1.equals(measure2));
        
    }
    // Boundaries for testing LCD : Simple Measure, Complex Measure 
    
    @Test
    public void testLCDMeasureEven() {
        
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,2});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,4});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,8});
        ABCMusic[] elements1 = new ABCMusic[3];
        elements1[0]= note1;
        elements1[1]= note2;
        elements1[2]= note3;
        ABCMusic measure1 = new Measure(3, elements1);
        
        int lcd = measure1.leastCommonDenominator();
        int answer = 8;
        
        assertEquals(true, lcd == answer);
        
    }
    @Test
    public void testLCDMeasureComplex(){
        
    Note[] notes = new Note[3];
    notes[0]= new Note(1, 'A', 1, new int[] {1,4});
    notes[1]= new Note(1, 'A', 1, new int[] {1,3});
    notes[2] = new Note(1, 'A', 1, new int[] {1,6});
    ABCMusic chord1 = new Chord(3, notes, "LaLaLa");
    ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
    ABCMusic[] notes1 = new ABCMusic[3];
    notes1[0]= new Note(0, 'B', 1, new int[] {1,2});
    notes1[1]= new Note(1, 'a', 1, new int[] {1,4});
    notes1[2] = new Note(-1, 'C', 2, new int[] {1,12});
    ABCMusic tuplet1 = new Tuplet(3, notes1);
    ABCMusic[] elements1 = new ABCMusic[3];
    elements1[0] = chord1;
    elements1[1]= note1;
    elements1[2]= tuplet1;
    ABCMusic measure1 = new Measure(3, elements1);
    
    int lcd = measure1.leastCommonDenominator();
    int answer = 12;
    assertEquals(true, lcd == answer);
}
}

