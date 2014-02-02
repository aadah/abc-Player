package player;

import grammar.ABCMusicBaseListener;
import grammar.ABCMusicParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.tree.TerminalNode;

import player.ABCMusic;

public class OurListener extends ABCMusicBaseListener {
    
    // map for containing all encountered header info
    private Map<String, Object> header = new HashMap<String, Object>();
    
    // since each Song needs a Voice, we have a default voice called VOICE 1 if the piece specifies none
    private String currentVoice = "VOICE 1";
    // each voice has its own stack of elements
    private Map<String,Stack<ABCMusic>> voiceStack = new HashMap<String,Stack<ABCMusic>>();
    // used for keeping track of how many elements need to put into a measure, while keeping a counter on measures too
    private Map<String,int[]> voiceCounter = new HashMap<String,int[]>();
    // an ordered list of the lyrics on a per line basis
    private List<String> lyrics = new ArrayList<String>();
    
    // for keeping the fundamental info on a note for later Note creation
    private Stack<Object> noteStack = new Stack<Object>();
    // for tracking whether an accidental is in effect for any given bar
    private Map<String,Object[]> accInfo = new HashMap<String, Object[]>();
    
    // self-explanatory booleans for knowing where in the tree we are
    private boolean inChord = false;
    private boolean inTuplet = false;
    
    // nth is true if we come across a 1th repeat. standby is the measure imediately before the 1th repeat
    private boolean nth = false;
    private Measure standby;
    
    // the final Song representing the whole piece, which is to be constructed
    private Song masterpiece;

    // returns the masterpiece
    public Song getABCMusic() {
        return masterpiece;
    }

    @Override // initializes some main things
    public void enterAbctune(ABCMusicParser.AbctuneContext ctx) {
        header.put("C", "Unknown"); // default composer = Unknown
        header.put("M", new int[] {4, 4}); // default meter = 4/4
        header.put("Q", 100); // default tempo = 100
        
        voiceStack.put(currentVoice, new Stack<ABCMusic>());
        voiceCounter.put(currentVoice, new int[] {0,0});
    }
    @Override // we extract the Voice objects and create the final Song masterpiece
    public void exitAbctune(ABCMusicParser.AbctuneContext ctx) {
        double meterValue = ((int[])header.get("M"))[0]*1.0/((int[])header.get("M"))[1];
        
        if (!header.containsKey("L")) {
            if (meterValue >= 0.75) {
                header.put("L", new int [] {1, 8}); // default note length = 1/8
            }
            else {
                header.put("L", new int [] {1, 16}); // default note length = 1/16
            }
        }
        
        List<Voice> voiceobjs = new ArrayList<Voice>();
        for (String voice : voiceStack.keySet()) {
            voiceobjs.add((Voice) voiceStack.get(voice).pop());
        }
        int numOfVoices = voiceobjs.size();
        Voice[] voices = new Voice[numOfVoices];
        for (int i = 0; i < numOfVoices; i++) {
            voices[i] = voiceobjs.get(i);
        }
        masterpiece = new Song(numOfVoices, voices, header);
    }

    @Override // switch to the new Voice
    public void enterMidtunefield(ABCMusicParser.MidtunefieldContext ctx) {
        // switch to new voice
        String rawvoice = ctx.fieldvoice().VOICE().getText().substring(2);
        rawvoice = Helper.trimWhitespace(rawvoice);
        currentVoice = rawvoice;
    }
    
    @Override // self-explanatory
    public void enterChord(ABCMusicParser.ChordContext ctx) {
        inChord = true;
    }
    
    @Override // create the Chord, adding a lyric if present
    public void exitChord(ABCMusicParser.ChordContext ctx) {
        int numOfNotes = ctx.note().size();
        Note[] notes = new Note[numOfNotes];
        String lyric = "";
        
        for (int i = numOfNotes - 1; i >= 0; i--) {
            notes[i] = (Note) voiceStack.get(currentVoice).pop();
        }
        
        if (lyrics.size() > 0) {
            lyric = lyrics.remove(0);
        }
        
        Chord chord = new Chord(numOfNotes, notes, lyric);
        
        voiceStack.get(currentVoice).push(chord);
        
        if (!inTuplet) {
            voiceCounter.get(currentVoice)[1] += 1;
        }
        
        inChord = false;
    }

    @Override // put the composer in the header
    public void enterFieldcomposer(ABCMusicParser.FieldcomposerContext ctx) {
        String rawComp = ctx.COMPOSER().getText().substring(2);
        rawComp = Helper.trimWhitespace(rawComp);
        
        header.put("C", rawComp);
    }

