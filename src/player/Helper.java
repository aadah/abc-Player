package player;

public class Helper {
    
    /**
     * returns the greatest common divider of two integers
     * 
     * @param integer a
     * @param integer b
     * @return integer representing the greatest common divider of the two input integers
     * 
     */
    
    public static int gcd(int a, int b)
    {
        while (b > 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    /**
     * returns the Least Common Multiple of two integers
     * 
     * @param integer a
     * @param integer b
     * @return integer representing the least common multiple of the two input integers
     * 
     */
    public static int lcm(int a, int b)
    {
        return a * (b / gcd(a, b));
    }
    
    /**
     * removes any unnecessary whitespace from a string
     * 
     * @param string the string to format
     * @return a string with preceding/trailing whitespace removed
     */
    public static String trimWhitespace(String string) {
        while (string.substring(0,1).equals(" ")) {
            string = string.substring(1);
        }
        while (string.substring(string.length()-1).equals(" ")) {
            string = string.substring(0,string.length()-1);
        }
        return string;
    }
    
    /**
     * a function for determining whether a string is in a given list of strings
     * 
     * @param string the string to check for
     * @param list contains string to check against
     * @return true if the string is in the list, false otherwise
     */
    public static boolean listContainsString(String string, String[] list) {
        for (String s : list) {
            if (string.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
