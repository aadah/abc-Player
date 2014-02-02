package player;

import static org.junit.Assert.*;

import org.junit.Test;

public class VoiceTest {

    //Methods to test: toString, HashCode, Equals, Least Common Denominator

    // LCD: 
    // Same note lengths, different note lengths
    @Test
    public void VoicetestLCDSameLength() {
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[3];
        elements[0]= note1;
        elements[1]= note2;
        elements[2]= note3;
        Measure measure1 = new Measure(3, elements);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements2);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        ABCMusic voice1 = new Voice("Voice 1", 2, measures);
        
        int lcd = voice1.leastCommonDenominator();
        int answer= 6;
        assertEquals(true, lcd==answer);
        
    }
    
    @Test
    public void VoicetestLCDDifferentLength() {
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,2});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,3});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[3];
        elements[0]= note1;
        elements[1]= note2;
        elements[2]= note3;
        Measure measure1 = new Measure(3, elements);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,4});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,3});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,12});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements2);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        ABCMusic voice1 = new Voice("Voice 1", 2, measures);
        
        int lcd = voice1.leastCommonDenominator();
        int answer= 12;
        assertEquals(true, lcd==answer);
        
    }
    
    
    // toString boundaries: Basic voice with same basenotes and notelengths, 
    // complex voice with different base notes and notelengths.
    
    @Test
    public void VoicetestToStringBasic() {
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[3];
        elements[0]= note1;
        elements[1]= note2;
        elements[2]= note3;
        Measure measure1 = new Measure(3, elements);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements2);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        ABCMusic voice1 = new Voice("Voice 1", 2, measures);
        
        String Voice1 = "Voice 1: A(1,1,1/6),A(1,1,1/6),A(1,1,1/6) | A(1,1,1/6),A(1,1,1/6),A(1,1,1/6)";
        assertEquals(true, voice1.toString().equals(Voice1));

}
    @Test
    public void VoicetestToStringComplex() {
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(0, 'b', 1, new int[] {1,2});
        ABCMusic[] elements = new ABCMusic[3];
        elements[0]= note1;
        elements[1]= note2;
        Measure measure1 = new Measure(2, elements);
        
        ABCMusic note4 = new Note(-1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'c', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        
        Measure measure2 = new Measure(2, elements2);
        
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        ABCMusic voice1 = new Voice("Voice 1", 2, measures);
        
        String Voice1 = "Voice 1: A(1,1,1/6),b(0,1,1/2) | A(-1,1,1/6),c(1,1,1/6)";
        assertEquals(true, voice1.toString().equals(Voice1));
}
    // Boundaries HashCode: 
    // hashcode of the same voices (should be equal)
    // hashcodes of different voices (should not be equal)
    // different voices : [one measure in voice is different, number of measures in the voice is different]
    
    @Test
    public void testVoiceHashCodeTrue(){
        
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[3];
        elements[0]= note1;
        elements[1]= note2;
        elements[2]= note3;
        Measure measure1 = new Measure(3, elements);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements2);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        ABCMusic voice1 = new Voice("Voice 1", 2, measures);
        
        
        ABCMusic note7 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note8 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note9 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements3 = new ABCMusic[3];
        elements3[0]= note7;
        elements3[1]= note8;
        elements3[2]= note9;
        Measure measure3 = new Measure(3, elements3);
        
        ABCMusic note10 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note11 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note12 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements4 = new ABCMusic[3];
        elements4[0]= note10;
        elements4[1]= note11;
        elements4[2]= note12;
        Measure measure4 = new Measure(3, elements4);
        
        Measure[] measures2 = new Measure[2];
        measures2[0]= measure3;
        measures2[1]= measure4;
        ABCMusic voice2 = new Voice("Voice 2", 2, measures);
        
        assertEquals(true, voice1.hashCode()==voice2.hashCode());
    }
    
    @Test
    public void testVoiceHashCodeDifferentSize(){
        //voice1 = 1 measure, Voice2= 2 measures
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements2);
        
        Measure[] measures = new Measure[1];
        measures[0]= measure2;
        ABCMusic voice1 = new Voice("Voice 1", 1, measures);
        
        
        ABCMusic note7 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note8 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note9 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements3 = new ABCMusic[3];
        elements3[0]= note7;
        elements3[1]= note8;
        elements3[2]= note9;
        Measure measure3 = new Measure(3, elements3);
        
        ABCMusic note10 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note11 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note12 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements4 = new ABCMusic[3];
        elements4[0]= note10;
        elements4[1]= note11;
        elements4[2]= note12;
        Measure measure4 = new Measure(3, elements4);
        
        Measure[] measures2 = new Measure[2];
        measures2[0]= measure3;
        measures2[1]= measure4;
        ABCMusic voice2 = new Voice("Voice 2", 2, measures);
        
        assertEquals(false, voice1.hashCode()==voice2.hashCode());
    }
    
    @Test
    public void testVoiceHashCodeDifferentMeasures(){
        // voice 1 has different measures than voice 2
        
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[2];
        elements[0]= note1;
        elements[1]= note2;
        Measure measure1 = new Measure(2, elements);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements2);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        ABCMusic voice1 = new Voice("Voice 1", 2, measures);
        
        
        ABCMusic note7 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note8 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note9 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements3 = new ABCMusic[3];
        elements3[0]= note7;
        elements3[1]= note8;
        elements3[2]= note9;
        Measure measure3 = new Measure(3, elements3);
        
        ABCMusic note10 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note11 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note12 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements4 = new ABCMusic[3];
        elements4[0]= note10;
        elements4[1]= note11;
        elements4[2]= note12;
        Measure measure4 = new Measure(3, elements4);
        
        Measure[] measures2 = new Measure[2];
        measures2[0]= measure3;
        measures2[1]= measure4;
        ABCMusic voice2 = new Voice("Voice 2", 2, measures2);
        
        assertEquals(false, voice1.hashCode() == voice2.hashCode());
    }
    
    // Boundaries Equal: 
    // Same voices (should be equal)
    // Different voices (should not be equal)
    // different voices : [base notes in one measure is different, octave in one measure is different,
    // number of measures in the voice is different, accidental in one measure is different]
    
    @Test
    public void testVoiceEqualsDifferentSizeMeasure(){
        // voice 1 has different measures(smaller size) than voice 2
        
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[2];
        elements[0]= note1;
        elements[1]= note2;
        Measure measure1 = new Measure(2, elements);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements2);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        ABCMusic voice1 = new Voice("Voice 1", 2, measures);
        
        
        ABCMusic note7 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note8 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note9 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements3 = new ABCMusic[3];
        elements3[0]= note7;
        elements3[1]= note8;
        elements3[2]= note9;
        Measure measure3 = new Measure(3, elements3);
        
        ABCMusic note10 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note11 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note12 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements4 = new ABCMusic[3];
        elements4[0]= note10;
        elements4[1]= note11;
        elements4[2]= note12;
        Measure measure4 = new Measure(3, elements4);
        
        Measure[] measures2 = new Measure[2];
        measures2[0]= measure3;
        measures2[1]= measure4;
        ABCMusic voice2 = new Voice("Voice 2", 2, measures2);
        
        assertEquals(false, voice1.equals(voice2));
    }
    
    @Test
    public void testVoiceEqualsDifferentNumMeasures(){
        // voice 1 has one measure, voice 2 has two measures
        
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements2);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure2;
        ABCMusic voice1 = new Voice("Voice 1", 1, measures);
        
        
        ABCMusic note7 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note8 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note9 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements3 = new ABCMusic[3];
        elements3[0]= note7;
        elements3[1]= note8;
        elements3[2]= note9;
        Measure measure3 = new Measure(3, elements3);
        
        ABCMusic note10 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note11 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note12 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements4 = new ABCMusic[3];
        elements4[0]= note10;
        elements4[1]= note11;
        elements4[2]= note12;
        Measure measure4 = new Measure(3, elements4);
        
        Measure[] measures2 = new Measure[2];
        measures2[0]= measure3;
        measures2[1]= measure4;
        ABCMusic voice2 = new Voice("Voice 2", 2, measures);
        
        assertEquals(false, voice1.equals(voice2));
    }
    
    @Test
    public void testVoiceEqualsDifferentBaseNote(){
        // voice 1 has different measures with different note.
        
        ABCMusic note1 = new Note(1, 'b', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[3];
        elements[0]= note1;
        elements[1]= note2;
        elements[2]= note3;
        Measure measure1 = new Measure(3, elements);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements2);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        ABCMusic voice1 = new Voice("Voice 1", 2, measures);
        
        
        ABCMusic note7 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note8 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note9 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements3 = new ABCMusic[3];
        elements3[0]= note7;
        elements3[1]= note8;
        elements3[2]= note9;
        Measure measure3 = new Measure(3, elements3);
        
        ABCMusic note10 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note11 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note12 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements4 = new ABCMusic[3];
        elements4[0]= note10;
        elements4[1]= note11;
        elements4[2]= note12;
        Measure measure4 = new Measure(3, elements4);
        
        Measure[] measures2 = new Measure[2];
        measures2[0]= measure3;
        measures2[1]= measure4;
        ABCMusic voice2 = new Voice("Voice 2", 2, measures2);
        
        assertEquals(false, voice1.equals(voice2));
    }
    
    @Test
    public void testVoiceEqualsDifferentNoteLen(){
        // voice 1 has different measures with different note length
        
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,2});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[3];
        elements[0]= note1;
        elements[1]= note2;
        elements[2]= note3;
        Measure measure1 = new Measure(3, elements);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements2);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        ABCMusic voice1 = new Voice("Voice 1", 2, measures);
        
        
        ABCMusic note7 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note8 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note9 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements3 = new ABCMusic[3];
        elements3[0]= note7;
        elements3[1]= note8;
        elements3[2]= note9;
        Measure measure3 = new Measure(3, elements3);
        
        ABCMusic note10 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note11 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note12 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements4 = new ABCMusic[3];
        elements4[0]= note10;
        elements4[1]= note11;
        elements4[2]= note12;
        Measure measure4 = new Measure(3, elements4);
        
        Measure[] measures2 = new Measure[2];
        measures2[0]= measure3;
        measures2[1]= measure4;
        ABCMusic voice2 = new Voice("Voice 2", 2, measures2);
        
        assertEquals(false, voice1.equals(voice2));
    }
    
    @Test
    public void testVoiceEqualsDifferentAccidental(){
        // voice 1 has different accidental
        
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(-1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[3];
        elements[0]= note1;
        elements[1]= note2;
        elements[2]= note3;
        Measure measure1 = new Measure(3, elements);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements2);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        ABCMusic voice1 = new Voice("Voice 1", 2, measures);
        
        
        ABCMusic note7 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note8 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note9 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements3 = new ABCMusic[3];
        elements3[0]= note7;
        elements3[1]= note8;
        elements3[2]= note9;
        Measure measure3 = new Measure(3, elements3);
        
        ABCMusic note10 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note11 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note12 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements4 = new ABCMusic[3];
        elements4[0]= note10;
        elements4[1]= note11;
        elements4[2]= note12;
        Measure measure4 = new Measure(3, elements4);
        
        Measure[] measures2 = new Measure[2];
        measures2[0]= measure3;
        measures2[1]= measure4;
        ABCMusic voice2 = new Voice("Voice 2", 2, measures2);
        
        assertEquals(false, voice1.equals(voice2));
    }
    
    @Test
    public void testVoiceEqualsDifferentOctave(){
        // voice 1 has different accidental
        
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note2 = new Note(1, 'A', 2, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[3];
        elements[0]= note1;
        elements[1]= note2;
        elements[2]= note3;
        Measure measure1 = new Measure(3, elements);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements2);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        ABCMusic voice1 = new Voice("Voice 1", 2, measures);
        
        
        ABCMusic note7 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note8 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note9 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements3 = new ABCMusic[3];
        elements3[0]= note7;
        elements3[1]= note8;
        elements3[2]= note9;
        Measure measure3 = new Measure(3, elements3);
        
        ABCMusic note10 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note11 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note12 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements4 = new ABCMusic[3];
        elements4[0]= note10;
        elements4[1]= note11;
        elements4[2]= note12;
        Measure measure4 = new Measure(3, elements4);
        
        Measure[] measures2 = new Measure[2];
        measures2[0]= measure3;
        measures2[1]= measure4;
        ABCMusic voice2 = new Voice("Voice 2", 2, measures2);
        
        assertEquals(false, voice1.equals(voice2));
    }
    
}