    @Override // we extract and format a list representing the lyrics for a certain line
    public void enterAbcline(ABCMusicParser.AbclineContext ctx) {
        if (ctx.lyric() != null) {
            int numOfChildren = ctx.lyric().getChildCount();
            
            String[] special = {"_","*","~","\\-","-","|","(",")"};
            String prev = "";
            String addon = "";
            for (int i = 1; i < numOfChildren; i++) {
                String lyric = ctx.lyric().getChild(i).getText();
                
                if (lyric.equals("_")) {
                    lyrics.add(lyrics.get(lyrics.size()-1));
                }
                else if (lyric.equals("*")) {
                    lyrics.add("");
                }
                else if (lyric.equals("~")) {
                    addon = lyrics.remove(lyrics.size()-1) + " ";
                }
                else if (lyric.equals("\\-")) {
                    addon = lyrics.remove(lyrics.size()-1);
                }
                else if (lyric.substring(0,1).equals(" ")) {
                    addon = " ";
                }
                else if (lyric.equals("-")) {
                    if (prev.equals("-") || prev.substring(0,1).equals(" ")) {
                        lyrics.add("-");
                    }
                }
                else if (!Helper.listContainsString(lyric, special) && !lyric.substring(0,1).equals(" ")) {
                    lyrics.add(addon+lyric);
                    addon = "";
                }
                prev = lyric;
            }
            lyrics.add(lyrics.remove(lyrics.size()-1) + "\n");
        }
    }
    
    @Override // reset the lyrics to empty since we've left that line
    public void exitAbcline(ABCMusicParser.AbclineContext ctx) {
        lyrics.clear();
    }
    
    @Override // for each voice, create the actual Voice object from its stack contents
    public void exitAbcmusic(ABCMusicParser.AbcmusicContext ctx) {
        if (voiceStack.get("VOICE 1").size() == 0) {
            voiceStack.remove("VOICE 1");
        }
        for (String voice : voiceStack.keySet()) {
            int numOfMeasures = voiceStack.get(voice).size();
            Measure[] measures = new Measure[numOfMeasures];
            for (int i = numOfMeasures - 1; i >= 0; i--) {
                measures[i] = (Measure) voiceStack.get(voice).pop();
            }
            Voice voiceobj = new Voice(voice, numOfMeasures, measures);
            voiceStack.get(voice).push(voiceobj);
            assert voiceStack.get(voice).size() == 1;
        }
    }

    @Override // acknowledge that a new voice exists, being careful not to overwrite things due to our grammar
    public void enterFieldvoice(ABCMusicParser.FieldvoiceContext ctx) {
        String rawvoice = ctx.VOICE().getText().substring(2);
        rawvoice = Helper.trimWhitespace(rawvoice);
        
        if (!voiceStack.containsKey(rawvoice)) {
            voiceStack.put(rawvoice, new Stack<ABCMusic>());
            voiceCounter.put(rawvoice, new int[] {0,0});
        }
    }

    @Override // find the meter of the piece and add it to the header
    public void enterFieldmeter(ABCMusicParser.FieldmeterContext ctx) {
        int num;
        int den;
        
        String rawMeter = ctx.METER().getText().substring(2);
        rawMeter = Helper.trimWhitespace(rawMeter);
        
        if (rawMeter.equals("C")) {
            num = 4;
            den = 4;
        }
        else if (rawMeter.equals("C|")) {
            num = 2;
            den = 2;
        }
        else {
            int indexOfDivide = rawMeter.indexOf('/');
            String numerator = rawMeter.substring(0,indexOfDivide);
            String denominator = rawMeter.substring(indexOfDivide + 1);
            num = Integer.parseInt(numerator);
            den = Integer.parseInt(denominator);
        }
        
        int[] meterFraction = {num, den};
        header.put("M", meterFraction);
        
    }

    @Override // find the tempo of the piece and add it to the header
    public void enterFieldtempo(ABCMusicParser.FieldtempoContext ctx) {
        int tempo;
        
        String rawTempo = ctx.TEMPO().getText().substring(2);
        rawTempo = Helper.trimWhitespace(rawTempo);
        
        int indexOfEquals = rawTempo.indexOf('=');
        rawTempo = rawTempo.substring(indexOfEquals + 1);
        
        tempo = Integer.parseInt(rawTempo);
        
        header.put("Q", tempo);
    }
    
