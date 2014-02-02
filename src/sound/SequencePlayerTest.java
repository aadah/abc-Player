package sound;

import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import player.ABCMusic;
import player.Note;
import player.Chord;
import player.Song;
import player.Tuplet;
import player.Measure;
import player.Voice;
/**
 * Music Tests that didit cannot play
 * @category no_didit
 */

public class SequencePlayerTest {
    //@Test
    public void SuperMarioNoteDemo2() {
        Note n1 = new Note(1,'F',0,new int[]{1,2});
        Note n2 = new Note(0,'E',1,new int[]{1,2});
        Chord c1 = new Chord(2, new Note[] {n1, n2});//*
            
        Note n3 = new Note(1,'F',0,new int[]{1,2});
        Note n4 = new Note(0,'E',1,new int[]{1,2});
        Chord c2 = new Chord(2, new Note[] {n3, n4});//*
            
        // rest length 6
        Note r1 = new Note(0,'z',0,new int[] {1,2});//*
            
        Note n5 = new Note(1,'F',0,new int[]{1,2});
        Note n6 = new Note(0,'E',1,new int[]{1,2});
        Chord c3 = new Chord(2, new Note[] {n5, n6});//*
            
        // rest length 6
        Note r2 = new Note(0,'z',0,new int[] {1,2});//*

        Note n7 = new Note(1,'F',0,new int[]{1,2});
        Note n8 = new Note(0,'C',1,new int[]{1,2});
        Chord c4 = new Chord(2, new Note[] {n7, n8});//*

        Note n9 = new Note(1,'F',0,new int[]{1,1});
        Note n10 = new Note(0,'E',1,new int[]{1,1});
        Chord c5 = new Chord(2, new Note[] {n9, n10});//*
            
        Measure m1 = new Measure(7, new ABCMusic[] {c1,c2,r1,c3,r2,c4,c5});//*
            
        // NEW BAR
        
        Note n11 = new Note(0,'G',0,new int[]{1,1});
        Note n12 = new Note(0,'B',0,new int[]{1,1});
        Note n13 = new Note(0,'G',1,new int[]{1,1});
        Chord c6 = new Chord(3, new Note[] {n11, n12, n13});//*
            
        // rest length 12
        Note r3 = new Note(0,'z',0,new int[] {1,1});//*
            
        Note n14 = new Note(0,'G',0,new int[]{1,1});//*
        
        // rest length 12
        Note r4 = new Note(0,'z',0,new int[] {1,1});//*
            
        Measure m2 = new Measure(4, new ABCMusic[] {c6,r3,n14,r4});//*

        // NEW BAR
        Note n15 = new Note(0,'C',1,new int[]{3,2});//*
        
        Note n16 = new Note(0,'G',0,new int[]{1,2});//*
        
        // rest length 12
        Note r5 = new Note(0,'z',0,new int[] {1,1});//*
            
        Note n17 = new Note(0,'E',0,new int[]{1,1});//*

        Measure m3 = new Measure(4, new ABCMusic[] {n15,n16,r5,n17});//*

        // NEW BAR

        Note n18 = new Note(0,'E',0,new int[]{1,2});//*
            
        Note n19 = new Note(0,'A',0,new int[]{1,1});//*
            
        Note n20 = new Note(0,'B',0,new int[]{1,1});//*
            
        Note n21 = new Note(-1,'B',0,new int[]{1,2});//*
            
        Note n22 = new Note(0,'A',0,new int[]{1,1});//*
            
        Measure m4 = new Measure(4, new ABCMusic[] {n18,n19,n20,n21,n22});//*

        // NEW BAR

        Note n23 = new Note(0,'G',0,new int[]{2,3});
        Note n24 = new Note(0,'E',1,new int[]{2,3});
        Note n25 = new Note(0,'G',1,new int[]{2,3});
        Tuplet t1 = new Tuplet(3, new ABCMusic[] {n23,n24,n25});//*

        Note n26 = new Note(0,'A',1,new int[]{1,1});//*
            
        Note n27 = new Note(0,'F',1,new int[]{1,2});//*
            
        Note n28 = new Note(0,'G',1,new int[]{1,2});//*
            
        Measure m5 = new Measure(4, new ABCMusic[] {t1,n26,n27,n28});//*

        // NEW BAR
        
        // rest length 6
        Note r6 = new Note(0,'z',0,new int[]{1,2});//*
            
        Note n29 = new Note(0,'E',1,new int[]{1,1});//*
            
        Note n30 = new Note(0,'C',1,new int[]{1,2});//*
            
        Note n31 = new Note(0,'D',1,new int[]{1,2});//*
            
        Note n32 = new Note(0,'B',0,new int[]{3,4});//*
            
        Note r7 = new Note(0,'z',0,new int[]{3,4});//*
        
        Measure m6 = new Measure(6, new ABCMusic[] {r6,n29,n30,n31,n32,r7});//*
        
        Voice v1 = new Voice("Voice 1", 2, new Measure[] {m1,m2,m3,m4,m5,m6});//*

        Map<String, Object> header = new HashMap<String, Object>();
        header.put("Q", 200);
        header.put("L", new int[] {1,4});
        Song s = new Song(1, new Voice[] {v1}, header);
            
        // play!
        SequencePlayer player = s.createPlayer();
        try {
            player.play();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    //@Test
    public void SuperMarioNoteDemo() {
        SequencePlayer player;
        try {
            LyricListener listener = new OurLyricListener();

            player = new SequencePlayer(200, 12, listener);
            
            player.addNote(new Note(1,'F',0,new int[]{1,2}).toMidi(), 0, 6);
            player.addNote(new Note(0,'E',1,new int[]{1,2}).toMidi(), 0, 6);
            
            player.addNote(new Note(1,'F',0,new int[]{1,2}).toMidi(), 6, 6);
            player.addNote(new Note(0,'E',1,new int[]{1,2}).toMidi(), 6, 6);
            
            // rest length 6
            
            player.addNote(new Note(1,'F',0,new int[]{1,2}).toMidi(), 18, 6);
            player.addNote(new Note(0,'E',1,new int[]{1,2}).toMidi(), 18, 6);
            
            // rest length 6

            player.addNote(new Note(1,'F',0,new int[]{1,2}).toMidi(), 30, 6);
            player.addNote(new Note(0,'C',1,new int[]{1,2}).toMidi(), 30, 6);

            player.addNote(new Note(1,'F',0,new int[]{1,2}).toMidi(), 36, 6);
            player.addNote(new Note(0,'E',1,new int[]{1,2}).toMidi(), 36, 6);

            // NEW BAR

            player.addNote(new Note(0,'G',0,new int[]{1,2}).toMidi(), 48, 12);
            player.addNote(new Note(0,'B',0,new int[]{1,2}).toMidi(), 48, 12);
            player.addNote(new Note(0,'G',1,new int[]{1,2}).toMidi(), 48, 12);
            
            // rest length 12
            
            player.addNote(new Note(0,'G',0,new int[]{1,2}).toMidi(), 72, 12);
            
            // rest length

            // NEW BAR

            player.addNote(new Note(0,'C',1,new int[]{1,2}).toMidi(), 96, 18);
            
            player.addNote(new Note(0,'G',0,new int[]{1,2}).toMidi(), 114, 6);
            
            // rest length 12
            
            player.addNote(new Note(0,'E',0,new int[]{1,2}).toMidi(), 132, 12);

            // NEW BAR

            player.addNote(new Note(0,'E',0,new int[]{1,2}).toMidi(), 144, 6);
            
            player.addNote(new Note(0,'A',0,new int[]{1,2}).toMidi(), 150, 12);
            
            player.addNote(new Note(0,'B',0,new int[]{1,2}).toMidi(), 162, 12);
            
            player.addNote(new Note(-1,'B',0,new int[]{1,2}).toMidi(), 174, 6);
            
            player.addNote(new Note(0,'A',0,new int[]{1,2}).toMidi(), 180, 12);

            // NEW BAR

            player.addNote(new Note(0,'G',0,new int[]{1,2}).toMidi(), 192, 8);
            
            player.addNote(new Note(0,'E',1,new int[]{1,2}).toMidi(), 200, 8);
            
            player.addNote(new Note(0,'G',1,new int[]{1,2}).toMidi(), 208, 8);

            player.addNote(new Note(0,'A',1,new int[]{1,2}).toMidi(), 216, 12);
            
            player.addNote(new Note(0,'F',1,new int[]{1,2}).toMidi(), 228, 6);
            
            player.addNote(new Note(0,'G',1,new int[]{1,2}).toMidi(), 234, 6);

            // NEW BAR
            
            // rest length 6
            
            player.addNote(new Note(0,'E',1,new int[]{1,2}).toMidi(), 246, 12);
            
            player.addNote(new Note(0,'C',1,new int[]{1,2}).toMidi(), 258, 6);
            
            player.addNote(new Note(0,'D',1,new int[]{1,2}).toMidi(), 264, 6);
            
            player.addNote(new Note(0,'B',0,new int[]{1,2}).toMidi(), 270, 9);

            // play!
            player.play();

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
    
    //@Test
    public void AmazingGracetest() {
        SequencePlayer player;
        try {

            LyricListener listener = new LyricListener() {
                public void processLyricEvent(String text) {
                    System.out.println(text);
                }
            };

            player = new SequencePlayer(100, 1, listener);
            // Starts from 4th note since 1-4 is a rest.
            player.addNote(new Pitch('D').toMidiNote(), 4, 2);
            player.addLyricEvent("A-", 4);
            //NEW BAR

            player.addNote(new Pitch('G').toMidiNote(), 6, 4);
            player.addLyricEvent("ma", 6);
            player.addNote(new Pitch('B').toMidiNote(), 10, 1);
            player.addLyricEvent("zing", 10);
            player.addNote(new Pitch('G').toMidiNote(), 11, 1);
            //NEW BAR
            
            player.addNote(new Pitch('B').toMidiNote(), 12, 4);
            player.addLyricEvent("grace!", 12);
            player.addNote(new Pitch('A').toMidiNote(), 16, 2);
            player.addLyricEvent("How", 16);

            player.addNote(new Pitch('G').toMidiNote(), 18, 4);
            player.addLyricEvent("sweet", 18);
            player.addNote(new Pitch('E').toMidiNote(), 22, 2);
            player.addLyricEvent("the", 22);
            //NEW BAR

            player.addNote(new Pitch('D').toMidiNote(), 24, 4);
            player.addLyricEvent("sound", 24);
            player.addNote(new Pitch('D').toMidiNote(), 28, 2);
            player.addLyricEvent("that", 28);
            //NEW BAR

            player.addNote(new Pitch('G').toMidiNote(), 30, 4);
            player.addLyricEvent("saved", 30);
            player.addNote(new Pitch('B').toMidiNote(), 34, 1);
            player.addLyricEvent("a", 34);
            player.addNote(new Pitch('G').toMidiNote(), 35, 1);
            //NEW BAR
            
            player.addNote(new Pitch('B').toMidiNote(), 36, 4);
            player.addLyricEvent("wretch", 36);
            player.addNote(new Pitch('A').toMidiNote(), 40, 2);
            player.addLyricEvent("like", 40);
            //NEW BAR
            
            player.addNote(new Pitch('D').transpose(Pitch.OCTAVE).toMidiNote(),
                    42, 6);
            player.addLyricEvent("me", 42);
            player.addNote(new Pitch('D').transpose(Pitch.OCTAVE).toMidiNote(),
                    48, 2);

            // play!
            player.play();

            /*
             * Note: A possible weird behavior of the Java sequencer: Even if
             * the sequencer has finished playing all of the scheduled notes and
             * is manually closed, the program may not terminate. This is likely
             * due to daemon threads that are spawned when the sequencer is
             * opened but keep on running even after the sequencer is killed. In
             * this case, you need to explicitly exit the program with
             * System.exit(0).
             */
            // System.exit(0);

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    //@Test
    public void PieceOnetest() {
        SequencePlayer player;
        try {

            LyricListener listener = new LyricListener() {
                public void processLyricEvent(String text) {
                    System.out.println(text);
                }
            };

            player = new SequencePlayer(140, 12, listener);
         
            player.addNote(new Pitch('C').toMidiNote(), 0, 12);
            player.addNote(new Pitch('C').toMidiNote(), 12, 12);
            player.addNote(new Pitch('C').toMidiNote(), 24, 9);
            player.addNote(new Pitch('D').toMidiNote(), 33, 3);
            player.addNote(new Pitch('E').toMidiNote(), 36, 12);
            //NEW BAR
            
            player.addNote(new Pitch('E').toMidiNote(), 48, 9);
            player.addNote(new Pitch('D').toMidiNote(), 57, 3);
            player.addNote(new Pitch('E').toMidiNote(), 60, 9);
            player.addNote(new Pitch('F').toMidiNote(), 69, 3);
            player.addNote(new Pitch('G').toMidiNote(), 72, 24);
            //NEW BAR
            
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(),
                    96, 4);
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(),
                    100, 4);
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(),
                    104, 4);

            player.addNote(new Pitch('G').toMidiNote(), 108, 4);
            player.addNote(new Pitch('G').toMidiNote(), 112, 4);
            player.addNote(new Pitch('G').toMidiNote(), 116, 4);
            player.addNote(new Pitch('E').toMidiNote(), 120, 4);
            player.addNote(new Pitch('E').toMidiNote(), 124, 4);
            player.addNote(new Pitch('E').toMidiNote(), 128, 4);
            player.addNote(new Pitch('C').toMidiNote(), 132, 4);
            player.addNote(new Pitch('C').toMidiNote(), 136, 4);
            player.addNote(new Pitch('C').toMidiNote(), 140, 4);
            //NEW BAR
            
            player.addNote(new Pitch('G').toMidiNote(), 144, 9);
            player.addNote(new Pitch('F').toMidiNote(), 153, 3);
            player.addNote(new Pitch('E').toMidiNote(), 156, 9);
            player.addNote(new Pitch('D').toMidiNote(), 165, 3);
            player.addNote(new Pitch('C').toMidiNote(), 168, 24);

            System.out.println(player);

            // play!
            player.play();

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

   // @Test
    public void PieceTwotest() {
        SequencePlayer player;
        try {

            LyricListener listener = new LyricListener() {
                public void processLyricEvent(String text) {
                    System.out.println(text);
                }
            };

            player = new SequencePlayer(200, 12, listener);

            player.addNote(new Pitch('F').accidentalTranspose(1).toMidiNote(),
                    0, 6);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(),
                    0, 6);
            player.addNote(new Pitch('F').accidentalTranspose(1).toMidiNote(),
                    6, 6);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(),
                    6, 6);
            // rest length 6
            player.addNote(new Pitch('F').accidentalTranspose(1).toMidiNote(),
                    18, 6);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(),
                    18, 6);
            // rest length 6
            player.addNote(new Pitch('F').accidentalTranspose(1).toMidiNote(),
                    30, 6);
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(),
                    30, 6);
            player.addNote(new Pitch('F').accidentalTranspose(1).toMidiNote(),
                    36, 12);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(),
                    36, 12);

            // NEW BAR

            player.addNote(new Pitch('G').toMidiNote(), 48, 12);
            player.addNote(new Pitch('B').toMidiNote(), 48, 12);
            player.addNote(new Pitch('G').transpose(Pitch.OCTAVE).toMidiNote(),
                    48, 12);
            // rest length 12
            player.addNote(new Pitch('G').toMidiNote(), 72, 12);
            // rest length

            // NEW BAR

            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(),
                    96, 18);
            player.addNote(new Pitch('G').toMidiNote(), 114, 6);
            // rest length 12
            player.addNote(new Pitch('E').toMidiNote(), 132, 12);

            // NEW BAR

            player.addNote(new Pitch('E').toMidiNote(), 144, 6);
            player.addNote(new Pitch('A').toMidiNote(), 150, 12);
            player.addNote(new Pitch('B').toMidiNote(), 162, 12);
            player.addNote(new Pitch('B').accidentalTranspose(-1).toMidiNote(),
                    174, 6);
            player.addNote(new Pitch('A').toMidiNote(), 180, 12);

            // NEW BAR

            player.addNote(new Pitch('G').toMidiNote(), 192, 8);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(),
                    200, 8);
            player.addNote(new Pitch('G').transpose(Pitch.OCTAVE).toMidiNote(),
                    208, 8);

            player.addNote(new Pitch('A').transpose(Pitch.OCTAVE).toMidiNote(),
                    216, 12);
            player.addNote(new Pitch('F').transpose(Pitch.OCTAVE).toMidiNote(),
                    228, 6);
            player.addNote(new Pitch('G').transpose(Pitch.OCTAVE).toMidiNote(),
                    234, 6);

            // NEW BAR
            // rest length 6
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(),
                    246, 12);
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(),
                    258, 6);
            player.addNote(new Pitch('D').transpose(Pitch.OCTAVE).toMidiNote(),
                    264, 6);
            player.addNote(new Pitch('B').toMidiNote(), 270, 9);

            // play!
            player.play();

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
}
