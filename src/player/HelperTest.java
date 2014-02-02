package player;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelperTest {
    
    // Boundaries for LCM Test: odd numbers, even numbers, 0 and another number.

    @Test
    public void lcmOddTest(){
        int methodAnswer = Helper.lcm(5, 3);
        int actualAnswer = 15;
        assertEquals(true, methodAnswer == actualAnswer);
        }
        
    @Test
    public void lcmZeroTest(){
        int methodAnswer = Helper.lcm(0, 3);
        int actualAnswer = 0;
        assertEquals(true, methodAnswer == actualAnswer);
        }
        
    @Test
    public void lcmEvenTest(){
        int methodAnswer = Helper.lcm(4, 8);
        int actualAnswer = 8;
        assertEquals(true, methodAnswer == actualAnswer);
        }
    
 // Boundaries for GCD Test: odd numbers, even numbers, 0 and another number.
    
    @Test
    public void gcdOddTest(){
        int methodAnswer = Helper.gcd(5, 3);
        int actualAnswer = 1;
        assertEquals(true, methodAnswer == actualAnswer);
        }
        
    @Test
    public void gcdZeroTest(){
        int methodAnswer = Helper.gcd(0, 3);
        int actualAnswer = 3;
        assertEquals(true, methodAnswer == actualAnswer);
        }
        
    @Test
    public void gcdEvenTest(){
        int methodAnswer = Helper.gcd(4, 8);
        int actualAnswer = 4;
        assertEquals(true, methodAnswer == actualAnswer);
        }
}
