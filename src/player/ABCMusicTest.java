package player;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

/**
 * Music Tests that didit cannot play
 * @category no_didit
 */
public class ABCMusicTest {

    //@Test
    public void testHeyJude() {
        try {
            playMusic("sample_abc/HeyJude.abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
 //   @Test
    public void testJingleBells() {
        try {
            playMusic("sample_abc/JingleBells.abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    //@Test
    public void testMaryHadALittleLamb() {
        try {
            playMusic("sample_abc/MaryHadALittleLamb.abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
   // @Test
    public void testabc_Song() {
        try {
            playMusic("sample_abc/abc_song.abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
  //  @Test
    public void testAmazingGrace() {
        try {
            playMusic("sample_abc/piece3.abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    //@Test
    public void testRockYou() {
        try {
            playMusic("sample_abc/Queen.abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    //@Test
    public void testVivaLaVida() {
        try {
            playMusic("sample_abc/VivaLaVida.abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    //@Test
    public void testAmericanPie() {
        try {
            playMusic("sample_abc/AmericanPie.abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
   // @Test
    public void testBarbieGirl() {
        try {
            playMusic("sample_abc/BarbieGirl.abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
   //@Test
    public void testFurElise() {
        try {
            playMusic("sample_abc/fur_elise.abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    //@Test
    public void testApologize() {
        try {
            playMusic("sample_abc/Apologize.abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    //@Test
    public void testWaxies_Dargle() {
        try {
            playMusic("sample_abc/waxies_dargle.abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
            
    }

    /**
     * Returns the string representing the parsed song
     * 
     * @param String filename
     *            the file that needs to be parsed
     *           
     * @return a string representing the parsed song
     * 
     */
public void playMusic(String fileName) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();
    while (line != null) {
        sb.append(line);
        sb.append('\n');
        line = br.readLine();
    }
    
    String text = sb.toString();
    br.close();

    Player player = new Player();
    Song s = (Song) player.parse(text);
    try {
        s.createPlayer().play();
    } catch (MidiUnavailableException e) {
        e.printStackTrace();
    }
  
}
}