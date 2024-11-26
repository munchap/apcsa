import java.util.Scanner;

public class madlibs {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Emotion: ");
        String wordOne = scanner.nextLine();

        System.out.println("Verb: ");
        String wordTwo = scanner.nextLine();

        System.out.println("Plural Noun: ");
        String wordThree = scanner.nextLine();

        System.out.println("Adjective: ");
        String wordFour = scanner.nextLine();

        System.out.println("Noun: ");
        String wordFive = scanner.nextLine();

        System.out.println("Adjective: ");
        String wordSix = scanner.nextLine();

        System.out.println("Jason stared at the math test, the numbers blurring as " + wordOne + " set in. Despite trying to " + wordTwo + ", the formulas never clicked, and he guessed at most of the " + wordThree + ". When the teacher returned the tests, the " + wordFour + " red \"F\" crushed his " + wordFive + ". Dreading the " + wordSix + " conversation with his parents, Jason promised himself he would do better next time, though doubt lingered.");
    }
}
