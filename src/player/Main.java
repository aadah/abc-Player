package player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.midi.MidiUnavailableException;

import player.Player;

/**
 * Main entry point of the application.
 */
public class Main {

    public static String fileName = "sample_abc/fur_elise.abc";
    
    /**
     * Reads the file using buffered reader and produces a String representation of the file 
     * Plays the String input of the ABC file as music
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();


        while (line != null) {
            sb.append(line);
            sb.append('\n');
            line = br.readLine();
        }
        
        String text = sb.toString();
        
        play(text);
        
        br.close();
    }
    
    /**
     * Plays the String input of the ABC file as music after parsing it to a song. 
     * 
     * @param String input
     *            The abc file as a string. May not be null.
     *            
     * @return A Player that plays the parsed abc file. 
     */
    public static void play(String input) {
        Player player = new Player();
        Song s = player.parse(input);
        s.printTitleAndAuthor();
        try {
            s.createPlayer().play();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

}


