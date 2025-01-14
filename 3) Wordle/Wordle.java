import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class represents an implementation of the popular Wordle game, where the user
 * attempts to guess a random five letter word within six tries
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wordle
{
    /** main method creates a new Wordle object */
    public static void main(String[] args)
    {
        new Wordle().run();
    }

    /** Initiates a new Wordle game */
    public void run()
    {
        wordle.addEnterListener((guess) -> enterAction(guess));
    }

    /** Wordle instance variables */
    private WordleGUI wordle;
    private ArrayList<String> validWords;
    private String secretWord;

    /** Wordle constuctor */
    public Wordle()
    {
        wordle = new WordleGUI();
        loadValidWords();
        secretWord = pickSecretWord();        
    }

    /** Method called whenever the Return key is pressed
     *  or Enter button is tapped */
    private void enterAction(String guess)
    {
        if(validWords.contains(guess))
        {
            if(checkLetters(guess))
                wordle.showMessage("Success!");
            else if (wordle.getCurrentRow() < wordle.N_ROWS - 1)
                wordle.setCurrentRow(wordle.getCurrentRow() + 1);
            else
                wordle.showMessage(secretWord);
        }
        else
            wordle.showMessage("Not in word list");

    }

    /** Checks each letter of guess to secretWord 
     *  and colors each letter displayed appropriately.
     *  Returns true if guess is secretWord, false otherwise. */
    private boolean checkLetters(String guess)
    {
        setAllLettersToMissing();
        if(findCorrectLetters(guess))
            return true;
        findPresentLetters(guess);
        return false;
    }

    /** Set all letters to missing (gray) color */
    private void setAllLettersToMissing()
    {
        int row = wordle.getCurrentRow();
        for (int col = 0; col < WordleGUI.N_COLS; col++) {
            String letter = wordle.getSquareLetter(row, col);
            wordle.setSquareColor(row, col, wordle.MISSING_COLOR);
            wordle.setKeyColor(letter, wordle.MISSING_COLOR);
        }
        //throw new RuntimeException("Insert Step 0 code here");    // replace this line
    }

    /** Set correctly placed letters to correct (green) color */
    private boolean findCorrectLetters(String guess)
    {
        int row = wordle.getCurrentRow();
        for (int col = 0; col < WordleGUI.N_COLS; col++) {  
            if (guess.substring(col, col + 1).equals(secretWord.substring(col, col + 1))) {

                String g = guess.substring(col, col + 1); // Letter from guess
                String s = secretWord.substring(col, col + 1); // Letter from secretWord

                if (g.equals(s)) {
                    wordle.setSquareColor(row, col, WordleGUI.CORRECT_COLOR);
                    wordle.setKeyColor(g, WordleGUI.CORRECT_COLOR);
                }
            }
        }
        return guess.equals(secretWord);
        //throw new RuntimeException("Insert Step 1 code here");    // replace this line
    }

    /** count the number of present letters */
    private int presentLetterCount(String letter)
    {
        int row = wordle.getCurrentRow();
        int letterCounter = 0;
        int letterColumn = secretWord.indexOf(letter);
        while (letterColumn >= 0) {
            if (wordle.getSquareColor(row, letterColumn) != wordle.CORRECT_COLOR)
                letterCounter++;
            letterColumn = secretWord.indexOf(letter, letterColumn + 1);
        }
        return letterCounter;
        //throw new RuntimeException("Insert Step 2 code here");    // replace this line
    }
    
    /** Set the appropriate number of present letters to present (yellow) color */
    private void findPresentLetters(String guess) {
        int row = wordle.getCurrentRow(); // Get the current row
        char[] guessArray = guess.toCharArray(); // Convert guess to char array
    
        for (char letter : guessArray) { // Loop through each letter in the guess
            int count = presentLetterCount(String.valueOf(letter)); // Initialize count for the present letter
            int col = 0; // Initialize col variable
    
            while (count > 0 && col < guessArray.length) { // While count > 0 and col within bounds
                if (letter == wordle.getSquareLetter(row, col).charAt(0)) { // Check if letter matches square letter
                    if (wordle.getSquareColor(row, col) == wordle.MISSING_COLOR) { // Check if square color is MISSING_COLOR
                        wordle.setSquareColor(row, col, wordle.PRESENT_COLOR); // Set square color to PRESENT_COLOR
                        
                        if (wordle.getKeyColor(String.valueOf(letter)) == wordle.MISSING_COLOR) { // Check if key color is MISSING_COLOR
                            wordle.setKeyColor(String.valueOf(letter), wordle.PRESENT_COLOR); // Set key color to PRESENT_COLOR
                        }
                    }
                    
                    if (wordle.getSquareColor(row, col) != wordle.CORRECT_COLOR) { // Ensure square color isn't CORRECT_COLOR
                        count--; // Decrement count
                    }
                }
                col++; // Increment col
            }
        }
    }
    

    /** Gets valid words */
    private void loadValidWords()
    {
        validWords = getWords("Valid Words.txt");
    }

    /** Gets possible Wordle Words and randomly selects one of them to be the secret word */
    private String pickSecretWord()
    {
        ArrayList<String> words = getWords("Wordle Words.txt");

        int random = (int)(Math.random() * words.size());
        return words.get(random);
    }

    /** Reads in words from a file */
    private ArrayList<String> getWords(String fileName)
    {
        ArrayList<String> words = new ArrayList<String>();
        try
        {
            Scanner reader = new Scanner(new File(fileName));
            while(reader.hasNext())
            {
                String word = reader.nextLine();
                words.add(word);
            }
            reader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(fileName + " file not found");
        }
        return words;
    }
}
