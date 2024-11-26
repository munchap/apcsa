import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Question:");
        String question = scanner.nextLine();
        
        Random random = new Random();
        int randomNumber = random.nextInt(20) + 1;

        String message = switch (randomNumber) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 -> positive(random);
            case 11, 12, 13, 14, 15 -> nonCommittal(random);
            case 16, 17, 18, 19, 20 -> negative(random);
            default -> "Error";
        };

        System.out.println(message);
    }

    public static String positive(Random random) {
        int randomPos = random.nextInt(10) + 1;
        return switch (randomPos) {
            case 1 -> "It is certain";
            case 2 -> "It is decidedly so";
            case 3 -> "Without a doubt";
            case 4 -> "Yes definitely";
            case 5 -> "You may rely on it";
            case 6 -> "As I see it, yes";
            case 7 -> "Most likely";
            case 8 -> "Outlook good";
            case 9 -> "Yes";
            case 10 -> "Signs point to yes";
            default -> "Error";
        };
    }

    public static String nonCommittal(Random random) {
        int randomNonCom = random.nextInt(5) + 1;
        return switch (randomNonCom) {
            case 1 -> "Reply hazy, try again";
            case 2 -> "Ask again later";
            case 3 -> "Better not tell you now";
            case 4 -> "Cannot predict now";
            case 5 -> "Concentrate and ask again";
            default -> "Error";
        };
    }

    public static String negative(Random random) {
        int randomNeg = random.nextInt(5) + 1;
        return switch (randomNeg) {
            case 1 -> "Don't count on it";
            case 2 -> "My reply is no";
            case 3 -> "My sources say no";
            case 4 -> "Outlook not so good";
            case 5 -> "Very doubtful";
            default -> "Error";
        };
    }
}