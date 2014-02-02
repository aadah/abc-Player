package player;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

import grammar.ABCMusicLexer;

public class LexerTest {
    
    // Boundaries for Lexer Test:
    // Single accidental, double accidental, Single Octave, Double Octave, Single Base Note, Base Note with Accidental, 
    // Note Length, Base Note with Length, Chord, Chord with Note Lengths
    // Tuplet, Tuplet with Accidental and Octave Shift, paranthesis, lyrics, lyrics with charachters, 
    // lyrics with base notes, measure, measure with note lengths
    

        @Test
        public void testTokenAccidentalSharp() {
            verifyLexer("^", new String[] { "^" });
        }
        
        @Test
        public void testTokenAccidentalFlat() {
            verifyLexer("_", new String[] { "_" });
        }
        
        @Test
        public void testTokenAccidentalDoubleFlat() {
            verifyLexer("__", new String[] { "__" });
        }
        
        @Test
        public void testTokenAccidentalDoubleSharp() {
            verifyLexer("^^", new String[] { "^^" });
        }
        
        @Test
        public void testTokenSingleOctaveUp() {
            verifyLexer("'", new String[] { "'" });
        }
        
        @Test
        public void testTokenDoubleOctave() {
            verifyLexer("''", new String[] { "''" });
        }
        
        @Test
        public void testTokenOctaveDown() {
            verifyLexer(",", new String[] { "," });
        }
        
        
        @Test
        public void testTokenBaseNote() {
            verifyLexer("A", new String[] { "A" });
        }
        
        @Test
        public void testTokenNoteLength() {
            verifyLexer("1/4", new String[] {"1","/","4" });
        }

        @Test
        public void testTokenSimpleChord() {
            verifyLexer("[ABC]", new String[] { "[","A","B","C","]" });
        }
        
        @Test
        public void testTokenSimpleChordWithNoteLength() {
            verifyLexer("[A/B1/4C]", new String[] { "[","A","/", "B","1", "/", "4", "C","]" });
        }
        
        @Test
        public void testTokenSimpleTuplet() {
            verifyLexer("(3ABC", new String[] {"(", "3","A","B","C" });
        }
        
        @Test
        public void testTokenTupletWithOctaveAndAccidental() {
            verifyLexer("^(3AB'C", new String[] {"^", "(", "3","A","B","'","C" });
        }
        
        @Test
        public void testTokenSpace() {
            verifyLexer("( )", new String[] {"(", " ", ")" });
        }
        
        @Test
        public void testTokenMeasure() {
            verifyLexer("(3ABC [a/B/c/] |", new String[] {"(", "3","A","B","C", " ", "[", "a", "/", "B", "/", "c", "/", "]", " ", "|"});
        }
       
        
        @Test
        public void testTokenNotesWithNoteLength() {
            verifyLexer("A1/2B1/3C/", new String[] { "A","1","/","2", "B", "1", "/", "3", "C", "/" });
        }
        
        @Test
        public void testTokenLyrics(){
            verifyLexer("Now I know my A,B,C!", new String[] { "Now", " ", "I", " ", "know", " ", "my", " ",  "A", ",", "B", ",", "C", "!" });
        }
        
        @Test
        public void testTokenLyricsWithChars(){
            verifyLexer("Now~ I kno-w my! la*la?", new String[] {"Now", "~", " ", "I", " ", "kno", "-", "w", " ", "my!", " ", "l", "a", "*", "l", "a", "?" });
            
        }
        
        @Test
        public void testTokenLyricswithBaseNotes(){
            //the base notes should be recognized as base notes while rest should be recognized as lyrics. 
            verifyLexer("abcdefghijklmnopz", new String[] {"a", "b", "c", "d", "e", "f", "g", "hijklmnop", "z" });
            
        }
        
        @Test
        public void testTokenLyricswithBaseNotesAndPunctuation(){
            //the base notes should be recognized as base notes while rest should be recognized as lyrics. 
            verifyLexer("a?bcde?fghijklmno?pz", new String[] {"a", "?", "b", "c", "d", "e", "?", "f", "g", "hijklmno?p", "z" });
            
        }
        
        /**
         * Returns a boolean to verify if the token stream from lexeris the same as the expected tokens. 
         * 
         * @param String input
         *            the string that needs to be parsed
         * @param String[] expected Tokens
         *            a list of the expected Tokens 
         * @ return boolean representing lexer token stream == expected tokens.
         * 
         */
    public void verifyLexer(String input, String[] expectedTokens) {
        CharStream stream = new ANTLRInputStream(input);
        ABCMusicLexer lexer = new ABCMusicLexer(stream);
        lexer.reportErrorsAsExceptions();
        List<? extends Token> actualTokens = lexer.getAllTokens();
    
        assertEquals(expectedTokens.length, actualTokens.size());
    
        for (int i = 0; i < actualTokens.size(); i++) {
            String actualToken = actualTokens.get(i).getText();
            String expectedToken = expectedTokens[i];
            assertEquals(actualToken, expectedToken);
        }
    }
}
