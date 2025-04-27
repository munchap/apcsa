import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListQuiz {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Questions> questionList = new ArrayList<>();

        addQuestions(questionList);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        int correctCounter = 0;
        int totalCounter = 0;
        for (Questions question : questionList) {
            question.printPrompt();
            question.printAnswers();
            System.out.print("Your best guess: ");
            char userAnswer = scan.nextLine().toUpperCase().charAt(0);
            char trueAnswer = question.getAnswer();

            if (userAnswer == trueAnswer) {
                System.out.println("Correct!");
                correctCounter++;
                totalCounter++;
            }
            else {
                System.out.println("WRONG!");
                totalCounter++;
            }
            System.out.println("------------------------------------");
        }

        System.out.println("You got " + correctCounter + " out of " + totalCounter + " questions correct.");
    }

    private static void addQuestions(ArrayList<Questions> questionList) {
        // Manually add questions here; everything else is too complicated
        questionList.add(new Question1());
        questionList.add(new Question2());
        questionList.add(new Question3());
        questionList.add(new Question4());
        questionList.add(new Question5());
    }
}
