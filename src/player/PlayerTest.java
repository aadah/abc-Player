package player;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;


public class PlayerTest {
    
    // Tests for Parser: 
    // Parses correctly a few music files with accidentals, different octaves, chords, base notes 
    // Throws an exception when giving an invalid music file
    
    
    @Test
    public void testBasicParse1() throws IOException {
        // Simple file with one measure: _ab |
        ABCMusic note1=  new Note(-1, 'A', 1, new int[] {1,1});
        ABCMusic note2= new Note(0, 'B', 1, new int[] {1,1});
        ABCMusic[] elements = new ABCMusic[2];
        elements[0]= note1;
        elements[1]= note2;
        
        Measure measure1 = new Measure(2, elements);
        
        Measure[] measures = new Measure[1];
        
        measures[0] = measure1;
        
        Voice voice1 = new Voice("VOICE 1", 1, measures);
        
        Voice[] voices = new Voice[1];
        voices[0]= voice1;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("X", 1);
        header.put("T", "MySong");
        header.put("K", "D");
        Song mySong = new Song(1, voices, header);
        assertEquals(verifyParser("sample_abc/SampleParser1.abc"), mySong.toString());
    }
    
   
    
    @Test
    public void testBasicParse2KeyC() throws IOException {
        // Simple file with two measures, with different octave and accidentals and in C octave
        // ^AB | c' |
        ABCMusic note1=  new Note(1, 'A', 0, new int[] {1,1});
        ABCMusic note2= new Note(0, 'B', 0, new int[] {1,1});
        ABCMusic[] elements = new ABCMusic[2];
        elements[0]= note1;
        elements[1]= note2;
        Measure measure1 = new Measure(2, elements);
        
        ABCMusic note3=  new Note(0, 'C', 2, new int[] {1,1});
        ABCMusic[] elements2 = new ABCMusic[1];
        elements2[0]= note3;
        Measure measure2 = new Measure(1, elements2);
        
        Measure[] measures = new Measure[2];
        measures[0] = measure1;
        measures[1] = measure2;
        Voice voice1 = new Voice("VOICE 1", 2, measures);
        
        Voice[] voices = new Voice[1];
        voices[0]= voice1;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("X", 1);
        header.put("T", "MySong");
        header.put("K", "D");
        Song mySong = new Song(1, voices, header);
        
        assertEquals(verifyParser("sample_abc/SampleParser2.abc"), mySong.toString());
    }
    
    
    @Test
    public void testBasicParse2KeyD() throws IOException {
        // Simple file with two measures, with different octave and accidentals and in D octave
        // ^AB | c' |
        ABCMusic note1=  new Note(1, 'A', 0, new int[] {1,1});
        ABCMusic note2= new Note(0, 'B', 0, new int[] {1,1});
        ABCMusic[] elements = new ABCMusic[2];
        elements[0]= note1;
        elements[1]= note2;
        Measure measure1 = new Measure(2, elements);
        
        ABCMusic note3=  new Note(1, 'C', 2, new int[] {1,1});
        ABCMusic[] elements2 = new ABCMusic[1];
        elements2[0]= note3;
        Measure measure2 = new Measure(1, elements2);
        
        Measure[] measures = new Measure[2];
        measures[0] = measure1;
        measures[1] = measure2;
        Voice voice1 = new Voice("VOICE 1", 2, measures);
        
        Voice[] voices = new Voice[1];
        voices[0]= voice1;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("X", 1);
        header.put("T", "MySong");
        header.put("K", "D");
        Song mySong = new Song(1, voices, header);
        
        assertEquals(verifyParser("sample_abc/SampleParser2KeyD.abc"), mySong.toString());
    }
    
    // Invalid File, does not contain X field in header. 
    @Test(expected = RuntimeException.class)  
    public void testBasicParseInvalidFile() throws IOException {
       verifyParser("sample_abc/SampleParser3.abc");
    }
    
    
    @Test
    public void testBasicParse3() throws IOException {
       // a more complicated file with accidental, multiple measures, different octaves and chords
       // _ab | A B | [ABC] | a b' |
        
        ABCMusic note1=  new Note(-1, 'A', 1, new int[] {1,1});
        ABCMusic note2= new Note(0, 'B', 1, new int[] {1,1});
        ABCMusic[] elements = new ABCMusic[2];
        elements[0]= note1;
        elements[1]= note2;
        Measure measure1 = new Measure(2, elements);
        
        ABCMusic note3=  new Note(0, 'A', 0, new int[] {1,1});
        ABCMusic note4= new Note(0, 'B', 0, new int[] {1,1});
        ABCMusic[] elements2 = new ABCMusic[2];
        elements2[0]= note3;
        elements2[1]= note4;
        Measure measure2 = new Measure(2, elements2);
        
        Note[] notes1 = new Note[3];
        notes1[0]= new Note(0, 'A', 0, new int[] {1,1});
        notes1[1]= new Note(0, 'B', 0, new int[] {1,1});
        notes1[2] = new Note(0, 'C', 0, new int[] {1,1});
        ABCMusic chord1 = new Chord(3, notes1);
        ABCMusic[] elements3 = new ABCMusic[1];
        elements3[0]= chord1;
        Measure measure3 = new Measure(1, elements3);
        
        ABCMusic note5=  new Note(0, 'A', 1, new int[] {1,1});
        ABCMusic note6= new Note(0, 'B', 2, new int[] {1,1});
        ABCMusic[] elements4 = new ABCMusic[2];
        elements4[0]= note5;
        elements4[1]= note6;
        Measure measure4 = new Measure(2, elements4);
        
        
        Measure[] measures = new Measure[4];
        measures[0] = measure1;
        measures[1] = measure2;
        measures[2] = measure3;
        measures[3]= measure4;
        Voice voice1 = new Voice("VOICE 1", 4, measures);
        
        Voice[] voices = new Voice[1];
        voices[0]= voice1;
        HashMap<String,Object> header = new HashMap<String,Object>();
        header.put("X", 1);
        header.put("T", "MySong");
        header.put("K", "D");
        Song mySong = new Song(1, voices, header);
        
        assertEquals(verifyParser("sample_abc/SampleParser4.abc"), mySong.toString());
    }
    
    /**
     * Takes in an abc music file, reads it, converts it in to a string and parses it. 
     * @param String fileName name of the abc music file
     * @return A Song from the abc music file as interpreted by the parser and listener
     * 
     */
    
    public String verifyParser(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append('\n');
            line = br.readLine();
        }
        
        String text = sb.toString();
        br.close();
    
        Player player = new Player();
        Song s = (Song) player.parse(text);
        return s.toString();
}
}

