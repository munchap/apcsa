import java.util.Scanner; 

public class quad {
    public static void quadMain() {
    
        System.out.println("Equation: ax^2 + bx + c");
        // Get values of a, b, and c
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        double a = scanner.nextDouble();
        
        System.out.println("Enter b: ");
        double b = scanner.nextDouble();

        System.out.println("Enter c: ");
        double c = scanner.nextDouble();

        // Calculate and print
        double results[] = quadraticFormula(a, b ,c);
        switch (results.length) {
            case 0:
                System.out.println("No real solutions.");
                break;
            case 1:
                System.out.println("One real solution: " + results[0]);
                break;
            case 2:
                System.out.println("Two real solutions: " + results[0] + " and " + results[1]);
                break;
            default:
                System.out.println("Unexpected number of solutions.");
                break;
        }
    }

    public static double[] quadraticFormula(double a, double b, double c) {

        // Find discriminant
        double discriminant = (Math.pow(b, 2) - (4 * a * c));
        if (discriminant < 0) {
            return new double[]{};
        }

        double sqrtDiscriminant = Math.sqrt(discriminant);
        double root1 = (-b + sqrtDiscriminant) / (2 * a);
        double root2 = (-b - sqrtDiscriminant) / (2 * a);
        
        if (root1 == root2) {
            return new double[]{root1};
        }

        return new double[]{root1, root2};
        }

}
