
/**
 * This class performs some basic word processing functions, 
 * namely find, remove, and replace.
 *
 * @author  (your name)
 * @version (today's date)
 */ 
public class WordProcessor
{
    /** Determines if item exists in phrase.
     *  Returns true if it does, false otherwise.  */
    public static boolean find(String phrase, String item) {
        return (phrase.contains(item));
    }

    /** Removes item from phrase.
     *  Returns phrase without item.  */    
    public static String remove(String phrase, String item) {
        return (phrase.replace(item, ""));
    }

    /** Replaces item in phrase with replacement.
     *  Returns phrase with replacement in place of item.  */
    public static String replace(String phrase, String item, String replacement) {
        return (phrase.replace(item, replacement));
    }
}
