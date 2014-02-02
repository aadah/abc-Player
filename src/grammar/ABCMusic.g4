/**
 * This file is the grammar file used by ANTLR.
 *
 * In order to compile this file, navigate to this directory
 * (<src/grammar>) and run the following command:
 *
 * java -jar ../../antlr.jar ABCMusic.g4
 */

grammar ABCMusic;

/*
 * This puts "package grammar;" at the top of the output Java files.
 * Do not change these lines unless you know what you're doing.
 */
@header {
package grammar;
}

/*
 * This adds code to the generated lexer and parser. This makes the lexer and
 * parser throw errors if they encounter invalid input. Do not change these
 * lines unless you know what you're doing.
 */
@members {
    // This method makes the lexer or parser stop running if it encounters
    // invalid input and throw a RuntimeException.
    public void reportErrorsAsExceptions() {
        removeErrorListeners();
        addErrorListener(new ExceptionThrowingErrorListener());
    }

    private static class ExceptionThrowingErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                Object offendingSymbol, int line, int charPositionInLine,
                String msg, RecognitionException e) {
            throw new RuntimeException(msg);
        }
    }
}

/*
 * These are the lexical rules. They define the tokens used by the lexer.
 */

// header tokens
INDEX : 'X:' SPACE? NUMBER SPACE? ;
TITLE : 'T:' SPACE? ([a-zA-Z'.''!''?'',''\'''('')'\[\] ] | NUMBER | OCTAVE)+ SPACE? ;
COMPOSER : 'C:' SPACE? ([a-zA-Z'.''!''?'',''\'''('')'\[\] ] | NUMBER | OCTAVE)+ SPACE? ;
LENGTH : 'L:' SPACE? NUMBER '/' NUMBER SPACE? ;
METER : 'M:' SPACE? ('C' | 'C|' | NUMBER '/' NUMBER) SPACE? ;
TEMPO : 'Q:' SPACE? NUMBER '/' NUMBER '=' NUMBER SPACE? ;
VOICE : 'V:' SPACE? ([a-zA-Z'.''!''?'',''\'''('')'\[\] ] | NUMBER | OCTAVE)+ SPACE? ;
KEY : 'K:' SPACE? [A-Ga-g] ('#' | 'b')? 'm'? SPACE? ;
// body  tokens
NUMBER : [0-9]+ ;
BASENOTE : [A-Ga-g] ; 
REST : 'z' ;
OCTAVE : ('\'' | ',')+ ;
ACCIDENTAL : '^'+ |  '_'+ | '=' ;
BARLINE : '|'  |  '||'  | '[|'  | '|]'  | ':|' | '|:' ;
NTHREPEAT : '[1' | '[2' ;
OPENBRAC : '[' ;
CLOSEBRAC : ']' ;
OPENPAREN : '(' ;
CLOSEPAREN : ')' ;
DIVIDE : '/' ;
SPACE : ' '+ ;
LINEFEED : '\r'? '\n' ;
COMMENT : '%' .*? '\r'? '\n' ; // text
LYRICSYMBOL : '-' | '*' | '~' | '\-' ;
LYRICELEMENT : ([h-yH-Z] | '!' | '?' | '.')+ ;
IGNORE : '\t' -> skip ;

/*
 * These are the parser rules. They define the structures used by the parser.
 *
 * You should make sure you have one rule that describes the entire input.
 * This is the "start rule". The start rule should end with the special
 * predefined token EOF so that it describes the entire input. Below, we've made
 * "line" the start rule.
 *
 * For more information, see
 * http://www.antlr.org/wiki/display/ANTLR4/Parser+Rules#ParserRules-StartRulesandEOF
 */

// putting it all together
abctune : abcheader abcmusic EOF ;

// create header and body
abcheader : fieldnumber COMMENT* fieldtitle otherfields* fieldkey ;
abcmusic : abcline+ ;
abcline : element+ LINEFEED (lyric LINEFEED)? | midtunefield | COMMENT | LINEFEED ;
element: noteelement | tupletelement | BARLINE | NTHREPEAT | SPACE ;

// header fields
fieldnumber : INDEX (COMMENT | LINEFEED) ;
fieldtitle : TITLE (COMMENT | LINEFEED) ;
fieldvoice : VOICE (COMMENT | LINEFEED) ;
fieldcomposer : COMPOSER (COMMENT | LINEFEED) ;
fielddefaultlength : LENGTH (COMMENT | LINEFEED) ;
fieldmeter : METER (COMMENT | LINEFEED) ;
fieldtempo : TEMPO (COMMENT | LINEFEED) ;
fieldkey : KEY (COMMENT | LINEFEED) ;
otherfields : fieldcomposer | fielddefaultlength | fieldmeter |fieldtempo | fieldvoice | COMMENT | LINEFEED ;

// change in voices
midtunefield : fieldvoice ;

// note or chord
noteelement : note | chord ;

// note is a pitch or rest
note : noteorrest notelength? ;
noteorrest : pitch | REST ;
pitch : ACCIDENTAL? BASENOTE OCTAVE? ;

// note/rest lengths
notelength : (NUMBER)? (DIVIDE (NUMBER)?)? ;

// chords
chord : OPENBRAC note+ CLOSEBRAC ;

// tuplets
tupletspec : OPENPAREN NUMBER ;
tupletelement : tupletspec noteelement+ ;

// lyrics
lyricword : (LYRICELEMENT | BASENOTE | REST | OCTAVE)+ ;
lyric : 'w:' (lyricword | LYRICSYMBOL | NUMBER | ACCIDENTAL | BARLINE | OPENPAREN | CLOSEPAREN | SPACE)* ;
