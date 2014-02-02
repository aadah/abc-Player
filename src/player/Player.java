package player;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import grammar.ABCMusicLexer;
import grammar.ABCMusicParser;

public class Player implements PlayerInterface {
    private OurListener listener;

    
    /**
     * Runs the listener on the given input string.
     * 
     * @param input
     *            The input string of an abc file.
     */
    private void runListener(String input) {
        // Create a stream of tokens using the lexer.
        CharStream stream = new ANTLRInputStream(input);
        ABCMusicLexer lexer = new ABCMusicLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);

        // Feed the tokens into the parser.
        ABCMusicParser parser = new ABCMusicParser(tokens);
        parser.reportErrorsAsExceptions();

        // Generate the parse tree using the starter rule.
        ParseTree tree;
        //"abctune" is the starter rule.  
        tree = parser.abctune();

        // Walk the tree with the listener.
        ParseTreeWalker walker = new ParseTreeWalker();
        listener = new OurListener();
        walker.walk(listener, tree);
    }
    /**
     * Parse a string represeting abc file into an ABCMusic tree.
     * See PlayerInterface for specifications. 
     * 
     * @param input the text within an abc file
     * 
     * @return the Song object representing the abc file text
     */
    public Song parse(String input) {
            runListener(input);
            return listener.getABCMusic();
    }
}






