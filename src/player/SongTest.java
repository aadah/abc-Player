package player;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class SongTest {

    // Methods to test:
    // Ticks per beat, to String, equals, hashCode 
    
    // Ticks Per Beat: Test ticks per beat, same song with two different L
    // 2L1= L2 so 2TicksPerBeat1 = TicksPerBeat2
    
    @Test
    public void testTicksPerBeat1() {
        
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,3});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[3];
        elements[0]= note1;
        elements[1]= note2;
        elements[2]= note3;
        Measure measure1 = new Measure(3, elements);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,2});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        Voice voice1 = new Voice("Voice 1", 2, measures);
        
        ABCMusic note7 = new Note(1, 'A', 1, new int[] {1,3});
        ABCMusic note8 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note9 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements3 = new ABCMusic[3];
        elements3[0]= note7;
        elements3[1]= note8;
        elements3[2]= note9;
        Measure measure3 = new Measure(3, elements3);
        
        ABCMusic note10 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note11 = new Note(1, 'A', 1, new int[] {1,2});
        ABCMusic note12 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements4 = new ABCMusic[3];
        elements4[0]= note10;
        elements4[1]= note11;
        elements4[2]= note12;
        Measure measure4 = new Measure(3, elements4);
        
        Measure[] measuresTwo = new Measure[2];
        measuresTwo[0]= measure3;
        measuresTwo[1]= measure4;
        Voice voice2 = new Voice("Voice 2", 2, measuresTwo);
        
        Voice[] voices = new Voice[2];
        voices[0]= voice1;
        voices[1]= voice2;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("C", 1);
        int[] array = new int[2];
        array[0]= 1;
        array[1]= 4;
        header.put("L", array);
        
        Song mySong = new Song(2, voices, header);
        int ticksperBeat = mySong.getTicksPerBeat();
        int ticksperBeatAns = 24;
        assertEquals(true, ticksperBeat == ticksperBeatAns);     
        
    }
    
    @Test
    public void testticksPerBeat2() {
        
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,3});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[3];
        elements[0]= note1;
        elements[1]= note2;
        elements[2]= note3;
        Measure measure1 = new Measure(3, elements);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,2});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        Voice voice1 = new Voice("Voice 1", 2, measures);
        
        ABCMusic note7 = new Note(1, 'A', 1, new int[] {1,3});
        ABCMusic note8 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note9 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements3 = new ABCMusic[3];
        elements3[0]= note7;
        elements3[1]= note8;
        elements3[2]= note9;
        Measure measure3 = new Measure(3, elements3);
        
        ABCMusic note10 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note11 = new Note(1, 'A', 1, new int[] {1,2});
        ABCMusic note12 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements4 = new ABCMusic[3];
        elements4[0]= note10;
        elements4[1]= note11;
        elements4[2]= note12;
        Measure measure4 = new Measure(3, elements4);
        
        Measure[] measuresTwo = new Measure[2];
        measuresTwo[0]= measure3;
        measuresTwo[1]= measure4;
        Voice voice2 = new Voice("Voice 2", 2, measuresTwo);
        
        Voice[] voices = new Voice[2];
        voices[0]= voice1;
        voices[1]= voice2;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("C", 1);
        int[] array = new int[2];
        array[0]= 1;
        array[1]= 8;
        header.put("L", array);
        
        Song mySong = new Song(2, voices, header);
        int ticksperBeat = mySong.getTicksPerBeat();
        int ticksperBeatAns = 48;
        assertEquals(true, ticksperBeat == ticksperBeatAns);
        
        
        
    }
    //To String: Song containing notes, measures and voices
    
    @Test
    public void testToStringSong() {
        
        ABCMusic note1 = new Note(1, 'A', 1, new int[] {1,3});
        ABCMusic note2 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note3 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements = new ABCMusic[3];
        elements[0]= note1;
        elements[1]= note2;
        elements[2]= note3;
        Measure measure1 = new Measure(3, elements);
        
        ABCMusic note4 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note5 = new Note(1, 'A', 1, new int[] {1,2});
        ABCMusic note6 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements2 = new ABCMusic[3];
        elements2[0]= note4;
        elements2[1]= note5;
        elements2[2]= note6;
        Measure measure2 = new Measure(3, elements);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        Voice voice1 = new Voice("Voice 1", 2, measures);
        
        ABCMusic note7 = new Note(1, 'A', 1, new int[] {1,3});
        ABCMusic note8 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note9 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements3 = new ABCMusic[3];
        elements3[0]= note7;
        elements3[1]= note8;
        elements3[2]= note9;
        Measure measure3 = new Measure(3, elements3);
        
        ABCMusic note10 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic note11 = new Note(1, 'A', 1, new int[] {1,2});
        ABCMusic note12 = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elements4 = new ABCMusic[3];
        elements4[0]= note10;
        elements4[1]= note11;
        elements4[2]= note12;
        Measure measure4 = new Measure(3, elements4);
        
        Measure[] measuresTwo = new Measure[2];
        measuresTwo[0]= measure3;
        measuresTwo[1]= measure4;
        Voice voice2 = new Voice("Voice 2", 2, measuresTwo);
        
        
        Voice[] voices = new Voice[2];
        voices[0]= voice1;
        voices[1]= voice2;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("C", 1);
        int[] array = new int[2];
        array[0]= 1;
        array[1]= 8;
        header.put("L", array);
        header.put("T", "MySong");
        
        Song mySong = new Song(2, voices, header);
        String MySongString = "Song: MySong\nVoice 1: A(1,1,1/3),A(1,1,1/6),A(1,1,1/6) | A(1,1,1/3),A(1,1,1/6),"
                + "A(1,1,1/6)\nVoice 2: A(1,1,1/3),A(1,1,1/6),A(1,1,1/6) | A(1,1,1/6),A(1,1,1/2),A(1,1,1/6)";

        assertEquals(true, mySong.toString().equals(MySongString));
}
    
    // Test Equals: 
    // Boundaries: Same Song (should be equal)
    // Different Song (should be false) 
    // Different Song: [ different base notes in the measure of one voice, different note length in the measure of one voice,
    // different accidental in the measure of one voice, different octave in the measure of one voice, different number of
    // elements in the measure of one voice]
    
    @Test
    public void testEqualsSongDifferentOctave() {
        
        ABCMusic note1 = new Note(1, 'A', 2, new int[] {1,6});
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
        Measure measure2 = new Measure(3, elements);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        Voice voice1 = new Voice("Voice 1", 2, measures);
        
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
        
        Measure[] measuresTwo = new Measure[2];
        measuresTwo[0]= measure3;
        measuresTwo[1]= measure4;
        Voice voice2 = new Voice("Voice 2", 2, measuresTwo);
        
        
        Voice[] voices = new Voice[2];
        voices[0]= voice1;
        voices[1]= voice2;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("C", 1);
        int[] array = new int[2];
        array[0]= 1;
        array[1]= 8;
        header.put("L", array);
        header.put("T", "MySong");
        
        Song mySong = new Song(2, voices, header);
       
        
        ABCMusic notea = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteb = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notec = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsa = new ABCMusic[3];
        elementsa[0]= notea;
        elementsa[1]= noteb;
        elementsa[2]= notec;
        Measure measurea = new Measure(3, elementsa);
        
        ABCMusic noted = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notee = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notef = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsb = new ABCMusic[3];
        elementsb[0]= noted;
        elementsb[1]= notee;
        elementsb[2]= notef;
        Measure measureb = new Measure(3, elementsb);
        
        Measure[] measuresA = new Measure[2];
        measuresA[0]= measurea;
        measuresA[1]= measureb;
        Voice voiceA = new Voice("Voice 1", 2, measuresA);
        
        ABCMusic noteg = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteh = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notei = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsC = new ABCMusic[3];
        elementsC[0]= noteg;
        elementsC[1]= noteh;
        elementsC[2]= notei;
        Measure measureC = new Measure(3, elementsC);
        
        ABCMusic notej = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notek = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notel = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsD = new ABCMusic[3];
        elementsD[0]= notej;
        elementsD[1]= notek;
        elementsD[2]= notel;
        Measure measureD = new Measure(3, elementsD);
        
        Measure[] measuresB = new Measure[2];
        measuresB[0]= measureC;
        measuresB[1]= measureD;
        Voice voiceB = new Voice("Voice 2", 2, measuresB);
        
        
        Voice[] voicesB = new Voice[2];
        voicesB[0]= voiceA;
        voicesB[1]= voiceB;
        HashMap<String,Object> headerB = new HashMap<String,Object>();
        headerB.put("C", 1);
        int[] arrayB = new int[2];
        arrayB[0]= 1;
        arrayB[1]= 8;
        headerB.put("L", array);
        headerB.put("T", "MySong");
        
        Song mySongB = new Song(2, voicesB, headerB);
        assertEquals(false, mySong.equals(mySongB));
    
}
    
    @Test
    public void testEqualsSongTrue() {
        
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
        Measure measure2 = new Measure(3, elements);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        Voice voice1 = new Voice("Voice 1", 2, measures);
        
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
        
        Measure[] measuresTwo = new Measure[2];
        measuresTwo[0]= measure3;
        measuresTwo[1]= measure4;
        Voice voice2 = new Voice("Voice 2", 2, measuresTwo);
        
        
        Voice[] voices = new Voice[2];
        voices[0]= voice1;
        voices[1]= voice2;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("C", 1);
        int[] array = new int[2];
        array[0]= 1;
        array[1]= 8;
        header.put("L", array);
        header.put("T", "MySong");
        
        Song mySong = new Song(2, voices, header);
       
        
        ABCMusic notea = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteb = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notec = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsa = new ABCMusic[3];
        elementsa[0]= notea;
        elementsa[1]= noteb;
        elementsa[2]= notec;
        Measure measurea = new Measure(3, elementsa);
        
        ABCMusic noted = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notee = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notef = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsb = new ABCMusic[3];
        elementsb[0]= noted;
        elementsb[1]= notee;
        elementsb[2]= notef;
        Measure measureb = new Measure(3, elementsb);
        
        Measure[] measuresA = new Measure[2];
        measuresA[0]= measurea;
        measuresA[1]= measureb;
        Voice voiceA = new Voice("Voice 1", 2, measuresA);
        
        ABCMusic noteg = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteh = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notei = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsC = new ABCMusic[3];
        elementsC[0]= noteg;
        elementsC[1]= noteh;
        elementsC[2]= notei;
        Measure measureC = new Measure(3, elementsC);
        
        ABCMusic notej = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notek = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notel = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsD = new ABCMusic[3];
        elementsD[0]= notej;
        elementsD[1]= notek;
        elementsD[2]= notel;
        Measure measureD = new Measure(3, elementsD);
        
        Measure[] measuresB = new Measure[2];
        measuresB[0]= measureC;
        measuresB[1]= measureD;
        Voice voiceB = new Voice("Voice 2", 2, measuresB);
        
        
        Voice[] voicesB = new Voice[2];
        voicesB[0]= voiceA;
        voicesB[1]= voiceB;
        HashMap<String,Object> headerB = new HashMap<String,Object>();
        headerB.put("C", 1);
        int[] arrayB = new int[2];
        arrayB[0]= 1;
        arrayB[1]= 8;
        headerB.put("L", array);
        headerB.put("T", "MySong");
        
        Song mySongB = new Song(2, voicesB, headerB);
        assertEquals(true, mySong.equals(mySongB));
    
}

    @Test
    public void testEqualsSongDifferentBaseNote() {
        // different base note in the measure of one voice
        ABCMusic note1 = new Note(1, 'B', 1, new int[] {1,6});
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
        Measure measure2 = new Measure(3, elements);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        Voice voice1 = new Voice("Voice 1", 2, measures);
        
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
        
        Measure[] measuresTwo = new Measure[2];
        measuresTwo[0]= measure3;
        measuresTwo[1]= measure4;
        Voice voice2 = new Voice("Voice 2", 2, measuresTwo);
        
        
        Voice[] voices = new Voice[2];
        voices[0]= voice1;
        voices[1]= voice2;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("C", 1);
        int[] array = new int[2];
        array[0]= 1;
        array[1]= 8;
        header.put("L", array);
        header.put("T", "MySong");
        
        Song mySong = new Song(2, voices, header);
       
        
        ABCMusic notea = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteb = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notec = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsa = new ABCMusic[3];
        elementsa[0]= notea;
        elementsa[1]= noteb;
        elementsa[2]= notec;
        Measure measurea = new Measure(3, elementsa);
        
        ABCMusic noted = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notee = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notef = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsb = new ABCMusic[3];
        elementsb[0]= noted;
        elementsb[1]= notee;
        elementsb[2]= notef;
        Measure measureb = new Measure(3, elementsb);
        
        Measure[] measuresA = new Measure[2];
        measuresA[0]= measurea;
        measuresA[1]= measureb;
        Voice voiceA = new Voice("Voice 1", 2, measuresA);
        
        ABCMusic noteg = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteh = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notei = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsC = new ABCMusic[3];
        elementsC[0]= noteg;
        elementsC[1]= noteh;
        elementsC[2]= notei;
        Measure measureC = new Measure(3, elementsC);
        
        ABCMusic notej = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notek = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notel = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsD = new ABCMusic[3];
        elementsD[0]= notej;
        elementsD[1]= notek;
        elementsD[2]= notel;
        Measure measureD = new Measure(3, elementsD);
        
        Measure[] measuresB = new Measure[2];
        measuresB[0]= measureC;
        measuresB[1]= measureD;
        Voice voiceB = new Voice("Voice 2", 2, measuresB);
        
        
        Voice[] voicesB = new Voice[2];
        voicesB[0]= voiceA;
        voicesB[1]= voiceB;
        HashMap<String,Object> headerB = new HashMap<String,Object>();
        headerB.put("C", 1);
        int[] arrayB = new int[2];
        arrayB[0]= 1;
        arrayB[1]= 8;
        headerB.put("L", array);
        headerB.put("T", "MySong");
        
        Song mySongB = new Song(2, voicesB, headerB);;
        assertEquals(false, mySong.equals(mySongB));
    
}
    @Test
    public void testEqualsSongDifferentAccidental() {
        //different accidental in the measure of one voice
        
        ABCMusic note1 = new Note(-1, 'A', 1, new int[] {1,6});
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
        Measure measure2 = new Measure(3, elements);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        Voice voice1 = new Voice("Voice 1", 2, measures);
        
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
        
        Measure[] measuresTwo = new Measure[2];
        measuresTwo[0]= measure3;
        measuresTwo[1]= measure4;
        Voice voice2 = new Voice("Voice 2", 2, measuresTwo);
        
        
        Voice[] voices = new Voice[2];
        voices[0]= voice1;
        voices[1]= voice2;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("C", 1);
        int[] array = new int[2];
        array[0]= 1;
        array[1]= 8;
        header.put("L", array);
        header.put("T", "MySong");
        
        Song mySong = new Song(2, voices, header);
       
        
        ABCMusic notea = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteb = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notec = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsa = new ABCMusic[3];
        elementsa[0]= notea;
        elementsa[1]= noteb;
        elementsa[2]= notec;
        Measure measurea = new Measure(3, elementsa);
        
        ABCMusic noted = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notee = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notef = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsb = new ABCMusic[3];
        elementsb[0]= noted;
        elementsb[1]= notee;
        elementsb[2]= notef;
        Measure measureb = new Measure(3, elementsb);
        
        Measure[] measuresA = new Measure[2];
        measuresA[0]= measurea;
        measuresA[1]= measureb;
        Voice voiceA = new Voice("Voice 1", 2, measuresA);
        
        ABCMusic noteg = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteh = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notei = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsC = new ABCMusic[3];
        elementsC[0]= noteg;
        elementsC[1]= noteh;
        elementsC[2]= notei;
        Measure measureC = new Measure(3, elementsC);
        
        ABCMusic notej = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notek = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notel = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsD = new ABCMusic[3];
        elementsD[0]= notej;
        elementsD[1]= notek;
        elementsD[2]= notel;
        Measure measureD = new Measure(3, elementsD);
        
        Measure[] measuresB = new Measure[2];
        measuresB[0]= measureC;
        measuresB[1]= measureD;
        Voice voiceB = new Voice("Voice 2", 2, measuresB);
        
        
        Voice[] voicesB = new Voice[2];
        voicesB[0]= voiceA;
        voicesB[1]= voiceB;
        HashMap<String,Object> headerB = new HashMap<String,Object>();
        headerB.put("C", 1);
        int[] arrayB = new int[2];
        arrayB[0]= 1;
        arrayB[1]= 8;
        headerB.put("L", array);
        headerB.put("T", "MySong");
        
        Song mySongB = new Song(2, voicesB, headerB);
        assertEquals(false, mySong.equals(mySongB));
    
}
    @Test
    public void testEqualsSongDifferentNumberElements() {
        // the measures are of unequal length in the two songs
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
        Measure measure2 = new Measure(3, elements);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        Voice voice1 = new Voice("Voice 1", 2, measures);
        
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
        
        Measure[] measuresTwo = new Measure[2];
        measuresTwo[0]= measure3;
        measuresTwo[1]= measure4;
        Voice voice2 = new Voice("Voice 2", 2, measuresTwo);
        
        
        Voice[] voices = new Voice[2];
        voices[0]= voice1;
        voices[1]= voice2;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("C", 1);
        int[] array = new int[2];
        array[0]= 1;
        array[1]= 8;
        header.put("L", array);
        header.put("T", "MySong");
        
        Song mySong = new Song(2, voices, header);
       
        
        ABCMusic notea = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteb = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notec = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsa = new ABCMusic[3];
        elementsa[0]= notea;
        elementsa[1]= noteb;
        elementsa[2]= notec;
        Measure measurea = new Measure(3, elementsa);
        
        ABCMusic noted = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notee = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notef = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsb = new ABCMusic[3];
        elementsb[0]= noted;
        elementsb[1]= notee;
        elementsb[2]= notef;
        Measure measureb = new Measure(3, elementsb);
        
        Measure[] measuresA = new Measure[2];
        measuresA[0]= measurea;
        measuresA[1]= measureb;
        Voice voiceA = new Voice("Voice 1", 2, measuresA);
        
        ABCMusic noteg = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteh = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notei = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsC = new ABCMusic[3];
        elementsC[0]= noteg;
        elementsC[1]= noteh;
        elementsC[2]= notei;
        Measure measureC = new Measure(3, elementsC);
        
        ABCMusic notej = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notek = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notel = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsD = new ABCMusic[3];
        elementsD[0]= notej;
        elementsD[1]= notek;
        elementsD[2]= notel;
        Measure measureD = new Measure(3, elementsD);
        
        Measure[] measuresB = new Measure[2];
        measuresB[0]= measureC;
        measuresB[1]= measureD;
        Voice voiceB = new Voice("Voice 2", 2, measuresB);
        
        
        Voice[] voicesB = new Voice[2];
        voicesB[0]= voiceA;
        voicesB[1]= voiceB;
        HashMap<String,Object> headerB = new HashMap<String,Object>();
        headerB.put("C", 1);
        int[] arrayB = new int[2];
        arrayB[0]= 1;
        arrayB[1]= 8;
        headerB.put("L", array);
        headerB.put("T", "MySong");
        
        Song mySongB = new Song(2, voicesB, headerB);
        assertEquals(false, mySong.equals(mySongB));
    
}
    // Test HashCode: 
    // Boundaries: Same Song (hash code should be the same)
    // Different Song (hash code should be different) 
    // Different Song: [ different base notes in the measure of one voice, different note length in the measure of one voice,
    // different accidental in the measure of one voice, different octave in the measure of one voice, different number of
    // elements in the measure of one voice]
    
    @Test
    public void testHashCodeTrue() {
        
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
        Measure measure2 = new Measure(3, elements);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        Voice voice1 = new Voice("Voice 1", 2, measures);
        
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
        
        Measure[] measuresTwo = new Measure[2];
        measuresTwo[0]= measure3;
        measuresTwo[1]= measure4;
        Voice voice2 = new Voice("Voice 2", 2, measuresTwo);
        
        
        Voice[] voices = new Voice[2];
        voices[0]= voice1;
        voices[1]= voice2;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("C", 1);
        int[] array = new int[2];
        array[0]= 1;
        array[1]= 8;
        header.put("L", array);
        header.put("T", "MySong");
        
        Song mySong = new Song(2, voices, header);
       
        
        ABCMusic notea = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteb = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notec = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsa = new ABCMusic[3];
        elementsa[0]= notea;
        elementsa[1]= noteb;
        elementsa[2]= notec;
        Measure measurea = new Measure(3, elementsa);
        
        ABCMusic noted = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notee = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notef = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsb = new ABCMusic[3];
        elementsb[0]= noted;
        elementsb[1]= notee;
        elementsb[2]= notef;
        Measure measureb = new Measure(3, elementsb);
        
        Measure[] measuresA = new Measure[2];
        measuresA[0]= measurea;
        measuresA[1]= measureb;
        Voice voiceA = new Voice("Voice 1", 2, measuresA);
        
        ABCMusic noteg = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteh = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notei = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsC = new ABCMusic[3];
        elementsC[0]= noteg;
        elementsC[1]= noteh;
        elementsC[2]= notei;
        Measure measureC = new Measure(3, elementsC);
        
        ABCMusic notej = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notek = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notel = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsD = new ABCMusic[3];
        elementsD[0]= notej;
        elementsD[1]= notek;
        elementsD[2]= notel;
        Measure measureD = new Measure(3, elementsD);
        
        Measure[] measuresB = new Measure[2];
        measuresB[0]= measureC;
        measuresB[1]= measureD;
        Voice voiceB = new Voice("Voice 2", 2, measuresB);
        
        
        Voice[] voicesB = new Voice[2];
        voicesB[0]= voiceA;
        voicesB[1]= voiceB;
        HashMap<String,Object> headerB = new HashMap<String,Object>();
        headerB.put("C", 1);
        int[] arrayB = new int[2];
        arrayB[0]= 1;
        arrayB[1]= 8;
        headerB.put("L", array);
        headerB.put("T", "MySong");
        
        Song mySongB = new Song(2, voicesB, headerB);
        assertEquals(true, mySong.hashCode()== mySongB.hashCode());
    
}
    @Test
    public void testHashCodeDifferentBaseNote() {
        // different Base note in one measure of one of the songs
        ABCMusic note1 = new Note(1, 'B', 1, new int[] {1,6});
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
        Measure measure2 = new Measure(3, elements);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        Voice voice1 = new Voice("Voice 1", 2, measures);
        
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
        
        Measure[] measuresTwo = new Measure[2];
        measuresTwo[0]= measure3;
        measuresTwo[1]= measure4;
        Voice voice2 = new Voice("Voice 2", 2, measuresTwo);
        
        
        Voice[] voices = new Voice[2];
        voices[0]= voice1;
        voices[1]= voice2;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("C", 1);
        int[] array = new int[2];
        array[0]= 1;
        array[1]= 8;
        header.put("L", array);
        header.put("T", "MySong");
        
        Song mySong = new Song(2, voices, header);
       
        
        ABCMusic notea = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteb = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notec = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsa = new ABCMusic[3];
        elementsa[0]= notea;
        elementsa[1]= noteb;
        elementsa[2]= notec;
        Measure measurea = new Measure(3, elementsa);
        
        ABCMusic noted = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notee = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notef = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsb = new ABCMusic[3];
        elementsb[0]= noted;
        elementsb[1]= notee;
        elementsb[2]= notef;
        Measure measureb = new Measure(3, elementsb);
        
        Measure[] measuresA = new Measure[2];
        measuresA[0]= measurea;
        measuresA[1]= measureb;
        Voice voiceA = new Voice("Voice 1", 2, measuresA);
        
        ABCMusic noteg = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteh = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notei = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsC = new ABCMusic[3];
        elementsC[0]= noteg;
        elementsC[1]= noteh;
        elementsC[2]= notei;
        Measure measureC = new Measure(3, elementsC);
        
        ABCMusic notej = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notek = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notel = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsD = new ABCMusic[3];
        elementsD[0]= notej;
        elementsD[1]= notek;
        elementsD[2]= notel;
        Measure measureD = new Measure(3, elementsD);
        
        Measure[] measuresB = new Measure[2];
        measuresB[0]= measureC;
        measuresB[1]= measureD;
        Voice voiceB = new Voice("Voice 2", 2, measuresB);
        
        
        Voice[] voicesB = new Voice[2];
        voicesB[0]= voiceA;
        voicesB[1]= voiceB;
        HashMap<String,Object> headerB = new HashMap<String,Object>();
        headerB.put("C", 1);
        int[] arrayB = new int[2];
        arrayB[0]= 1;
        arrayB[1]= 8;
        headerB.put("L", array);
        headerB.put("T", "MySong");
        
        Song mySongB = new Song(2, voicesB, headerB);
        assertEquals(false, mySong.hashCode()== mySongB.hashCode());
    
}
    @Test
    public void testHashCodeDifferentAccidental() {
        // different accidental in the measure of one of the songs
        ABCMusic note1 = new Note(-1, 'A', 1, new int[] {1,6});
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
        Measure measure2 = new Measure(3, elements);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        Voice voice1 = new Voice("Voice 1", 2, measures);
        
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
        
        Measure[] measuresTwo = new Measure[2];
        measuresTwo[0]= measure3;
        measuresTwo[1]= measure4;
        Voice voice2 = new Voice("Voice 2", 2, measuresTwo);
        
        
        Voice[] voices = new Voice[2];
        voices[0]= voice1;
        voices[1]= voice2;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("C", 1);
        int[] array = new int[2];
        array[0]= 1;
        array[1]= 8;
        header.put("L", array);
        header.put("T", "MySong");
        
        Song mySong = new Song(2, voices, header);
       
        
        ABCMusic notea = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteb = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notec = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsa = new ABCMusic[3];
        elementsa[0]= notea;
        elementsa[1]= noteb;
        elementsa[2]= notec;
        Measure measurea = new Measure(3, elementsa);
        
        ABCMusic noted = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notee = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notef = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsb = new ABCMusic[3];
        elementsb[0]= noted;
        elementsb[1]= notee;
        elementsb[2]= notef;
        Measure measureb = new Measure(3, elementsb);
        
        Measure[] measuresA = new Measure[2];
        measuresA[0]= measurea;
        measuresA[1]= measureb;
        Voice voiceA = new Voice("Voice 1", 2, measuresA);
        
        ABCMusic noteg = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteh = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notei = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsC = new ABCMusic[3];
        elementsC[0]= noteg;
        elementsC[1]= noteh;
        elementsC[2]= notei;
        Measure measureC = new Measure(3, elementsC);
        
        ABCMusic notej = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notek = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notel = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsD = new ABCMusic[3];
        elementsD[0]= notej;
        elementsD[1]= notek;
        elementsD[2]= notel;
        Measure measureD = new Measure(3, elementsD);
        
        Measure[] measuresB = new Measure[2];
        measuresB[0]= measureC;
        measuresB[1]= measureD;
        Voice voiceB = new Voice("Voice 2", 2, measuresB);
        
        
        Voice[] voicesB = new Voice[2];
        voicesB[0]= voiceA;
        voicesB[1]= voiceB;
        HashMap<String,Object> headerB = new HashMap<String,Object>();
        headerB.put("C", 1);
        int[] arrayB = new int[2];
        arrayB[0]= 1;
        arrayB[1]= 8;
        headerB.put("L", array);
        headerB.put("T", "MySong");
        
        Song mySongB = new Song(2, voicesB, headerB);
        assertEquals(false, mySong.hashCode()== mySongB.hashCode());
}
    @Test
    public void testHashCodeDifferentLengthMeasure() {
        // different accidental in the measure of one of the songs
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
        Measure measure2 = new Measure(3, elements);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        Voice voice1 = new Voice("Voice 1", 2, measures);
        
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
        
        Measure[] measuresTwo = new Measure[2];
        measuresTwo[0]= measure3;
        measuresTwo[1]= measure4;
        Voice voice2 = new Voice("Voice 2", 2, measuresTwo);
        
        
        Voice[] voices = new Voice[2];
        voices[0]= voice1;
        voices[1]= voice2;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("C", 1);
        int[] array = new int[2];
        array[0]= 1;
        array[1]= 8;
        header.put("L", array);
        header.put("T", "MySong");
        
        Song mySong = new Song(2, voices, header);
       
        
        ABCMusic notea = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteb = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notec = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsa = new ABCMusic[3];
        elementsa[0]= notea;
        elementsa[1]= noteb;
        elementsa[2]= notec;
        Measure measurea = new Measure(3, elementsa);
        
        ABCMusic noted = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notee = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notef = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsb = new ABCMusic[3];
        elementsb[0]= noted;
        elementsb[1]= notee;
        elementsb[2]= notef;
        Measure measureb = new Measure(3, elementsb);
        
        Measure[] measuresA = new Measure[2];
        measuresA[0]= measurea;
        measuresA[1]= measureb;
        Voice voiceA = new Voice("Voice 1", 2, measuresA);
        
        ABCMusic noteg = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteh = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notei = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsC = new ABCMusic[3];
        elementsC[0]= noteg;
        elementsC[1]= noteh;
        elementsC[2]= notei;
        Measure measureC = new Measure(3, elementsC);
        
        ABCMusic notej = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notek = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notel = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsD = new ABCMusic[3];
        elementsD[0]= notej;
        elementsD[1]= notek;
        elementsD[2]= notel;
        Measure measureD = new Measure(3, elementsD);
        
        Measure[] measuresB = new Measure[2];
        measuresB[0]= measureC;
        measuresB[1]= measureD;
        Voice voiceB = new Voice("Voice 2", 2, measuresB);
        
        
        Voice[] voicesB = new Voice[2];
        voicesB[0]= voiceA;
        voicesB[1]= voiceB;
        HashMap<String,Object> headerB = new HashMap<String,Object>();
        headerB.put("C", 1);
        int[] arrayB = new int[2];
        arrayB[0]= 1;
        arrayB[1]= 8;
        headerB.put("L", array);
        headerB.put("T", "MySong");
        
        Song mySongB = new Song(2, voicesB, headerB);
        assertEquals(false, mySong.hashCode()== mySongB.hashCode());
}
    @Test
    public void testHashCodeDifferentOctave() {
        // different Octave in the measure of one of the songs
        ABCMusic note1 = new Note(1, 'A', 2, new int[] {1,6});
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
        Measure measure2 = new Measure(3, elements);
        
        Measure[] measures = new Measure[2];
        measures[0]= measure1;
        measures[1]= measure2;
        Voice voice1 = new Voice("Voice 1", 2, measures);
        
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
        
        Measure[] measuresTwo = new Measure[2];
        measuresTwo[0]= measure3;
        measuresTwo[1]= measure4;
        Voice voice2 = new Voice("Voice 2", 2, measuresTwo);
        
        
        Voice[] voices = new Voice[2];
        voices[0]= voice1;
        voices[1]= voice2;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("C", 1);
        int[] array = new int[2];
        array[0]= 1;
        array[1]= 8;
        header.put("L", array);
        header.put("T", "MySong");
        
        Song mySong = new Song(2, voices, header);
       
        
        ABCMusic notea = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteb = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notec = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsa = new ABCMusic[3];
        elementsa[0]= notea;
        elementsa[1]= noteb;
        elementsa[2]= notec;
        Measure measurea = new Measure(3, elementsa);
        
        ABCMusic noted = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notee = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notef = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsb = new ABCMusic[3];
        elementsb[0]= noted;
        elementsb[1]= notee;
        elementsb[2]= notef;
        Measure measureb = new Measure(3, elementsb);
        
        Measure[] measuresA = new Measure[2];
        measuresA[0]= measurea;
        measuresA[1]= measureb;
        Voice voiceA = new Voice("Voice 1", 2, measuresA);
        
        ABCMusic noteg = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic noteh = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notei = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsC = new ABCMusic[3];
        elementsC[0]= noteg;
        elementsC[1]= noteh;
        elementsC[2]= notei;
        Measure measureC = new Measure(3, elementsC);
        
        ABCMusic notej = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notek = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic notel = new Note(1, 'A', 1, new int[] {1,6});
        ABCMusic[] elementsD = new ABCMusic[3];
        elementsD[0]= notej;
        elementsD[1]= notek;
        elementsD[2]= notel;
        Measure measureD = new Measure(3, elementsD);
        
        Measure[] measuresB = new Measure[2];
        measuresB[0]= measureC;
        measuresB[1]= measureD;
        Voice voiceB = new Voice("Voice 2", 2, measuresB);
        
        
        Voice[] voicesB = new Voice[2];
        voicesB[0]= voiceA;
        voicesB[1]= voiceB;
        HashMap<String,Object> headerB = new HashMap<String,Object>();
        headerB.put("C", 1);
        int[] arrayB = new int[2];
        arrayB[0]= 1;
        arrayB[1]= 8;
        headerB.put("L", array);
        headerB.put("T", "MySong");
        
        Song mySongB = new Song(2, voicesB, headerB);
        assertEquals(false, mySong.hashCode()== mySongB.hashCode());
}
}