    @Override // create a Note object using the data in noteStack and push it to the correct voice stack
    public void exitNote(ABCMusicParser.NoteContext ctx) {
        int[] fraction = (int[]) noteStack.pop();
        int oct = (int) noteStack.pop();
        char basenote = (char) noteStack.pop();
        int acc = (int) noteStack.pop();
        String lyric = "";
        
        if (!inChord && lyrics.size() > 0 && basenote != 'z') {
            lyric = lyrics.remove(0);
        }
        
        Note note = new Note(acc, basenote, oct, fraction, lyric);
        
        voiceStack.get(currentVoice).push(note);
        if (!inChord && !inTuplet) {
            voiceCounter.get(currentVoice)[1] += 1;
        }
    }

    @Override // here, we create Measure objects, using nth as a flag for repeats. also reset temporary accidentals
    public void enterElement(ABCMusicParser.ElementContext ctx) {
        if (ctx.BARLINE() != null) {
            for (String note : accInfo.keySet()) {
                accInfo.get(note)[0] = false;
            }
            String barline = ctx.BARLINE().getText();
            if (barline.equals("|") || barline.equals("||")) {
                int numOfElements = voiceCounter.get(currentVoice)[1];
                if (numOfElements > 0) {
                    ABCMusic[] elements = new ABCMusic[numOfElements];
                    for (int i = numOfElements - 1; i >= 0; i--) {
                        elements[i] = voiceStack.get(currentVoice).pop();
                    }
                    Measure measure = new Measure(numOfElements, elements);
                    voiceStack.get(currentVoice).push(measure);
                    voiceCounter.get(currentVoice)[0] += 1;
                    voiceCounter.get(currentVoice)[1] = 0;
                }
            }
            else if (barline.equals("[|") || barline.equals("|]") || barline.equals("|:")) {
                int numOfElements = voiceCounter.get(currentVoice)[1];
                if (numOfElements > 0) {
                    ABCMusic[] elements = new ABCMusic[numOfElements];
                    for (int i = numOfElements - 1; i >= 0; i--) {
                        elements[i] = voiceStack.get(currentVoice).pop();
                    }
                    Measure measure = new Measure(numOfElements, elements);
                    voiceStack.get(currentVoice).push(measure);
                    voiceCounter.get(currentVoice)[0] = 0;
                    voiceCounter.get(currentVoice)[1] = 0;
                }
            }
            else if (barline.equals(":|")) {
                int numOfElements = voiceCounter.get(currentVoice)[1];
                if (numOfElements > 0) {
                    ABCMusic[] elements = new ABCMusic[numOfElements];
                    for (int i = numOfElements - 1; i >= 0; i--) {
                        elements[i] = voiceStack.get(currentVoice).pop();
                    }
                    Measure measure = new Measure(numOfElements, elements);
                    voiceStack.get(currentVoice).push(measure);
                    voiceCounter.get(currentVoice)[0] += 1;
                    voiceCounter.get(currentVoice)[1] = 0;
                }
                
                int numOfMeasures = voiceCounter.get(currentVoice)[0];
                Measure[] measures = new Measure[numOfMeasures];
                for (int i = numOfMeasures - 1; i >= 0; i--) {
                    measures[i] = (Measure) voiceStack.get(currentVoice).pop();
                }
                for (int i = 0; i < 2*numOfMeasures; i++) {
                    voiceStack.get(currentVoice).push(measures[i%numOfMeasures]);
                }
                if (nth) {
                    voiceStack.get(currentVoice).push(standby);
                    nth = false;
                }
                voiceCounter.get(currentVoice)[0] = 0;
            }
        }
        else if (ctx.NTHREPEAT() != null) {
            String nthrepeat = ctx.NTHREPEAT().getText();
            if (nthrepeat.equals("[1")) {
                nth = true;
                standby = (Measure) voiceStack.get(currentVoice).pop();
                voiceStack.get(currentVoice).push(standby);
            }
        }
    }

    @Override // extract the title of the piece and add it to the header
    public void enterFieldtitle(ABCMusicParser.FieldtitleContext ctx) {
        String rawTitle = ctx.TITLE().getText().substring(2);
        rawTitle = Helper.trimWhitespace(rawTitle);
        
        header.put("T", rawTitle);
    }

    @Override // extract the index number of the piece and add it to the header
    public void enterFieldnumber(ABCMusicParser.FieldnumberContext ctx) {
        String rawIndex = ctx.INDEX().getText().substring(2);
        rawIndex = Helper.trimWhitespace(rawIndex);
        
        header.put("X", rawIndex);
    }

