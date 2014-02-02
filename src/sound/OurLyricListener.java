package sound;

public class OurLyricListener implements LyricListener {

    /**
     * Prints the given lyric in the console.
     * 
     * @param text the text associated with the lyric
     */
    public void processLyricEvent(String text) {
        System.out.print(text);
    }
}
