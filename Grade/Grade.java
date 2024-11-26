import java.util.ArrayList;
// import java.util.Scanner;
// import java.util.InputMismatchException;

public class Grade {
    public static String gradeMain(double input) {
        System.out.println(input + "%");
        //System.out.println("Letter grade: " + calculateGrade(input));
        return calculateGrade(input);
    }

    public static String calculateGrade(double percent) {

        ArrayList<String> grade = new ArrayList<>();

        if (percent >= 90) {
            grade.add("A");
        }
        else if (percent >= 80) {
            grade.add("B");
        }
        else if (percent >= 70) {
            grade.add("C");
        }
        else if (percent >= 60) {
            grade.add("D");
        }
        else {
            return "F";
        }

        if ((percent % 10) >= 8 || percent == 100) {
            grade.add("+");
        }
        else if ((percent % 10) < 3 && (percent % 10) != 0) {
            grade.add("-");
        }
        else {
            grade.add("");
        }
        
        return (String.join("", grade.get(0), grade.get(1)));
    }
}
