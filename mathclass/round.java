public class round {
    public static void roundMain() {

        double randomDouble = Math.random() * 9;
        System.out.println("Unrounded number: " + randomDouble);

        System.out.println(Math.round(randomDouble));
        System.out.println((int) (randomDouble + 0.5));
        System.out.printf("%.0f", randomDouble);
        
    }
}
