package player;

import org.antlr.runtime.RecognitionException;

import player.ABCMusic;

public interface PlayerInterface {
    
    /**
     * Parse a string containing the abc file into an ABCMusic tree.
     * 
     * A valid file may contain integers for octave, accidentals, and notelength(fractions are represented as int/int), 
     * a sequence of base notes[a-gA-G] with Octave and accidental charachters, lyrics with any letter and charachter, 
     * parentheses, whitespace (spaces and tabs), square brackets, and a header containing fields X, T, M, L, Q, K carrying
     * integers, letters, and charachters. 
     * 
     * 
     * A valid abc file should be well-formed with only valid notes, measures separated by bars, spaces between measures 
     * and spaces between notes if they are not chords and tuplets. A chord should be of form [ABC] and can contain notelengths
     * and a tuplet should be of form (3ABC with an open bracket, integer representing the number of notes and noteslengths.
     * 
     * 
     * @param String input
     *            The abc file read as a string. May not be null. 
     * @return The abc file as a tree.
     * @throws RecognitionException 
     * @throw an exception if the abc file is not valid
     */

        public ABCMusic parse(String input);
        
}

        
        
    