    @Override // if a rest, just add the default values to noteStack
    public void enterNoteorrest(ABCMusicParser.NoteorrestContext ctx) {
        if (ctx.REST() != null) {
            noteStack.push(0);
            noteStack.push('z');
            noteStack.push(0);
        }
    }

    @Override // determine the fraction of the note or rest and push it to noteStack
    public void enterNotelength(ABCMusicParser.NotelengthContext ctx) {
        int num;
        int den;
        
        List<TerminalNode> numbers = ctx.NUMBER();
        
        if (numbers.size() == 0) {
            if (ctx.DIVIDE() != null) {
                num = 1;
                den = 2;
            }
            else {
                num = 1;
                den = 1;
            }
        }
        else if (numbers.size() == 1) {
            if (ctx.DIVIDE() != null) {
                String raw = ctx.getText();
                if (raw.substring(raw.length()-1).equals("/")) {
                    num = Integer.parseInt(ctx.NUMBER().get(0).getText());
                    den = 2;
                }
                else {
                    num = 1;
                    den = Integer.parseInt(ctx.NUMBER().get(0).getText());
                }
            }
            else {
                num = Integer.parseInt(ctx.NUMBER().get(0).getText());
                den = 1;
            }
        }
        else {
            num = Integer.parseInt(ctx.NUMBER().get(0).getText());
            den = Integer.parseInt(ctx.NUMBER().get(1).getText());
        }

        int[] noteFraction = {num, den};
        
        noteStack.push(noteFraction);
    }
    
    @Override // extract the key of the piece and put it in the header
    public void enterFieldkey(ABCMusicParser.FieldkeyContext ctx) {
        String rawKey = ctx.KEY().getText().substring(2);
        rawKey = Helper.trimWhitespace(rawKey);
        
        header.put("K", rawKey);
    }
    
    @Override // self-explanatory
    public void enterTupletelement(ABCMusicParser.TupletelementContext ctx) {
        inTuplet = true;
    }
    
    @Override // create a Tuplet object, scaling its components appropriately, add add it to the correct voice stack
    public void exitTupletelement(ABCMusicParser.TupletelementContext ctx) {
        int numOfNotes = Integer.parseInt(ctx.tupletspec().NUMBER().getText());
        ABCMusic[] notes = new ABCMusic[numOfNotes];
        
        int[] scalar = new int[2];
        if (numOfNotes == 2) {
            scalar[0] = 3;
            scalar[1] = 2;
        }
        else if (numOfNotes == 3) {
            scalar[0] = 2;
            scalar[1] = 3;
        }
        else {
            scalar[0] = 3;
            scalar[1] = 4;
        }
        
        for (int i = numOfNotes - 1; i >= 0; i--) {
            ABCMusic note = voiceStack.get(currentVoice).pop();
            if (note instanceof Note) {
                notes[i] = ((Note) note).scaledNote(scalar);
            }
            else if (note instanceof Chord) {
                notes[i] = ((Chord) note).scaledChord(scalar);
            }
        }
        
        Tuplet tuplet = new Tuplet(numOfNotes, notes);
        
        voiceStack.get(currentVoice).push(tuplet);
        voiceCounter.get(currentVoice)[1] += 1;
        
        inTuplet = false;
    }

    @Override // extract the default note length and put it in the header
    public void enterFielddefaultlength(ABCMusicParser.FielddefaultlengthContext ctx) {
        int num;
        int den;
        
        String rawLength = ctx.LENGTH().getText().substring(2);
        rawLength = Helper.trimWhitespace(rawLength);

        int indexOfDivide = rawLength.indexOf('/');
        String numerator = rawLength.substring(0,indexOfDivide);
        String denominator = rawLength.substring(indexOfDivide + 1);
        num = Integer.parseInt(numerator);
        den = Integer.parseInt(denominator);
        
        int[] defaultLength = {num, den};
        
        header.put("L", defaultLength);
        
    }

