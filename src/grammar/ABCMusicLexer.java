// Generated from ABCMusic.g4 by ANTLR 4.0

package grammar;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ABCMusicLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, INDEX=2, TITLE=3, COMPOSER=4, LENGTH=5, METER=6, TEMPO=7, VOICE=8, 
		KEY=9, NUMBER=10, BASENOTE=11, REST=12, OCTAVE=13, ACCIDENTAL=14, BARLINE=15, 
		NTHREPEAT=16, OPENBRAC=17, CLOSEBRAC=18, OPENPAREN=19, CLOSEPAREN=20, 
		DIVIDE=21, SPACE=22, LINEFEED=23, COMMENT=24, LYRICSYMBOL=25, LYRICELEMENT=26, 
		IGNORE=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'w:'", "INDEX", "TITLE", "COMPOSER", "LENGTH", "METER", "TEMPO", "VOICE", 
		"KEY", "NUMBER", "BASENOTE", "'z'", "OCTAVE", "ACCIDENTAL", "BARLINE", 
		"NTHREPEAT", "'['", "']'", "'('", "')'", "'/'", "SPACE", "LINEFEED", "COMMENT", 
		"LYRICSYMBOL", "LYRICELEMENT", "'\t'"
	};
	public static final String[] ruleNames = {
		"T__0", "INDEX", "TITLE", "COMPOSER", "LENGTH", "METER", "TEMPO", "VOICE", 
		"KEY", "NUMBER", "BASENOTE", "REST", "OCTAVE", "ACCIDENTAL", "BARLINE", 
		"NTHREPEAT", "OPENBRAC", "CLOSEBRAC", "OPENPAREN", "CLOSEPAREN", "DIVIDE", 
		"SPACE", "LINEFEED", "COMMENT", "LYRICSYMBOL", "LYRICELEMENT", "IGNORE"
	};


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


	public ABCMusicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ABCMusic.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 26: IGNORE_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void IGNORE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\35\u010e\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\5\3A\n\3\3\3\3\3\5\3E\n\3\3\4\3\4\3\4\3\4\5\4K\n\4\3\4"+
		"\3\4\3\4\6\4P\n\4\r\4\16\4Q\3\4\5\4U\n\4\3\5\3\5\3\5\3\5\5\5[\n\5\3\5"+
		"\3\5\3\5\6\5`\n\5\r\5\16\5a\3\5\5\5e\n\5\3\6\3\6\3\6\3\6\5\6k\n\6\3\6"+
		"\3\6\3\6\3\6\5\6q\n\6\3\7\3\7\3\7\3\7\5\7w\n\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7\u0080\n\7\3\7\5\7\u0083\n\7\3\b\3\b\3\b\3\b\5\b\u0089\n\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u0091\n\b\3\t\3\t\3\t\3\t\5\t\u0097\n\t\3\t\3"+
		"\t\3\t\6\t\u009c\n\t\r\t\16\t\u009d\3\t\5\t\u00a1\n\t\3\n\3\n\3\n\3\n"+
		"\5\n\u00a7\n\n\3\n\3\n\5\n\u00ab\n\n\3\n\5\n\u00ae\n\n\3\n\5\n\u00b1\n"+
		"\n\3\13\6\13\u00b4\n\13\r\13\16\13\u00b5\3\f\3\f\3\r\3\r\3\16\6\16\u00bd"+
		"\n\16\r\16\16\16\u00be\3\17\6\17\u00c2\n\17\r\17\16\17\u00c3\3\17\6\17"+
		"\u00c7\n\17\r\17\16\17\u00c8\3\17\5\17\u00cc\n\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00d9\n\20\3\21\3\21\3\21\3\21"+
		"\5\21\u00df\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\6\27\u00ec\n\27\r\27\16\27\u00ed\3\30\5\30\u00f1\n\30\3\30\3\30\3\31"+
		"\3\31\7\31\u00f7\n\31\f\31\16\31\u00fa\13\31\3\31\5\31\u00fd\n\31\3\31"+
		"\3\31\3\32\3\32\3\32\5\32\u0104\n\32\3\33\6\33\u0107\n\33\r\33\16\33\u0108"+
		"\3\34\3\34\3\34\3\34\3\u00f8\35\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17"+
		"\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22"+
		"\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1"+
		"\67\35\2\3\2\f\b\"\")+..\60\60C_c|\b\"\")+..\60\60C_c|\b\"\")+..\60\60"+
		"C_c|\4CIci\4%%dd\3\62;\4CIci\4))..\5,,//\u0080\u0080\7##\60\60AAJ\\j{"+
		"\u013c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2"+
		"\2\5<\3\2\2\2\7F\3\2\2\2\tV\3\2\2\2\13f\3\2\2\2\rr\3\2\2\2\17\u0084\3"+
		"\2\2\2\21\u0092\3\2\2\2\23\u00a2\3\2\2\2\25\u00b3\3\2\2\2\27\u00b7\3\2"+
		"\2\2\31\u00b9\3\2\2\2\33\u00bc\3\2\2\2\35\u00cb\3\2\2\2\37\u00d8\3\2\2"+
		"\2!\u00de\3\2\2\2#\u00e0\3\2\2\2%\u00e2\3\2\2\2\'\u00e4\3\2\2\2)\u00e6"+
		"\3\2\2\2+\u00e8\3\2\2\2-\u00eb\3\2\2\2/\u00f0\3\2\2\2\61\u00f4\3\2\2\2"+
		"\63\u0103\3\2\2\2\65\u0106\3\2\2\2\67\u010a\3\2\2\29:\7y\2\2:;\7<\2\2"+
		";\4\3\2\2\2<=\7Z\2\2=>\7<\2\2>@\3\2\2\2?A\5-\27\2@?\3\2\2\2@A\3\2\2\2"+
		"AB\3\2\2\2BD\5\25\13\2CE\5-\27\2DC\3\2\2\2DE\3\2\2\2E\6\3\2\2\2FG\7V\2"+
		"\2GH\7<\2\2HJ\3\2\2\2IK\5-\27\2JI\3\2\2\2JK\3\2\2\2KO\3\2\2\2LP\t\2\2"+
		"\2MP\5\25\13\2NP\5\33\16\2OL\3\2\2\2OM\3\2\2\2ON\3\2\2\2PQ\3\2\2\2QO\3"+
		"\2\2\2QR\3\2\2\2RT\3\2\2\2SU\5-\27\2TS\3\2\2\2TU\3\2\2\2U\b\3\2\2\2VW"+
		"\7E\2\2WX\7<\2\2XZ\3\2\2\2Y[\5-\27\2ZY\3\2\2\2Z[\3\2\2\2[_\3\2\2\2\\`"+
		"\t\3\2\2]`\5\25\13\2^`\5\33\16\2_\\\3\2\2\2_]\3\2\2\2_^\3\2\2\2`a\3\2"+
		"\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ce\5-\27\2dc\3\2\2\2de\3\2\2\2e\n\3"+
		"\2\2\2fg\7N\2\2gh\7<\2\2hj\3\2\2\2ik\5-\27\2ji\3\2\2\2jk\3\2\2\2kl\3\2"+
		"\2\2lm\5\25\13\2mn\7\61\2\2np\5\25\13\2oq\5-\27\2po\3\2\2\2pq\3\2\2\2"+
		"q\f\3\2\2\2rs\7O\2\2st\7<\2\2tv\3\2\2\2uw\5-\27\2vu\3\2\2\2vw\3\2\2\2"+
		"w\177\3\2\2\2x\u0080\7E\2\2yz\7E\2\2z\u0080\7~\2\2{|\5\25\13\2|}\7\61"+
		"\2\2}~\5\25\13\2~\u0080\3\2\2\2\177x\3\2\2\2\177y\3\2\2\2\177{\3\2\2\2"+
		"\u0080\u0082\3\2\2\2\u0081\u0083\5-\27\2\u0082\u0081\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\16\3\2\2\2\u0084\u0085\7S\2\2\u0085\u0086\7<\2\2\u0086"+
		"\u0088\3\2\2\2\u0087\u0089\5-\27\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\u008a\3\2\2\2\u008a\u008b\5\25\13\2\u008b\u008c\7\61\2\2\u008c"+
		"\u008d\5\25\13\2\u008d\u008e\7?\2\2\u008e\u0090\5\25\13\2\u008f\u0091"+
		"\5-\27\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\20\3\2\2\2\u0092"+
		"\u0093\7X\2\2\u0093\u0094\7<\2\2\u0094\u0096\3\2\2\2\u0095\u0097\5-\27"+
		"\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009b\3\2\2\2\u0098\u009c"+
		"\t\4\2\2\u0099\u009c\5\25\13\2\u009a\u009c\5\33\16\2\u009b\u0098\3\2\2"+
		"\2\u009b\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u00a1\5-\27\2\u00a0"+
		"\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\22\3\2\2\2\u00a2\u00a3\7M\2\2"+
		"\u00a3\u00a4\7<\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a7\5-\27\2\u00a6\u00a5"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\t\5\2\2\u00a9"+
		"\u00ab\t\6\2\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2"+
		"\2\2\u00ac\u00ae\7o\2\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00b0\3\2\2\2\u00af\u00b1\5-\27\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\24\3\2\2\2\u00b2\u00b4\t\7\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5"+
		"\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\26\3\2\2\2\u00b7"+
		"\u00b8\t\b\2\2\u00b8\30\3\2\2\2\u00b9\u00ba\7|\2\2\u00ba\32\3\2\2\2\u00bb"+
		"\u00bd\t\t\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2"+
		"\2\2\u00be\u00bf\3\2\2\2\u00bf\34\3\2\2\2\u00c0\u00c2\7`\2\2\u00c1\u00c0"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00cc\3\2\2\2\u00c5\u00c7\7a\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca"+
		"\u00cc\7?\2\2\u00cb\u00c1\3\2\2\2\u00cb\u00c6\3\2\2\2\u00cb\u00ca\3\2"+
		"\2\2\u00cc\36\3\2\2\2\u00cd\u00d9\7~\2\2\u00ce\u00cf\7~\2\2\u00cf\u00d9"+
		"\7~\2\2\u00d0\u00d1\7]\2\2\u00d1\u00d9\7~\2\2\u00d2\u00d3\7~\2\2\u00d3"+
		"\u00d9\7_\2\2\u00d4\u00d5\7<\2\2\u00d5\u00d9\7~\2\2\u00d6\u00d7\7~\2\2"+
		"\u00d7\u00d9\7<\2\2\u00d8\u00cd\3\2\2\2\u00d8\u00ce\3\2\2\2\u00d8\u00d0"+
		"\3\2\2\2\u00d8\u00d2\3\2\2\2\u00d8\u00d4\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9"+
		" \3\2\2\2\u00da\u00db\7]\2\2\u00db\u00df\7\63\2\2\u00dc\u00dd\7]\2\2\u00dd"+
		"\u00df\7\64\2\2\u00de\u00da\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\"\3\2\2"+
		"\2\u00e0\u00e1\7]\2\2\u00e1$\3\2\2\2\u00e2\u00e3\7_\2\2\u00e3&\3\2\2\2"+
		"\u00e4\u00e5\7*\2\2\u00e5(\3\2\2\2\u00e6\u00e7\7+\2\2\u00e7*\3\2\2\2\u00e8"+
		"\u00e9\7\61\2\2\u00e9,\3\2\2\2\u00ea\u00ec\7\"\2\2\u00eb\u00ea\3\2\2\2"+
		"\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee.\3"+
		"\2\2\2\u00ef\u00f1\7\17\2\2\u00f0\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f3\7\f\2\2\u00f3\60\3\2\2\2\u00f4\u00f8\7\'\2"+
		"\2\u00f5\u00f7\13\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2"+
		"\2\2\u00fb\u00fd\7\17\2\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u00ff\7\f\2\2\u00ff\62\3\2\2\2\u0100\u0104\t\n\2"+
		"\2\u0101\u0102\7^\2\2\u0102\u0104\7/\2\2\u0103\u0100\3\2\2\2\u0103\u0101"+
		"\3\2\2\2\u0104\64\3\2\2\2\u0105\u0107\t\13\2\2\u0106\u0105\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\66\3\2\2"+
		"\2\u010a\u010b\7\13\2\2\u010b\u010c\3\2\2\2\u010c\u010d\b\34\2\2\u010d"+
		"8\3\2\2\2*\2@DJOQTZ_adjpv\177\u0082\u0088\u0090\u0096\u009b\u009d\u00a0"+
		"\u00a6\u00aa\u00ad\u00b0\u00b5\u00be\u00c3\u00c8\u00cb\u00d8\u00de\u00ed"+
		"\u00f0\u00f8\u00fc\u0103\u0106\u0108";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}