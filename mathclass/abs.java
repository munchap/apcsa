public class abs {
    public static void absMain() {
        boolean isNegative;
        double randomDouble = (Math.random() * 41 - 20.5);
        int randomInt = (int) (Math.round(randomDouble));
    
        if (randomInt < 0) {
           isNegative = true;
        } else {
            isNegative = false;
        }
    
        System.out.println("Random number -20 through 20: " + randomInt);
    
        if (isNegative) {
            randomInt *= -1;
        }
    
        System.out.println("Absolute value: " + randomInt);
    }
}
