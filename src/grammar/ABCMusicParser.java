// Generated from ABCMusic.g4 by ANTLR 4.0

package grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ABCMusicParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, INDEX=2, TITLE=3, COMPOSER=4, LENGTH=5, METER=6, TEMPO=7, VOICE=8, 
		KEY=9, NUMBER=10, BASENOTE=11, REST=12, OCTAVE=13, ACCIDENTAL=14, BARLINE=15, 
		NTHREPEAT=16, OPENBRAC=17, CLOSEBRAC=18, OPENPAREN=19, CLOSEPAREN=20, 
		DIVIDE=21, SPACE=22, LINEFEED=23, COMMENT=24, LYRICSYMBOL=25, LYRICELEMENT=26, 
		IGNORE=27;
	public static final String[] tokenNames = {
		"<INVALID>", "'w:'", "INDEX", "TITLE", "COMPOSER", "LENGTH", "METER", 
		"TEMPO", "VOICE", "KEY", "NUMBER", "BASENOTE", "'z'", "OCTAVE", "ACCIDENTAL", 
		"BARLINE", "NTHREPEAT", "'['", "']'", "'('", "')'", "'/'", "SPACE", "LINEFEED", 
		"COMMENT", "LYRICSYMBOL", "LYRICELEMENT", "'\t'"
	};
	public static final int
		RULE_abctune = 0, RULE_abcheader = 1, RULE_abcmusic = 2, RULE_abcline = 3, 
		RULE_element = 4, RULE_fieldnumber = 5, RULE_fieldtitle = 6, RULE_fieldvoice = 7, 
		RULE_fieldcomposer = 8, RULE_fielddefaultlength = 9, RULE_fieldmeter = 10, 
		RULE_fieldtempo = 11, RULE_fieldkey = 12, RULE_otherfields = 13, RULE_midtunefield = 14, 
		RULE_noteelement = 15, RULE_note = 16, RULE_noteorrest = 17, RULE_pitch = 18, 
		RULE_notelength = 19, RULE_chord = 20, RULE_tupletspec = 21, RULE_tupletelement = 22, 
		RULE_lyricword = 23, RULE_lyric = 24;
	public static final String[] ruleNames = {
		"abctune", "abcheader", "abcmusic", "abcline", "element", "fieldnumber", 
		"fieldtitle", "fieldvoice", "fieldcomposer", "fielddefaultlength", "fieldmeter", 
		"fieldtempo", "fieldkey", "otherfields", "midtunefield", "noteelement", 
		"note", "noteorrest", "pitch", "notelength", "chord", "tupletspec", "tupletelement", 
		"lyricword", "lyric"
	};

	@Override
	public String getGrammarFileName() { return "ABCMusic.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public ABCMusicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AbctuneContext extends ParserRuleContext {
		public AbcmusicContext abcmusic() {
			return getRuleContext(AbcmusicContext.class,0);
		}
		public AbcheaderContext abcheader() {
			return getRuleContext(AbcheaderContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ABCMusicParser.EOF, 0); }
		public AbctuneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abctune; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterAbctune(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitAbctune(this);
		}
	}

	public final AbctuneContext abctune() throws RecognitionException {
		AbctuneContext _localctx = new AbctuneContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_abctune);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); abcheader();
			setState(51); abcmusic();
			setState(52); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbcheaderContext extends ParserRuleContext {
		public OtherfieldsContext otherfields(int i) {
			return getRuleContext(OtherfieldsContext.class,i);
		}
		public List<OtherfieldsContext> otherfields() {
			return getRuleContexts(OtherfieldsContext.class);
		}
		public FieldkeyContext fieldkey() {
			return getRuleContext(FieldkeyContext.class,0);
		}
		public FieldtitleContext fieldtitle() {
			return getRuleContext(FieldtitleContext.class,0);
		}
		public List<TerminalNode> COMMENT() { return getTokens(ABCMusicParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(ABCMusicParser.COMMENT, i);
		}
		public FieldnumberContext fieldnumber() {
			return getRuleContext(FieldnumberContext.class,0);
		}
		public AbcheaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abcheader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterAbcheader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitAbcheader(this);
		}
	}

	public final AbcheaderContext abcheader() throws RecognitionException {
		AbcheaderContext _localctx = new AbcheaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_abcheader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); fieldnumber();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(55); match(COMMENT);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61); fieldtitle();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMPOSER) | (1L << LENGTH) | (1L << METER) | (1L << TEMPO) | (1L << VOICE) | (1L << LINEFEED) | (1L << COMMENT))) != 0)) {
				{
				{
				setState(62); otherfields();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68); fieldkey();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbcmusicContext extends ParserRuleContext {
		public AbclineContext abcline(int i) {
			return getRuleContext(AbclineContext.class,i);
		}
		public List<AbclineContext> abcline() {
			return getRuleContexts(AbclineContext.class);
		}
		public AbcmusicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abcmusic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterAbcmusic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitAbcmusic(this);
		}
	}

	public final AbcmusicContext abcmusic() throws RecognitionException {
		AbcmusicContext _localctx = new AbcmusicContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_abcmusic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70); abcline();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOICE) | (1L << BASENOTE) | (1L << REST) | (1L << ACCIDENTAL) | (1L << BARLINE) | (1L << NTHREPEAT) | (1L << OPENBRAC) | (1L << OPENPAREN) | (1L << SPACE) | (1L << LINEFEED) | (1L << COMMENT))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbclineContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public LyricContext lyric() {
			return getRuleContext(LyricContext.class,0);
		}
		public TerminalNode LINEFEED(int i) {
			return getToken(ABCMusicParser.LINEFEED, i);
		}
		public TerminalNode COMMENT() { return getToken(ABCMusicParser.COMMENT, 0); }
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public MidtunefieldContext midtunefield() {
			return getRuleContext(MidtunefieldContext.class,0);
		}
		public List<TerminalNode> LINEFEED() { return getTokens(ABCMusicParser.LINEFEED); }
		public AbclineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abcline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterAbcline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitAbcline(this);
		}
	}

	public final AbclineContext abcline() throws RecognitionException {
		AbclineContext _localctx = new AbclineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_abcline);
		int _la;
		try {
			setState(89);
			switch (_input.LA(1)) {
			case BASENOTE:
			case REST:
			case ACCIDENTAL:
			case BARLINE:
			case NTHREPEAT:
			case OPENBRAC:
			case OPENPAREN:
			case SPACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(75); element();
					}
					}
					setState(78); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BASENOTE) | (1L << REST) | (1L << ACCIDENTAL) | (1L << BARLINE) | (1L << NTHREPEAT) | (1L << OPENBRAC) | (1L << OPENPAREN) | (1L << SPACE))) != 0) );
				setState(80); match(LINEFEED);
				setState(84);
				_la = _input.LA(1);
				if (_la==1) {
					{
					setState(81); lyric();
					setState(82); match(LINEFEED);
					}
				}

				}
				break;
			case VOICE:
				enterOuterAlt(_localctx, 2);
				{
				setState(86); midtunefield();
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(87); match(COMMENT);
				}
				break;
			case LINEFEED:
				enterOuterAlt(_localctx, 4);
				{
				setState(88); match(LINEFEED);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementContext extends ParserRuleContext {
		public TerminalNode BARLINE() { return getToken(ABCMusicParser.BARLINE, 0); }
		public TerminalNode NTHREPEAT() { return getToken(ABCMusicParser.NTHREPEAT, 0); }
		public TerminalNode SPACE() { return getToken(ABCMusicParser.SPACE, 0); }
		public TupletelementContext tupletelement() {
			return getRuleContext(TupletelementContext.class,0);
		}
		public NoteelementContext noteelement() {
			return getRuleContext(NoteelementContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitElement(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_element);
		try {
			setState(96);
			switch (_input.LA(1)) {
			case BASENOTE:
			case REST:
			case ACCIDENTAL:
			case OPENBRAC:
				enterOuterAlt(_localctx, 1);
				{
				setState(91); noteelement();
				}
				break;
			case OPENPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(92); tupletelement();
				}
				break;
			case BARLINE:
				enterOuterAlt(_localctx, 3);
				{
				setState(93); match(BARLINE);
				}
				break;
			case NTHREPEAT:
				enterOuterAlt(_localctx, 4);
				{
				setState(94); match(NTHREPEAT);
				}
				break;
			case SPACE:
				enterOuterAlt(_localctx, 5);
				{
				setState(95); match(SPACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldnumberContext extends ParserRuleContext {
		public TerminalNode INDEX() { return getToken(ABCMusicParser.INDEX, 0); }
		public TerminalNode COMMENT() { return getToken(ABCMusicParser.COMMENT, 0); }
		public TerminalNode LINEFEED() { return getToken(ABCMusicParser.LINEFEED, 0); }
		public FieldnumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldnumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterFieldnumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitFieldnumber(this);
		}
	}

	public final FieldnumberContext fieldnumber() throws RecognitionException {
		FieldnumberContext _localctx = new FieldnumberContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fieldnumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); match(INDEX);
			setState(99);
			_la = _input.LA(1);
			if ( !(_la==LINEFEED || _la==COMMENT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldtitleContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(ABCMusicParser.COMMENT, 0); }
		public TerminalNode LINEFEED() { return getToken(ABCMusicParser.LINEFEED, 0); }
		public TerminalNode TITLE() { return getToken(ABCMusicParser.TITLE, 0); }
		public FieldtitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldtitle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterFieldtitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitFieldtitle(this);
		}
	}

	public final FieldtitleContext fieldtitle() throws RecognitionException {
		FieldtitleContext _localctx = new FieldtitleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldtitle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(TITLE);
			setState(102);
			_la = _input.LA(1);
			if ( !(_la==LINEFEED || _la==COMMENT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldvoiceContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(ABCMusicParser.COMMENT, 0); }
		public TerminalNode VOICE() { return getToken(ABCMusicParser.VOICE, 0); }
		public TerminalNode LINEFEED() { return getToken(ABCMusicParser.LINEFEED, 0); }
		public FieldvoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldvoice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterFieldvoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitFieldvoice(this);
		}
	}

	public final FieldvoiceContext fieldvoice() throws RecognitionException {
		FieldvoiceContext _localctx = new FieldvoiceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fieldvoice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); match(VOICE);
			setState(105);
			_la = _input.LA(1);
			if ( !(_la==LINEFEED || _la==COMMENT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldcomposerContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(ABCMusicParser.COMMENT, 0); }
		public TerminalNode LINEFEED() { return getToken(ABCMusicParser.LINEFEED, 0); }
		public TerminalNode COMPOSER() { return getToken(ABCMusicParser.COMPOSER, 0); }
		public FieldcomposerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldcomposer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterFieldcomposer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitFieldcomposer(this);
		}
	}

	public final FieldcomposerContext fieldcomposer() throws RecognitionException {
		FieldcomposerContext _localctx = new FieldcomposerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fieldcomposer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); match(COMPOSER);
			setState(108);
			_la = _input.LA(1);
			if ( !(_la==LINEFEED || _la==COMMENT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FielddefaultlengthContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(ABCMusicParser.COMMENT, 0); }
		public TerminalNode LENGTH() { return getToken(ABCMusicParser.LENGTH, 0); }
		public TerminalNode LINEFEED() { return getToken(ABCMusicParser.LINEFEED, 0); }
		public FielddefaultlengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fielddefaultlength; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterFielddefaultlength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitFielddefaultlength(this);
		}
	}

	public final FielddefaultlengthContext fielddefaultlength() throws RecognitionException {
		FielddefaultlengthContext _localctx = new FielddefaultlengthContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fielddefaultlength);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110); match(LENGTH);
			setState(111);
			_la = _input.LA(1);
			if ( !(_la==LINEFEED || _la==COMMENT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldmeterContext extends ParserRuleContext {
		public TerminalNode METER() { return getToken(ABCMusicParser.METER, 0); }
		public TerminalNode COMMENT() { return getToken(ABCMusicParser.COMMENT, 0); }
		public TerminalNode LINEFEED() { return getToken(ABCMusicParser.LINEFEED, 0); }
		public FieldmeterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldmeter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterFieldmeter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitFieldmeter(this);
		}
	}

	public final FieldmeterContext fieldmeter() throws RecognitionException {
		FieldmeterContext _localctx = new FieldmeterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fieldmeter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); match(METER);
			setState(114);
			_la = _input.LA(1);
			if ( !(_la==LINEFEED || _la==COMMENT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldtempoContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(ABCMusicParser.COMMENT, 0); }
		public TerminalNode TEMPO() { return getToken(ABCMusicParser.TEMPO, 0); }
		public TerminalNode LINEFEED() { return getToken(ABCMusicParser.LINEFEED, 0); }
		public FieldtempoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldtempo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterFieldtempo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitFieldtempo(this);
		}
	}

	public final FieldtempoContext fieldtempo() throws RecognitionException {
		FieldtempoContext _localctx = new FieldtempoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fieldtempo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(TEMPO);
			setState(117);
			_la = _input.LA(1);
			if ( !(_la==LINEFEED || _la==COMMENT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldkeyContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(ABCMusicParser.COMMENT, 0); }
		public TerminalNode KEY() { return getToken(ABCMusicParser.KEY, 0); }
		public TerminalNode LINEFEED() { return getToken(ABCMusicParser.LINEFEED, 0); }
		public FieldkeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldkey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterFieldkey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitFieldkey(this);
		}
	}

	public final FieldkeyContext fieldkey() throws RecognitionException {
		FieldkeyContext _localctx = new FieldkeyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fieldkey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); match(KEY);
			setState(120);
			_la = _input.LA(1);
			if ( !(_la==LINEFEED || _la==COMMENT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OtherfieldsContext extends ParserRuleContext {
		public FieldvoiceContext fieldvoice() {
			return getRuleContext(FieldvoiceContext.class,0);
		}
		public FieldmeterContext fieldmeter() {
			return getRuleContext(FieldmeterContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(ABCMusicParser.COMMENT, 0); }
		public FielddefaultlengthContext fielddefaultlength() {
			return getRuleContext(FielddefaultlengthContext.class,0);
		}
		public FieldtempoContext fieldtempo() {
			return getRuleContext(FieldtempoContext.class,0);
		}
		public TerminalNode LINEFEED() { return getToken(ABCMusicParser.LINEFEED, 0); }
		public FieldcomposerContext fieldcomposer() {
			return getRuleContext(FieldcomposerContext.class,0);
		}
		public OtherfieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherfields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterOtherfields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitOtherfields(this);
		}
	}

	public final OtherfieldsContext otherfields() throws RecognitionException {
		OtherfieldsContext _localctx = new OtherfieldsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_otherfields);
		try {
			setState(129);
			switch (_input.LA(1)) {
			case COMPOSER:
				enterOuterAlt(_localctx, 1);
				{
				setState(122); fieldcomposer();
				}
				break;
			case LENGTH:
				enterOuterAlt(_localctx, 2);
				{
				setState(123); fielddefaultlength();
				}
				break;
			case METER:
				enterOuterAlt(_localctx, 3);
				{
				setState(124); fieldmeter();
				}
				break;
			case TEMPO:
				enterOuterAlt(_localctx, 4);
				{
				setState(125); fieldtempo();
				}
				break;
			case VOICE:
				enterOuterAlt(_localctx, 5);
				{
				setState(126); fieldvoice();
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 6);
				{
				setState(127); match(COMMENT);
				}
				break;
			case LINEFEED:
				enterOuterAlt(_localctx, 7);
				{
				setState(128); match(LINEFEED);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MidtunefieldContext extends ParserRuleContext {
		public FieldvoiceContext fieldvoice() {
			return getRuleContext(FieldvoiceContext.class,0);
		}
		public MidtunefieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_midtunefield; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterMidtunefield(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitMidtunefield(this);
		}
	}

	public final MidtunefieldContext midtunefield() throws RecognitionException {
		MidtunefieldContext _localctx = new MidtunefieldContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_midtunefield);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); fieldvoice();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoteelementContext extends ParserRuleContext {
		public ChordContext chord() {
			return getRuleContext(ChordContext.class,0);
		}
		public NoteContext note() {
			return getRuleContext(NoteContext.class,0);
		}
		public NoteelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteelement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterNoteelement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitNoteelement(this);
		}
	}

	public final NoteelementContext noteelement() throws RecognitionException {
		NoteelementContext _localctx = new NoteelementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_noteelement);
		try {
			setState(135);
			switch (_input.LA(1)) {
			case BASENOTE:
			case REST:
			case ACCIDENTAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(133); note();
				}
				break;
			case OPENBRAC:
				enterOuterAlt(_localctx, 2);
				{
				setState(134); chord();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoteContext extends ParserRuleContext {
		public NoteorrestContext noteorrest() {
			return getRuleContext(NoteorrestContext.class,0);
		}
		public NotelengthContext notelength() {
			return getRuleContext(NotelengthContext.class,0);
		}
		public NoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitNote(this);
		}
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_note);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); noteorrest();
			setState(139);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(138); notelength();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoteorrestContext extends ParserRuleContext {
		public TerminalNode REST() { return getToken(ABCMusicParser.REST, 0); }
		public PitchContext pitch() {
			return getRuleContext(PitchContext.class,0);
		}
		public NoteorrestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteorrest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterNoteorrest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitNoteorrest(this);
		}
	}

	public final NoteorrestContext noteorrest() throws RecognitionException {
		NoteorrestContext _localctx = new NoteorrestContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_noteorrest);
		try {
			setState(143);
			switch (_input.LA(1)) {
			case BASENOTE:
			case ACCIDENTAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(141); pitch();
				}
				break;
			case REST:
				enterOuterAlt(_localctx, 2);
				{
				setState(142); match(REST);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PitchContext extends ParserRuleContext {
		public TerminalNode OCTAVE() { return getToken(ABCMusicParser.OCTAVE, 0); }
		public TerminalNode BASENOTE() { return getToken(ABCMusicParser.BASENOTE, 0); }
		public TerminalNode ACCIDENTAL() { return getToken(ABCMusicParser.ACCIDENTAL, 0); }
		public PitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterPitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitPitch(this);
		}
	}

	public final PitchContext pitch() throws RecognitionException {
		PitchContext _localctx = new PitchContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_pitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_la = _input.LA(1);
			if (_la==ACCIDENTAL) {
				{
				setState(145); match(ACCIDENTAL);
				}
			}

			setState(148); match(BASENOTE);
			setState(150);
			_la = _input.LA(1);
			if (_la==OCTAVE) {
				{
				setState(149); match(OCTAVE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotelengthContext extends ParserRuleContext {
		public TerminalNode NUMBER(int i) {
			return getToken(ABCMusicParser.NUMBER, i);
		}
		public TerminalNode DIVIDE() { return getToken(ABCMusicParser.DIVIDE, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(ABCMusicParser.NUMBER); }
		public NotelengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notelength; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterNotelength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitNotelength(this);
		}
	}

	public final NotelengthContext notelength() throws RecognitionException {
		NotelengthContext _localctx = new NotelengthContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_notelength);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(152); match(NUMBER);
				}
			}

			setState(159);
			_la = _input.LA(1);
			if (_la==DIVIDE) {
				{
				setState(155); match(DIVIDE);
				setState(157);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(156); match(NUMBER);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChordContext extends ParserRuleContext {
		public NoteContext note(int i) {
			return getRuleContext(NoteContext.class,i);
		}
		public List<NoteContext> note() {
			return getRuleContexts(NoteContext.class);
		}
		public TerminalNode OPENBRAC() { return getToken(ABCMusicParser.OPENBRAC, 0); }
		public TerminalNode CLOSEBRAC() { return getToken(ABCMusicParser.CLOSEBRAC, 0); }
		public ChordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitChord(this);
		}
	}

	public final ChordContext chord() throws RecognitionException {
		ChordContext _localctx = new ChordContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_chord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); match(OPENBRAC);
			setState(163); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(162); note();
				}
				}
				setState(165); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BASENOTE) | (1L << REST) | (1L << ACCIDENTAL))) != 0) );
			setState(167); match(CLOSEBRAC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TupletspecContext extends ParserRuleContext {
		public TerminalNode OPENPAREN() { return getToken(ABCMusicParser.OPENPAREN, 0); }
		public TerminalNode NUMBER() { return getToken(ABCMusicParser.NUMBER, 0); }
		public TupletspecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupletspec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterTupletspec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitTupletspec(this);
		}
	}

	public final TupletspecContext tupletspec() throws RecognitionException {
		TupletspecContext _localctx = new TupletspecContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_tupletspec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); match(OPENPAREN);
			setState(170); match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TupletelementContext extends ParserRuleContext {
		public TupletspecContext tupletspec() {
			return getRuleContext(TupletspecContext.class,0);
		}
		public NoteelementContext noteelement(int i) {
			return getRuleContext(NoteelementContext.class,i);
		}
		public List<NoteelementContext> noteelement() {
			return getRuleContexts(NoteelementContext.class);
		}
		public TupletelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupletelement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterTupletelement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitTupletelement(this);
		}
	}

	public final TupletelementContext tupletelement() throws RecognitionException {
		TupletelementContext _localctx = new TupletelementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_tupletelement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(172); tupletspec();
			setState(174); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(173); noteelement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(176); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LyricwordContext extends ParserRuleContext {
		public List<TerminalNode> OCTAVE() { return getTokens(ABCMusicParser.OCTAVE); }
		public List<TerminalNode> BASENOTE() { return getTokens(ABCMusicParser.BASENOTE); }
		public List<TerminalNode> LYRICELEMENT() { return getTokens(ABCMusicParser.LYRICELEMENT); }
		public TerminalNode OCTAVE(int i) {
			return getToken(ABCMusicParser.OCTAVE, i);
		}
		public TerminalNode REST(int i) {
			return getToken(ABCMusicParser.REST, i);
		}
		public TerminalNode LYRICELEMENT(int i) {
			return getToken(ABCMusicParser.LYRICELEMENT, i);
		}
		public List<TerminalNode> REST() { return getTokens(ABCMusicParser.REST); }
		public TerminalNode BASENOTE(int i) {
			return getToken(ABCMusicParser.BASENOTE, i);
		}
		public LyricwordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lyricword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterLyricword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitLyricword(this);
		}
	}

	public final LyricwordContext lyricword() throws RecognitionException {
		LyricwordContext _localctx = new LyricwordContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_lyricword);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(179); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(178);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BASENOTE) | (1L << REST) | (1L << OCTAVE) | (1L << LYRICELEMENT))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(181); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LyricContext extends ParserRuleContext {
		public List<TerminalNode> CLOSEPAREN() { return getTokens(ABCMusicParser.CLOSEPAREN); }
		public TerminalNode NUMBER(int i) {
			return getToken(ABCMusicParser.NUMBER, i);
		}
		public LyricwordContext lyricword(int i) {
			return getRuleContext(LyricwordContext.class,i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(ABCMusicParser.NUMBER); }
		public TerminalNode SPACE(int i) {
			return getToken(ABCMusicParser.SPACE, i);
		}
		public List<TerminalNode> BARLINE() { return getTokens(ABCMusicParser.BARLINE); }
		public TerminalNode OPENPAREN(int i) {
			return getToken(ABCMusicParser.OPENPAREN, i);
		}
		public List<TerminalNode> ACCIDENTAL() { return getTokens(ABCMusicParser.ACCIDENTAL); }
		public TerminalNode ACCIDENTAL(int i) {
			return getToken(ABCMusicParser.ACCIDENTAL, i);
		}
		public TerminalNode LYRICSYMBOL(int i) {
			return getToken(ABCMusicParser.LYRICSYMBOL, i);
		}
		public List<LyricwordContext> lyricword() {
			return getRuleContexts(LyricwordContext.class);
		}
		public TerminalNode BARLINE(int i) {
			return getToken(ABCMusicParser.BARLINE, i);
		}
		public List<TerminalNode> OPENPAREN() { return getTokens(ABCMusicParser.OPENPAREN); }
		public TerminalNode CLOSEPAREN(int i) {
			return getToken(ABCMusicParser.CLOSEPAREN, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(ABCMusicParser.SPACE); }
		public List<TerminalNode> LYRICSYMBOL() { return getTokens(ABCMusicParser.LYRICSYMBOL); }
		public LyricContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lyric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).enterLyric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ABCMusicListener ) ((ABCMusicListener)listener).exitLyric(this);
		}
	}

	public final LyricContext lyric() throws RecognitionException {
		LyricContext _localctx = new LyricContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_lyric);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); match(1);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << BASENOTE) | (1L << REST) | (1L << OCTAVE) | (1L << ACCIDENTAL) | (1L << BARLINE) | (1L << OPENPAREN) | (1L << CLOSEPAREN) | (1L << SPACE) | (1L << LYRICSYMBOL) | (1L << LYRICELEMENT))) != 0)) {
				{
				setState(192);
				switch (_input.LA(1)) {
				case BASENOTE:
				case REST:
				case OCTAVE:
				case LYRICELEMENT:
					{
					setState(184); lyricword();
					}
					break;
				case LYRICSYMBOL:
					{
					setState(185); match(LYRICSYMBOL);
					}
					break;
				case NUMBER:
					{
					setState(186); match(NUMBER);
					}
					break;
				case ACCIDENTAL:
					{
					setState(187); match(ACCIDENTAL);
					}
					break;
				case BARLINE:
					{
					setState(188); match(BARLINE);
					}
					break;
				case OPENPAREN:
					{
					setState(189); match(OPENPAREN);
					}
					break;
				case CLOSEPAREN:
					{
					setState(190); match(CLOSEPAREN);
					}
					break;
				case SPACE:
					{
					setState(191); match(SPACE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3\35\u00c8\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t"+
		"\27\4\30\t\30\4\31\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\3\3\3\7\3;\n\3\f\3"+
		"\16\3>\13\3\3\3\3\3\7\3B\n\3\f\3\16\3E\13\3\3\3\3\3\3\4\6\4J\n\4\r\4\16"+
		"\4K\3\5\6\5O\n\5\r\5\16\5P\3\5\3\5\3\5\3\5\5\5W\n\5\3\5\3\5\3\5\5\5\\"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\5\6c\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0084\n\17\3\20\3\20\3\21\3\21\5\21"+
		"\u008a\n\21\3\22\3\22\5\22\u008e\n\22\3\23\3\23\5\23\u0092\n\23\3\24\5"+
		"\24\u0095\n\24\3\24\3\24\5\24\u0099\n\24\3\25\5\25\u009c\n\25\3\25\3\25"+
		"\5\25\u00a0\n\25\5\25\u00a2\n\25\3\26\3\26\6\26\u00a6\n\26\r\26\16\26"+
		"\u00a7\3\26\3\26\3\27\3\27\3\27\3\30\3\30\6\30\u00b1\n\30\r\30\16\30\u00b2"+
		"\3\31\6\31\u00b6\n\31\r\31\16\31\u00b7\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\7\32\u00c3\n\32\f\32\16\32\u00c6\13\32\3\32\2\33\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\13\3\31\32\3\31\32\3"+
		"\31\32\3\31\32\3\31\32\3\31\32\3\31\32\3\31\32\4\r\17\34\34\u00d3\2\64"+
		"\3\2\2\2\48\3\2\2\2\6I\3\2\2\2\b[\3\2\2\2\nb\3\2\2\2\fd\3\2\2\2\16g\3"+
		"\2\2\2\20j\3\2\2\2\22m\3\2\2\2\24p\3\2\2\2\26s\3\2\2\2\30v\3\2\2\2\32"+
		"y\3\2\2\2\34\u0083\3\2\2\2\36\u0085\3\2\2\2 \u0089\3\2\2\2\"\u008b\3\2"+
		"\2\2$\u0091\3\2\2\2&\u0094\3\2\2\2(\u009b\3\2\2\2*\u00a3\3\2\2\2,\u00ab"+
		"\3\2\2\2.\u00ae\3\2\2\2\60\u00b5\3\2\2\2\62\u00b9\3\2\2\2\64\65\5\4\3"+
		"\2\65\66\5\6\4\2\66\67\7\1\2\2\67\3\3\2\2\28<\5\f\7\29;\7\32\2\2:9\3\2"+
		"\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?C\5\16\b\2@B\5"+
		"\34\17\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2F"+
		"G\5\32\16\2G\5\3\2\2\2HJ\5\b\5\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2"+
		"\2L\7\3\2\2\2MO\5\n\6\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QR\3\2"+
		"\2\2RV\7\31\2\2ST\5\62\32\2TU\7\31\2\2UW\3\2\2\2VS\3\2\2\2VW\3\2\2\2W"+
		"\\\3\2\2\2X\\\5\36\20\2Y\\\7\32\2\2Z\\\7\31\2\2[N\3\2\2\2[X\3\2\2\2[Y"+
		"\3\2\2\2[Z\3\2\2\2\\\t\3\2\2\2]c\5 \21\2^c\5.\30\2_c\7\21\2\2`c\7\22\2"+
		"\2ac\7\30\2\2b]\3\2\2\2b^\3\2\2\2b_\3\2\2\2b`\3\2\2\2ba\3\2\2\2c\13\3"+
		"\2\2\2de\7\4\2\2ef\t\2\2\2f\r\3\2\2\2gh\7\5\2\2hi\t\3\2\2i\17\3\2\2\2"+
		"jk\7\n\2\2kl\t\4\2\2l\21\3\2\2\2mn\7\6\2\2no\t\5\2\2o\23\3\2\2\2pq\7\7"+
		"\2\2qr\t\6\2\2r\25\3\2\2\2st\7\b\2\2tu\t\7\2\2u\27\3\2\2\2vw\7\t\2\2w"+
		"x\t\b\2\2x\31\3\2\2\2yz\7\13\2\2z{\t\t\2\2{\33\3\2\2\2|\u0084\5\22\n\2"+
		"}\u0084\5\24\13\2~\u0084\5\26\f\2\177\u0084\5\30\r\2\u0080\u0084\5\20"+
		"\t\2\u0081\u0084\7\32\2\2\u0082\u0084\7\31\2\2\u0083|\3\2\2\2\u0083}\3"+
		"\2\2\2\u0083~\3\2\2\2\u0083\177\3\2\2\2\u0083\u0080\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0082\3\2\2\2\u0084\35\3\2\2\2\u0085\u0086\5\20\t\2\u0086"+
		"\37\3\2\2\2\u0087\u008a\5\"\22\2\u0088\u008a\5*\26\2\u0089\u0087\3\2\2"+
		"\2\u0089\u0088\3\2\2\2\u008a!\3\2\2\2\u008b\u008d\5$\23\2\u008c\u008e"+
		"\5(\25\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e#\3\2\2\2\u008f"+
		"\u0092\5&\24\2\u0090\u0092\7\16\2\2\u0091\u008f\3\2\2\2\u0091\u0090\3"+
		"\2\2\2\u0092%\3\2\2\2\u0093\u0095\7\20\2\2\u0094\u0093\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\7\r\2\2\u0097\u0099\7\17\2\2"+
		"\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\'\3\2\2\2\u009a\u009c\7"+
		"\f\2\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u00a1\3\2\2\2\u009d"+
		"\u009f\7\27\2\2\u009e\u00a0\7\f\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3"+
		"\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009d\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		")\3\2\2\2\u00a3\u00a5\7\23\2\2\u00a4\u00a6\5\"\22\2\u00a5\u00a4\3\2\2"+
		"\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9"+
		"\3\2\2\2\u00a9\u00aa\7\24\2\2\u00aa+\3\2\2\2\u00ab\u00ac\7\25\2\2\u00ac"+
		"\u00ad\7\f\2\2\u00ad-\3\2\2\2\u00ae\u00b0\5,\27\2\u00af\u00b1\5 \21\2"+
		"\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3"+
		"\3\2\2\2\u00b3/\3\2\2\2\u00b4\u00b6\t\n\2\2\u00b5\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\61\3\2\2"+
		"\2\u00b9\u00c4\7\3\2\2\u00ba\u00c3\5\60\31\2\u00bb\u00c3\7\33\2\2\u00bc"+
		"\u00c3\7\f\2\2\u00bd\u00c3\7\20\2\2\u00be\u00c3\7\21\2\2\u00bf\u00c3\7"+
		"\25\2\2\u00c0\u00c3\7\26\2\2\u00c1\u00c3\7\30\2\2\u00c2\u00ba\3\2\2\2"+
		"\u00c2\u00bb\3\2\2\2\u00c2\u00bc\3\2\2\2\u00c2\u00bd\3\2\2\2\u00c2\u00be"+
		"\3\2\2\2\u00c2\u00bf\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3"+
		"\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\63\3\2\2"+
		"\2\u00c6\u00c4\3\2\2\2\27<CKPV[b\u0083\u0089\u008d\u0091\u0094\u0098\u009b"+
		"\u009f\u00a1\u00a7\u00b2\u00b7\u00c2\u00c4";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}