    @Override // find the correct accidental, letter, and octave of a note
    public void enterPitch(ABCMusicParser.PitchContext ctx) {
        String rawBasenote = ctx.BASENOTE().getText();
        String uBasenote = rawBasenote.toUpperCase();

        String key = (String) header.get("K");
        
        int acc = 0;
        char basenote;
        int oct = 0;
        
        boolean hasAcc = false;
        
        // for sharps
        String[] range1 = {"F"};
        String[] range2 = {"F","C"};
        String[] range3 = {"F","C","G"};
        String[] range4 = {"F","C","G","D"};
        String[] range5 = {"F","C","G","D","A"};
        String[] range6 = {"F","C","G","D","A","E"};
        String[] range7 = {"F","C","G","D","A","E","B"};
        // for flats
        String[] range8 = {"B"};
        String[] range9 = {"B","E"};
        String[] range10 = {"B","E","A"};
        String[] range11 = {"B","E","A","D"};
        String[] range12 = {"B","E","A","D","G"};
        String[] range13 = {"B","E","A","D","G","C"};
        String[] range14 = {"B","E","A","D","G","C","F"};
        
        // finding the accidental
        if (ctx.ACCIDENTAL() != null) { // via direct accidental
            hasAcc = true;
            String rawAcc = ctx.ACCIDENTAL().getText();
            if (rawAcc.equals("^^")) {
                acc = 2;
            }
            else if (rawAcc.equals("^")) {
                acc = 1;
            }
            else if (rawAcc.equals("=")) {
                acc = 0;
            }
            else if (rawAcc.equals("_")) {
                acc = -1;
            }
            else if (rawAcc.equals("__")) {
                acc = -2;
            }
        }
        else { // via key signature
            // checking for sharp key signatures
            if ((key.equals("G") || key.equals("Em"))
                    && Helper.listContainsString(uBasenote, range1)) {
                acc = 1;
            }
            else if ((key.equals("D") || key.equals("Bm"))
                    && Helper.listContainsString(uBasenote, range2)) {
                acc = 1;
            }
            else if ((key.equals("A") || key.equals("F#m"))
                    && Helper.listContainsString(uBasenote, range3)) {
                acc = 1;
            }
            else if ((key.equals("E") || key.equals("C#m"))
                    && Helper.listContainsString(uBasenote, range4)) {
                acc = 1;
            }
            else if ((key.equals("B") || key.equals("G#m"))
                    && Helper.listContainsString(uBasenote, range5)) {
                acc = 1;
            }
            else if ((key.equals("F#") || key.equals("D#m"))
                    && Helper.listContainsString(uBasenote, range6)) {
                acc = 1;
            }
            else if ((key.equals("C#") || key.equals("A#m"))
                    && Helper.listContainsString(uBasenote, range7)) {
                acc = 1;
            }
            // checking for flat key signatures
            else if ((key.equals("F") || key.equals("Dm"))
                    && Helper.listContainsString(uBasenote, range8)) {
                acc = -1;
            }
            else if ((key.equals("Bb") || key.equals("Gm"))
                    && Helper.listContainsString(uBasenote, range9)) {
                acc = -1;
            }
            else if ((key.equals("Eb") || key.equals("Cm"))
                    && Helper.listContainsString(uBasenote, range10)) {
                acc = -1;
            }
            else if ((key.equals("Ab") || key.equals("Fm"))
                    && Helper.listContainsString(uBasenote, range11)) {
                acc = -1;
            }
            else if ((key.equals("Db") || key.equals("Bbm"))
                    && Helper.listContainsString(uBasenote, range12)) {
                acc = -1;
            }
            else if ((key.equals("Gb") || key.equals("Ebm"))
                    && Helper.listContainsString(uBasenote, range13)) {
                acc = -1;
            }
            else if ((key.equals("Cb") || key.equals("Abm"))
                    && Helper.listContainsString(uBasenote, range14)) {
                acc = -1;
            }
            else {
                acc = 0; // C major or A minor
            }
        }
        
        // finding the basenote (and octave)
        if (uBasenote.equals(rawBasenote)) {
            oct = 0;
        }
        else {
            oct = 1;
        }
        basenote = uBasenote.charAt(0);
        
        // finding (or rather, updating) the octave
        if (ctx.OCTAVE() != null) {
            String rawOct = ctx.OCTAVE().getText();
            for (int i = 0; i < rawOct.length(); i++) {
                if (rawOct.subSequence(i, i+1).equals("'")) {
                    oct += 1;
                }
                else if (rawOct.subSequence(i, i+1).equals(",")) {
                    oct -= 1;
                }
            }
        }
        
        // finally, if a direct accidental, hold it for the bar
        if (hasAcc) {
            accInfo.put(uBasenote, new Object[] {true,oct,acc});
        }
        else if (accInfo.containsKey(uBasenote)) { // or apply an accidental if present
            boolean isActive = (boolean) accInfo.get(uBasenote)[0];
            boolean sameOct = (int) accInfo.get(uBasenote)[1] == oct;
            if (isActive && sameOct) {
                acc = (int) accInfo.get(uBasenote)[2];
            }
        }
        
        // push everything to the stack
        noteStack.push(acc);
        noteStack.push(basenote);
        noteStack.push(oct);
    }
}
