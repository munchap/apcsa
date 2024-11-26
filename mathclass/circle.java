import java.util.Scanner;

public class circle {
    public static void circleMain() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter radius: ");
        double radius = scanner.nextDouble();

        System.out.println(circumference(radius));
        System.out.println(area(radius));
    }

    public static double circumference(double r) {
        final double pi = Math.PI;
        return (2 * pi * r);
    }

    public static double area(double r) {
        final double pi = Math.PI;
        r = Math.pow(r, 2);
        return (pi * r);
    }
}
